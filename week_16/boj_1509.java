import java.util.*;
import java.io.*;

public class boj_1509 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = s.length();
        char[] arr = (" " + s).toCharArray();
        boolean[][] ispalin = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            ispalin[i][i] = true;
        }

        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) {
                ispalin[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int end = i + len - 1;
                if (arr[i] == arr[end] && ispalin[i + 1][end - 1]) {
                    ispalin[i][end] = true;
                }
            }
        }

        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 1; j <= i; j++) {
                if (ispalin[j][i] == true) {
                    dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                }
            }
        }

        System.out.println(dp[N]);
    }
}
