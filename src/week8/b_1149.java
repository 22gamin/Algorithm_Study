package week8;
import java.util.*;
import java.io.*;


public class b_1149 {

    static int N,cost[][],dp[][];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N+1][N+1];

        for(int n = 1; n<N+1; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int nn = 0; nn<3; nn++) {
                cost[n][nn] = Integer.parseInt(st.nextToken());
            }
        }

        //입력 끝
        dp = new int[N+1][N+1];

        for(int i = 0; i<N+1; i++) {
            for(int j = 0; j<N+1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        //0:빨, 1:초, 2:파
        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        for(int i = 2; i<N+1; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        int min = Math.min(dp[N][0], dp[N][1]);
        System.out.println(Math.min(min, dp[N][2]));
    }

}

