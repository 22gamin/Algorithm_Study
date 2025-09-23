package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b_9461 {

    static long[] dp = new long[101];

    static long fun(int n) {


        dp[0] = dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for(int i = 6; i<n+1; i++) {
            dp[i] = dp[i-5] + dp[i-4] + dp[i-3];
        }

        return dp[n];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <T+1; tc++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(fun(N));
        }

    }

}

