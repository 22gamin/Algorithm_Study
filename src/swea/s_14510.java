package swea;

import java.util.*;
import java.io.*;

public class s_14510 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc < T+1; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            for(int n = 0; n<N; n++){
                trees[n] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[n]);
            }
            //입력 끝

            int even=0, odd = 0;
            for(int i =0; i<N; i++){
                int diff = max-trees[i];

                even += diff/2;
                odd += diff%2;
            }

            if(even > odd){
                while(Math.abs(even-odd) > 1){
                    even--;
                    odd += 2;
                }
            }

            int result= 0;

            if(even > odd){
                result = even*2;
            }
            else if (even < odd){
                result = odd*2-1;
            }
            else {
                result = even+odd;
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}

