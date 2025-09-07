package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B24460 {

	static int N;
    static int[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve(0, 0, N));
    }

    // (r, c)에서 시작하는 size x size 정사각형의 결과값
    static int solve(int r, int c, int size) {
        if (size == 1) return A[r][c];

        int half = size / 2;
        int v1 = solve(r, c, half);
        int v2 = solve(r, c + half, half);
        int v3 = solve(r + half, c, half);
        int v4 = solve(r + half, c + half, half);

        int[] arr = {v1, v2, v3, v4};
        Arrays.sort(arr);          // 오름차순
        return arr[1];             // 두 번째로 작은 값
    }

}
