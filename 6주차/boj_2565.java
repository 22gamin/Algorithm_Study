import java.util.*;
import java.io.*;

public class boj_2565 {
    public static void main(String[] orgs) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 이걸 내가 어케 아노;;
        // A 전봇대 번호를 기준으로 정렬
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1]) { // B 전봇대 번호가 증가하면
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}
