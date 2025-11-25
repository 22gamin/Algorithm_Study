import java.io.*;
import java.util.*;

public class boj_11049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int len = 1; len < N; len++) {
            for (int i = 0; i + len < N; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int x = dp[i][k] + dp[k + 1][j] + arr[i][0] * arr[k][1] * arr[j][1];

                    dp[i][j] = Math.min(dp[i][j], x);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}
