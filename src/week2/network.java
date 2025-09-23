package week2;

import java.util.LinkedList;
import java.util.Queue;

public class network {

    class Solution {
        public int solution(int n, int[][] computers) {
            boolean[] visited = new boolean[n];
            int count = 0;

            Queue<Integer> queue = new LinkedList<>();

            //다 넣기
            for(int i = 0; i<n; i++){
                if (!visited[i]){
                    queue.add(i);
                    visited[i] = true;

                    while(!queue.isEmpty()){
                        int current = queue.poll();

                        for(int j = 0; j<n; j++){
                            if (!visited[j] && computers[current][j]==1){
                                visited[j] = true;
                                queue.add(j);
                            }
                        }
                    }
                    count ++;
                }
            }



            return count;
        }
    }
}
