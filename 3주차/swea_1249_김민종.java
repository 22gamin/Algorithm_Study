import java.io.*;
import java.util.*;

public class swea_1249_김민종 {
    static final int INF = 1_000_000_000;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r, c, cost;
        Node(int r, int c, int cost) { this.r = r; this.c = c; this.cost = cost; }
        public int compareTo(Node o) { return this.cost - o.cost; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0'; // 각 칸의 복구 비용(0~9)
                }
            }

            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) Arrays.fill(dist[i], INF);

            PriorityQueue<Node> pq = new PriorityQueue<>();
            dist[0][0] = map[0][0];
            pq.offer(new Node(0, 0, dist[0][0]));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (cur.cost != dist[cur.r][cur.c]) continue; // 오래된 항목 스킵
                if (cur.r == N - 1 && cur.c == N - 1) break;  // 도착 최솟값 확정

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                    int ncost = cur.cost + map[nr][nc];
                    if (ncost < dist[nr][nc]) {
                        dist[nr][nc] = ncost;
                        pq.offer(new Node(nr, nc, ncost));
                    }
                }
            }

            System.out.println("#" + tc + " " + dist[N - 1][N - 1]);
        }
    }
}
