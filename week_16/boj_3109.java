import java.io.*;
import java.util.*;

public class boj_3109 {
    static int[] dr = { -1, 0, 1 };
    static char[][] map;
    static int R, C;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static boolean dfs(int r, int c) {
        visited[r][c] = true;

        if (c == C - 1) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + 1;

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == '.') {
                if (dfs(nr, nc)) {
                    return true;
                }

            }
        }

        return false;
    }
}
