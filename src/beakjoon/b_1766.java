package beakjoon;

import java.util.*;
import java.io.*;

public class b_1766 {
    static int N,M,must[];
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N+1; i++){
            list.add(new ArrayList<>());
        }
        must = new int[N+1];

        for(int m = 0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            list.get(first).add(next);
            must[next]++;
        }
        //입력 끝
        seq();

        for(int num : answer){
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
    static void seq(){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);

        for(int num = 1; num < N+1; num++){
            if (must[num] == 0){
                pq.add(num);
            }
        }

        while(!pq.isEmpty()){
            int curr = pq.poll();
            answer.add(curr);

            for(int num : list.get(curr)){
                must[num]--;

                if (must[num] == 0){
                    pq.add(num);
                }
            }
        }
    }
}
