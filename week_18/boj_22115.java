import java.io.*;
import java.util.*;

public class boj_22115 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        Arrays.fill(dp, 100000001);
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int c = Integer.parseInt(st.nextToken());
            for (int j = K; j - c >= 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - c] + 1);
            }
        }

        if (dp[K] == 100000001)
            System.out.println(-1);
        else
            System.out.println(dp[K]);
    }
}
