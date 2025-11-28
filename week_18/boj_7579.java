import java.io.*;
import java.util.*;

public class boj_7579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[M + 1];
        int[] C = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
            sum += C[i];
        }

        int[] dp = new int[sum + 1];

        for (int i = 1; i <= N; i++) {
            int memory = A[i];
            int cost = C[i];
            for (int j = sum; j - C[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost] + memory);
            }
        }

        for (int i = 0; i <= sum; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                return;
            }
        }
    }
}
