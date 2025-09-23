package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_1952 {
    static int[] cost,months;
    static int min_value;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc < T+1; tc++){

            cost = new int[4];
            months = new int[13];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<4; i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i<13; i++){
                months[i] = Integer.parseInt(st.nextToken());
            }

            //입력 끝 ---

            //DP 테이블 + dp[i]: i월까지 수영장을 이용하는 최소 비용
            int[] dp = new int[13];
            dp[0] = 0;   // 0월까지의 비용은 0원

            //dp계산
            //1월부터 12월까지 순차적으로 최소 비용 계산
            for (int i = 1; i <= 12; i++){
                // 해당 월을 1일권만으로 이용할 경우
                int option1 = dp[i-1] + (months[i] * cost[0]);

                //해당 월을 1달권으로 이용하는 경우
                int option2 = dp[i-1] + cost[1];

                //1일권과 1달권 중 더 저렴한 방법 선택
                dp[i] = Math.min(option1, option2);

                // 해당 월을 3달권의 마지막 달로 이용
                if (i>=3){
                    int option3 = dp[i-3] + cost[2];
                    dp[i] = Math.min(dp[i], option3);
                }
            }

            //최종 계산
            //1년권 비용과 비교
            int finalAnswer = Math.min(dp[12],cost[3]);

            sb.append("#").append(tc).append(" ").append(finalAnswer).append("\n");
        }
        System.out.print(sb.toString());
    }
}
