package programmers;

import java.util.*;

public class queue {
    public int solution(int[] priorities, int location) {

        Queue<int[]> queue = new LinkedList<>();

        //싹다 넣기
        for (int i = 0; i< priorities.length; i ++){
            queue.add(new int[] {i,priorities[i]});
        }

        int count = 0;

        while (!queue.isEmpty()){
            int[] current = queue.poll();

            //큐에 현재보다 우선순위 높은게 있는지 확인
            boolean hasHigher = false;
            for (int[] q: queue){
                if (q[1]>current[1]){
                    hasHigher = true;
                    break;
                }
            }
            if (hasHigher){
                queue.add(current);
            } else {
                count ++;
                if (current[0] == location){
                    break;
                }
            }
        }

        return count;
    }
}
