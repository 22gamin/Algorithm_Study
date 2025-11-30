package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17854 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 최대 공부시간
        int K = Integer.parseInt(st.nextToken()); // 과목 수

        int[] dp = new int[N + 1]; // dp[t] = 공부시간 t를 썼을 때의 최대 중요도

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken()); 
            int T = Integer.parseInt(st.nextToken()); 

            for (int t = N; t >= T; t--) {
                dp[t] = Math.max(dp[t], dp[t - T] + I);
            }
        }

        System.out.println(dp[N]); 
    }
}
