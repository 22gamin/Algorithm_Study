package week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B9084 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 동전 종류 수

            int[] coins = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine()); // 만들 금액

            // dp[x] = x원을 만드는 모든 방법 수
            int[] dp = new int[M + 1];
            dp[0] = 1; // 0원을 만드는 방법은 1가지 (아무 동전도 사용하지 않음)

            // 동전 순서대로 조합 누적
            for (int coin : coins) {
                for (int x = coin; x <= M; x++) {
                    dp[x] += dp[x - coin];
                }
            }

            System.out.println(dp[M]);
        }
    }
}
