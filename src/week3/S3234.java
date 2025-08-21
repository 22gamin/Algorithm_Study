package week3;

import java.io.*;
import java.util.*;

public class S3234 {
    static int N, total;
    static int[] weights;
    static int[] prefix; // 남은 무게 합 빠르게 계산
    static long answer;
    static long[][] dp; // [mask][leftSum]

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            weights = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            total = 0;
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
                total += weights[i];
            }

            Arrays.sort(weights); // 정렬하면 가지치기 효율 ↑
            prefix = new int[N + 1];
            for (int i = N - 1; i >= 0; i--) {
                prefix[i] = prefix[i + 1] + weights[i];
            }

            dp = new long[1 << N][total + 1];
            for (long[] row : dp) Arrays.fill(row, -1);

            answer = dfs(0, 0, 0);
            System.out.println("#" + tc + " " + answer);
        }
    }

    // idx = 사용한 개수, left = 왼쪽 무게, right = 오른쪽 무게
    static long dfs(int mask, int left, int right) {
        if (right > left) return 0;
        if (mask == (1 << N) - 1) return 1;

        if (dp[mask][left] != -1) return dp[mask][left];
        long res = 0;
        int idx = Integer.bitCount(mask); // 지금까지 사용한 개수
        int remain = prefix[idx]; // 아직 안 쓴 무게들의 합

        // 가지치기: 남은 전부 오른쪽에 올려도 OK → 경우수 한 번에 계산
        if (right + remain <= left) {
            int remainCnt = N - idx;
            long fact = factorial(remainCnt);
            long pow2 = 1L << remainCnt;
            return dp[mask][left] = fact * pow2;
        }

        // 다음 무게 고르기
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) continue;

            // 왼쪽
            res += dfs(mask | (1 << i), left + weights[i], right);
            // 오른쪽
            res += dfs(mask | (1 << i), left, right + weights[i]);
        }
        return dp[mask][left] = res;
    }

    static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}