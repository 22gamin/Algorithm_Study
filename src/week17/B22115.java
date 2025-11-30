package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B22115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken());
        
        int[] c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        final int INF = 1_000_000_000;
        int[] dp = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            dp[i] = INF;
        }
        
        dp[0] = 0; 
        
        for (int i = 0; i < N; i++) {
            int caffeine = c[i];
            for (int sum = K; sum >= caffeine; sum--) {
                if (dp[sum - caffeine] != INF) {
                    dp[sum] = Math.min(dp[sum], dp[sum - caffeine] + 1);
                }
            }
        }

        if (dp[K] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}

