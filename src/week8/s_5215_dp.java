package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_5215_dp {
    static int N,L, score[], cal[];
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<T+1; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            score = new int[N+1];
            cal = new int[N+1];
            dp = new int[N+1][L+1];

            for(int i = 1; i<N+1; i++){
                st = new StringTokenizer(br.readLine());

                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            //입력 끝!!
            //knapsack문제!!!!!!!!
            dp[0][0] = 0;

            for(int i =1; i<=N; i++){
                for(int j = 1; j<=L; j++){
                    if (cal[i] > j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cal[i]]+score[i]);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(dp[N][L]).append("\n");
        }
        System.out.println(sb);
    }
}
