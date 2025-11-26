import java.io.*;
import java.util.*;

public class boj_2302 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        long ans = 1;
        int left = 0;
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(br.readLine());

            int len = v - left - 1;

            ans *= dp[len];

            left = v;
        }

        int last = N - left;
        ans *= dp[last];

        System.out.println(ans);
    }
}
