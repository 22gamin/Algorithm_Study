package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MOD = 9901;

        int[][] dp = new int[N + 1][3];

        dp[1][0] = 1; // 아무 것도 안 놓음
        dp[1][1] = 1; // 왼쪽에만
        dp[1][2] = 1; // 오른쪽에만

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        int ans = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
        System.out.println(ans);
    }
}

