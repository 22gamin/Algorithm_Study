import java.io.*;
import java.util.*;

public class boj_17845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            for (int j = N; j - T >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - T] + I);
            }
        }

        System.out.println(dp[N]);
    }
}
