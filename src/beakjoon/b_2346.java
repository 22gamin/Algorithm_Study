package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b_2346 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<N+1; i++){

            int balloon = Integer.parseInt(st.nextToken());
            deque.add(new int[] {i,balloon});

        }
        //입력 끝
        int[] curr = deque.pollFirst();
        sb.append(curr[0]).append(" ");
        int move = curr[1];

        while(!deque.isEmpty()){

            if (move > 0){
                for(int n = 0; n<move-1; n++){
                    int[] pass = deque.pollFirst();
                    deque.addLast(pass);
                }
                curr = deque.pollFirst();
            }
            else {
                for(int n = 0; n<Math.abs(move)-1; n++){
                    int[] pass = deque.pollLast();
                    deque.addFirst(pass);
                }
                curr = deque.pollLast();
            }
            sb.append(curr[0]).append(" ");
            move = curr[1];
        }
        System.out.println(sb);
    }
}
