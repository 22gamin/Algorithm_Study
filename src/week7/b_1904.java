package week7;

import java.util.*;
import java.io.*;

public class b_1904 {

        static int[] dp;

        static int fib(int n) {

            dp[0] = 1;
            dp[1] = 1;

            for(int i = 2; i<n+1; i++) {
                dp[i] = (dp[i-1]+dp[i-2])%15746;
            }
            return dp[n];
        }


        public static void main(String[] args) throws Exception{

            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();

            dp = new int[N+1];

            System.out.println(fib(N)%15746);
        }

    }
