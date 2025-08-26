import java.io.*;
import java.util.*;

public class swea_1952 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int quarter = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            int[] plan = new int[13];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[13];

            for(int i = 1; i <= 12; i++){
                int cost1 = dp[i - 1] + day * plan[i];      //1일 이용권 비용
                int cost2 = dp[i - 1] + month;              //1달 이용권 비용
                int cost3 = Integer.MAX_VALUE;              //3달 이용권 비용
                if(i >= 3){
                    //1, 2월에는 3달 이용권을 사용하면 1월부터 시작해야 되니까 dp[0] 사용
                    cost3 = dp[i - 3] + quarter;
                }

                dp[i] = Math.min(cost1, Math.min(cost2, cost3));    //3개 중 제일 싼거
            }

            int ans = Math.min(dp[12], year);       //1년 이용권이랑 비교해서 더 싼거

            System.out.println("#" + tc + " " + ans);
        }
    }
}
