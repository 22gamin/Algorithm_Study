package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5427 {
	
	static int w, h;
    static char[][] map;
    static int[][] fireTime; 
    static final int INF = 1_000_000_000;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static class Point {
        int r, c, t;
        Point(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fireTime = new int[h][w];

            Queue<Point> fireQ = new ArrayDeque<>();
            int startR = -1, startC = -1;

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    fireTime[i][j] = INF;

                    if (map[i][j] == '*') {
                        fireQ.add(new Point(i, j, 0));
                        fireTime[i][j] = 0;
                    } else if (map[i][j] == '@') {
                        startR = i;
                        startC = j;
                    }
                }
            }

            // 1. 불 BFS - 각 칸에 불이 언제 도착하는지 계산
            bfsFire(fireQ);

            // 2. 상근이 BFS - 불 시간을 고려하며 탈출 시도
            int ans = bfsPerson(startR, startC);

            if (ans == -1) out.append("IMPOSSIBLE\n");
            else out.append(ans).append('\n');
        }

        System.out.print(out);
	}
	
	 // 불 BFS
    static void bfsFire(Queue<Point> q) {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int t = cur.t;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (map[nr][nc] == '#') continue; // 벽에는 불 안 번짐
                if (fireTime[nr][nc] <= t + 1) continue; // 이미 더 빨리 도착한 불이 있음

                fireTime[nr][nc] = t + 1;
                q.add(new Point(nr, nc, t + 1));
            }
        }
    }

    // 상근이 BFS
    static int bfsPerson(int sr, int sc) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[h][w];

        q.add(new Point(sr, sc, 0));
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int t = cur.t;

            // 현재 위치가 이미 가장자리고, 한 번 더 나가면 탈출
            // 이동할 때 경계 밖으로 나가면 탈출로 처리
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 빌딩 밖으로 나가면 탈출 성공
                if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
                    return t + 1;
                }

                if (map[nr][nc] == '#') continue;       // 벽
                if (visited[nr][nc]) continue;          // 이미 방문
                // 불이 이 칸에 t+1보다 먼저 또는 동시에 오면 못 감
                if (fireTime[nr][nc] <= t + 1) continue;

                visited[nr][nc] = true;
                q.add(new Point(nr, nc, t + 1));
            }
        }

        // 큐가 빌 때까지 탈출 못 함
        return -1;
    }
}
