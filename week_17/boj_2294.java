import java.io.*;
import java.util.*;

public class boj_2294 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n + 1];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100001);

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            coin[i] = num;
        }

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        if (dp[k] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
