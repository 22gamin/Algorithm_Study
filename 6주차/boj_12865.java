import java.util.*;
import java.io.*;

public class boj_12865 {
    public static void main(String[] agrs) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품 수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        int[] dp = new int[K + 1]; // dp[w] = 무게 한도가 w일 때 최대 가치
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(st.nextToken()); // 현재 물건 무게
            int V = Integer.parseInt(st.nextToken()); // 현재 물건 가치

            for (int w = K; w >= W; w--) { // 역순으로 해서 같은 물건이 여러번 담기는거 방지
                // dp[w] = 현재 물건을 안담는거, V + dp[w - W] = 현재 물건을 담는거
                dp[w] = Math.max(dp[w], V + dp[w - W]);
            }
        }
        System.out.println(dp[K]);
    }
}
