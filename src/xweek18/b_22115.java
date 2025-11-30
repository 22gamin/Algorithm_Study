package xweek18;

import java.util.*;
import java.io.*;

public class b_22115 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];
        Arrays.fill(dp,100000001);
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int n = 0; n<N; n++){
            int c = Integer.parseInt(st.nextToken());

            for(int i = K; i>= c; i--){
                dp[i] = Math.min(dp[i], dp[i-c]+1);

            }
        }

        if(dp[K] == 100000001){
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}
