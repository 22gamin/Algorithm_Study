package xweek21;

import java.io.*;

public class b_2156 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] wine = new int[N+1];
        int[] dp = new int[N+1];

        for(int i = 1; i<=N; i++){
            wine[i] = Integer.parseInt(br.readLine());
        } //입력 끝

        dp[1] = wine[1];

        if(N>1){
            dp[2] = wine[1] + wine[2];
        }

        //안 마심 -> 이전이랑 마신 포도주량이 같음 dp[i-1]
        //이번엔 마심(연속 1잔째) -> dp[i-2]+dp[i]
        //이번엔 마심(연속 2잔째) -> dp[i-3]+dp[i-1]+dp[n]
        for(int i = 3; i<=N; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[N]);
    }
}
