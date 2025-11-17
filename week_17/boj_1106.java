import java.io.*;
import java.util.*;

public class boj_1106 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        int[] people = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            cost[i] = money;
            people[i] = p;
        }

        int[] dp = new int[C + 101];
        Arrays.fill(dp, 100000000);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = people[i]; j < C + 101; j++) {
                dp[j] = Math.min(dp[j], dp[j - people[i]] + cost[i]);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = C; i < C + 101; i++) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
