import java.io.*;
import java.util.*;

public class boj_9084 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] coin = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M + 1];
            dp[0] = 1;
            for (int i = 1; i <= N; i++) {
                for (int j = coin[i]; j <= M; j++) {
                    dp[j] += dp[j - coin[i]];
                }

            }
            sb.append(dp[M]).append('\n');
        }
        System.out.println(sb);
    }
}
