package beakjoon;

import java.util.*;
import java.math.*;
import java.io.*;

public class b_1793 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String line = br.readLine();
            if ( line == null) break;
            int n = Integer.parseInt(line);

            BigInteger[] dp = new BigInteger[251];


            dp[0] = new BigInteger("1");
            dp[1] = new BigInteger("1");
            dp[2] = new BigInteger("3");
            dp[3] = new BigInteger("5");


            for(int i = 4; i<n+1; i++) {
                dp[i] = dp[i-2].multiply(BigInteger.valueOf(2)).add(dp[i-1]);
            }

            System.out.println(dp[n]);
        }

    }

}

