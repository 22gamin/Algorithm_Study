package week_19;

import java.io.*;
import java.util.*;

public class boj_2146 {
    static int N;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] dist;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
            }
        }

        int idx = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    number(i, j, idx++);
                }
            }
        }

        bfs();

        System.out.println(ans);
    }

    static void number(int r, int c, int idx) {
        Queue<p> q = new LinkedList<>();
        q.add(new p(r, c));
        map[r][c] = idx;

        while (!q.isEmpty()) {
            p cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = idx;
                        q.add(new p(nx, ny));
                    }
                }
            }
        }
    }

    static void bfs() {
        Queue<p> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1) {
                    q.add(new p(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            p cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    map[nx][ny] = map[cur.x][cur.y];
                    q.add(new p(nx, ny));
                } else if (map[nx][ny] != map[cur.x][cur.y]) {
                    ans = Math.min(ans, dist[cur.x][cur.y] + dist[nx][ny]);
                }
            }
        }
    }

    static class p {
        int x, y;

        p(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
