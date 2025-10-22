import java.util.*;
import java.io.*;

public class boj_9663 {
    static int[][] arr;
    static int N;
    static int cnt = 0;
    static boolean[] col; // 열
    static boolean[] diagU; // 오른쪽 아래 대각선
    static boolean[] diagD; // 오른쪽 위 대각선

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        col = new boolean[N];
        diagU = new boolean[N * 2];
        diagD = new boolean[N * 2];

        dfs(0);

        System.out.println(cnt);
    }

    public static void dfs(int r) {
        if (r == N) {
            cnt++;
            return;
        }

        // 다음 퀸 놓을 위치 찾기
        for (int c = 0; c < N; c++) {
            // 퀸을 놓을 수 없으면 넘어가기
            if (col[c] || diagU[r - c + N - 1] || diagD[r + c])
                continue;

            // 퀸 놓기
            col[c] = true;
            diagU[r - c + N - 1] = true;
            diagD[r + c] = true;

            // 다음 열로 넘어가기
            dfs(r + 1);

            // 백트래킹
            col[c] = false;
            diagU[r - c + N - 1] = false;
            diagD[r + c] = false;
        }
    }
}
