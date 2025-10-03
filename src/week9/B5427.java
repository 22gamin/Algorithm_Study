package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5427 {
    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 열 (Width)
        int n = Integer.parseInt(st.nextToken()); // 행 (Height)
        char[][] map = new char[n][m];
        Queue<Pair> fire = new LinkedList<>();
        Queue<Pair> sangoun = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '*') fire.offer(new Pair(i, j));
                else if (map[i][j] == '@') sangoun.offer(new Pair(i, j));
            }
        }

        int time = 0;
        boolean chk = true; // true: 탈출 못함, false: 탈출 성공
        int[][] vis = new int[n][m];

        // 상근이가 존재할 경우에만 시작 위치 방문 처리
        if (!sangoun.isEmpty()) {
            vis[sangoun.peek().x][sangoun.peek().y] = 1;
        }

        while (!sangoun.isEmpty()) {
            time++;

            // 불 이동
            int firelen = fire.size();
            for (int i = 0; i < firelen; i++) {
                Pair firecur = fire.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = firecur.x + dx[d];
                    int ny = firecur.y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    // 불은 벽(#)이나 다른 불(*)이 아니면 퍼짐
                    if (map[nx][ny] != '#' && map[nx][ny] != '*') {
                        map[nx][ny] = '*';
                        fire.offer(new Pair(nx, ny));
                    }
                }
            }

            // 상근 이동
            int len = sangoun.size();
            for (int i = 0; i < len; i++) {
                Pair cur = sangoun.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    // [수정] 맵 밖으로 나가는 것이 바로 탈출 조건!
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        chk = false;
                        break;
                    }

                    // 방문했거나, 벽이거나, 불이면 이동 불가
                    if (vis[nx][ny] == 1 || map[nx][ny] == '#' || map[nx][ny] == '*') continue;

                    // 빈 공간('.')으로만 이동 가능
                    if (map[nx][ny] == '.') {
                        vis[nx][ny] = 1;
                        sangoun.offer(new Pair(nx, ny));
                    }
                }
                if (!chk) break;
            }
            if (!chk) break;
        }

        if (!chk) {
            System.out.println(time);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
