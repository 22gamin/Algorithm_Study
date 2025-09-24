package beakjoon;

import java.util.*;
import java.io.*;

public class b_28279 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a==1){
                int x = Integer.parseInt(st.nextToken());
                deque.addFirst(x);
            }
            else if (a==2){
                int x = Integer.parseInt(st.nextToken());
                deque.addLast(x);
            }
            else if (a==3){
                if (!deque.isEmpty()){
                    System.out.println(deque.pollFirst());
                } else{
                    System.out.println(-1);
                }
            }
            else if (a==4){
                if(!deque.isEmpty()){
                    System.out.println(deque.pollLast());
                } else  {
                    System.out.println(-1);
                }
            }
            else if (a==5){
                System.out.println(deque.size());
            }
            else if (a==6){
                if(!deque.isEmpty()) System.out.println(0);
                else System.out.println(1);
            }
            else if(a==7){
                if(!deque.isEmpty()){
                    System.out.println(deque.getFirst());
                } else{
                    System.out.println(-1);
                }
            }
            else if (a==8){
                if(!deque.isEmpty()){
                    System.out.println(deque.getLast());
                } else{
                    System.out.println(-1);
                }
            }
        }
    }
}
