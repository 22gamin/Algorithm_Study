package yweek2_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][3];
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            // 첫번째 포도주면
            if(i == 0) {
                dp[i][0] = 0;
                dp[i][1] = a;
                dp[i][2] = a;
            }
            // 그 외
            else{
                dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
                dp[i][1] = dp[i-1][0] + a;
                dp[i][2] = dp[i-1][1] + a;
            }
        }
        int maxnum = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
        System.out.println(maxnum);
    }
}
