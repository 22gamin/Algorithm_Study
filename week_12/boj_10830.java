import java.util.*;
import java.io.*;

public class boj_10830 {
    static int N;
    static long B;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] ans = power(arr, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    // 거듭제곱 분할정복
    public static int[][] power(int[][] mat, long cnt) {
        if (cnt == 1) {
            return mat;
        }

        // 반띵
        int[][] half = power(mat, cnt / 2);

        // 짝수
        int[][] result = multiply(half, half);

        // 홀수면 1번 더 곱하기
        if (cnt % 2 == 1) {
            result = multiply(result, arr);
        }

        return result;
    }

    // 행렬제곱
    public static int[][] multiply(int[][] a1, int[][] a2) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += a1[i][k] * a2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }
}
