package week_20;

import java.io.*;
import java.util.*;

public class boj_1799 {
    static int N;
    static int[][] board;
    static int[] ans = new int[2];
    static boolean[] v1;
    static boolean[] v2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        v1 = new boolean[2 * N];
        v2 = new boolean[2 * N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Bishop(0, 0, 0);
        Bishop(1, 0, 1);

        System.out.println(ans[0] + ans[1]);
    }

    static void Bishop(int idx, int cnt, int color) {
        if (idx >= N * N) {
            ans[color] = Math.max(cnt, ans[color]);
            return;
        }

        // 행렬 좌표
        int r = idx / N;
        int c = idx % N;

        // 못 놓는 경우
        if (board[r][c] == 0 || (r + c) % 2 != color) {
            Bishop(idx + 1, cnt, color);
            return;
        }

        // 놓는 경우
        if (!v1[r + c] && !v2[r - c + N]) {
            v1[r + c] = true;
            v2[r - c + N] = true;

            Bishop(idx + 1, cnt + 1, color);

            v1[r + c] = false;
            v2[r - c + N] = false;
        }

        // 놓을 수 있는데 안 놓은 경우
        Bishop(idx + 1, cnt, color);
    }
}
