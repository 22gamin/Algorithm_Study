package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B2705 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        final int MAXN = 1000;

        List<Integer> coins = new ArrayList<>();
        for (int v = 1; v <= MAXN; v <<= 1) coins.add(v);

        BigInteger[] dp = new BigInteger[MAXN + 1];
        Arrays.fill(dp, BigInteger.ZERO);
        dp[0] = BigInteger.ONE;

        for (int coin : coins) {
            for (int s = coin; s <= MAXN; s++) {
                dp[s] = dp[s].add(dp[s - coin]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            sb.append(dp[N]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
