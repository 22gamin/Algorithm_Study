package week7;

import java.util.*;
import java.io.*;

public class b_1912 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] seq = new int[n];
        for(int i = 0; i<n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];

        dp[0] = seq[0];

        int max = dp[0];

        for(int i = 1; i<n; i++) {
            dp[i] = Math.max(seq[i], dp[i-1]+seq[i]);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

}

