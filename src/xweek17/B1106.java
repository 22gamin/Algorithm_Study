package xweek17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 비용, 비용으로 얻을 수 있는 고객 수
        int [] cost = new int[n];
        int [] person = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            person[i] = Integer.parseInt(st.nextToken());
        }

        // 앱..
        int[] dp = new int[100001];
        // 비용이 중복으로 가능해야함 -> 순서대로
        for(int i=0; i<cost.length; i++){
            // 각각 비용에 대해 최대 고객 수 찾기
            for(int w = cost[i]; w<dp.length; w++){
                // dp[현재 - 현재 도시비용]
                // cost[i] = 3이고 사람 수 3일때(처음 돌아갈때)
                // w = 3, 6, 9 ... dp[w] = 3, 6, 9 ... -> 중복 처리 가능
                // 중간 4, 5 는 w = 3 과 같이 처리 : 안 나눠떨어지니까
                dp[w] = Math.max(dp[w], dp[w - cost[i]] + person[i]);
            }
        }
        for(int i=0; i<dp.length; i++){
            if(dp[i]>=c){
                System.out.println(i);
                break;
            }
        }
    }
}
