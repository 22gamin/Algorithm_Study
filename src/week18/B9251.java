package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine().trim();
        String B = br.readLine().trim();

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            char a = A.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char b = B.charAt(j - 1);

                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
