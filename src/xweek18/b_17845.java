package xweek18;

import java.util.*;
import java.io.*;

public class b_17845 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];

        for(int k = 0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            for(int i = N; i>=T; i--){
                dp[i] = Math.max(dp[i],dp[i-T]+l);
            }
        }
        System.out.println(dp[N]);
    }
}
