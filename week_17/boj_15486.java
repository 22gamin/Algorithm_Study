import java.io.*;
import java.util.*;

public class boj_15486 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());

        }

        int[] dp = new int[N + 2];

        for (int i = 1; i <= N + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i != N + 1) {
                int idx = i + T[i];
                if (i + T[i] <= N + 1) {
                    dp[idx] = Math.max(dp[idx], dp[i] + P[i]);
                }
            }
        }

        System.out.println(dp[N + 1]);
    }
}
