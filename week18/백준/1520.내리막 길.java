import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] map;
    static int[][] dp;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static int dfs(int x, int y) {

        if (x == M - 1 && y == N - 1) return 1; // 도착점 도달

        if (dp[x][y] != -1) return dp[x][y]; // 이미 계산한 칸

        dp[x][y] = 0; // 초기값

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (map[nx][ny] < map[x][y]) { // 내리막 조건
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // 아직 계산 안 함
            }
        }

        System.out.println(dfs(0, 0));
    }
}
