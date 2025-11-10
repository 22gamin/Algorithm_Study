import java.util.*;
import java.io.*;

public class boj_17404 {
    public static final int max = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] color = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][3];

        dp[0][0] = color[0][0];
        dp[0][1] = max;
        dp[0][2] = max;

        for (int i = 1; i < N; i++) {
            if (i == N - 1) {
                dp[i][1] = dp[i - 1][2] + color[i][1];
                dp[i][2] = dp[i - 1][1] + color[i][2];
            }
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
        }
        int res1 = Math.min(dp[N - 1][1], dp[N - 1][2]);

        dp[0][0] = max;
        dp[0][1] = color[0][1];
        for (int i = 1; i < N; i++) {
            if (i == N - 1) {
                dp[i][0] = dp[i - 1][2] + color[i][0];
                dp[i][2] = dp[i - 1][0] + color[i][2];
            }
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
        }
        int res2 = Math.min(dp[N - 1][0], dp[N - 1][2]);

        dp[0][1] = max;
        dp[0][2] = color[0][2];
        for (int i = 1; i < N; i++) {
            if (i == N - 1) {
                dp[i][0] = dp[i - 1][1] + color[i][0];
                dp[i][1] = dp[i - 1][0] + color[i][1];
            }
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
        }
        int res3 = Math.min(dp[N - 1][0], dp[N - 1][1]);

        int ans = Math.min(res1, Math.min(res2, res3));
        System.out.println(ans);
    }
}
