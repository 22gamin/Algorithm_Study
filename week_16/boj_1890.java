import java.io.*;
import java.util.*;

public class boj_1890 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0)
                    continue;

                if (map[i][j] == 0)
                    continue;

                if (i == N - 1 && j == N - 1)
                    continue;

                int len = map[i][j];

                if (j + len < N)
                    dp[i][j + len] += dp[i][j];
                if (i + len < N)
                    dp[i + len][j] += dp[i][j];
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
