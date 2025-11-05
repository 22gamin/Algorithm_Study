import java.util.*;
import java.io.*;

public class boj_10942 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][N + 1];

        // s, e가 같은 경우는 항상 팰린드롬
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        // 길이가 2일 경우
        for (int i = 1; i < N; i++) {
            dp[i][i + 1] = (arr[i] == arr[i + 1]);
        }

        // 길이가 3 이상일 경우
        for (int len = 3; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                dp[i][i + len - 1] = (dp[i + 1][i + len - 2]) && (arr[i] == arr[i + len - 1]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            if (dp[S][E])
                sb.append(1);
            else
                sb.append(0);
            sb.append('\n');
        }

        System.out.println(sb);
    }

}
