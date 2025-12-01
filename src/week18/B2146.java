package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2146 {
	 static int N;
	    static int[][] map;
	    static boolean[][] visited;
	    static int[] dx = {-1, 1, 0, 0};
	    static int[] dy = {0, 0, -1, 1};

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine());

	        map = new int[N][N];

	        StringTokenizer st;
	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < N; j++) {
	                map[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }

	        // 1. 섬마다 번호 라벨링 (2, 3, 4, ...)
	        visited = new boolean[N][N];
	        int islandId = 2; // 1은 원래 육지 값이라 2부터 사용
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (!visited[i][j] && map[i][j] == 1) {
	                    labelIsland(i, j, islandId);
	                    islandId++;
	                }
	            }
	        }

	        int answer = Integer.MAX_VALUE;

	        // 2. 각 섬에서 바다로 BFS 확장해서 다른 섬까지의 최소 거리 탐색
	        for (int id = 2; id < islandId; id++) {
	            int dist = bfsFromIsland(id, answer); // 현재까지의 best answer 넘으면 더 볼 필요 없음
	            if (dist != -1) {
	                answer = Math.min(answer, dist);
	            }
	        }

	        System.out.println(answer);
	    }

	    // 섬 라벨링 BFS: (x, y)와 연결된 육지를 모두 islandId로 바꾼다.
	    static void labelIsland(int sx, int sy, int islandId) {
	        Queue<int[]> q = new ArrayDeque<>();
	        q.add(new int[]{sx, sy});
	        visited[sx][sy] = true;
	        map[sx][sy] = islandId;

	        while (!q.isEmpty()) {
	            int[] cur = q.poll();
	            int x = cur[0];
	            int y = cur[1];

	            for (int d = 0; d < 4; d++) {
	                int nx = x + dx[d];
	                int ny = y + dy[d];

	                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	                if (visited[nx][ny]) continue;
	                if (map[nx][ny] != 1) continue; // 육지가 아니면 패스

	                visited[nx][ny] = true;
	                map[nx][ny] = islandId;
	                q.add(new int[]{nx, ny});
	            }
	        }
	    }

	    // 특정 섬(id)에서 바다를 따라 BFS 확장하여 다른 섬까지의 최소 다리 길이
	    static int bfsFromIsland(int islandId, int currentBest) {
	        int[][] dist = new int[N][N];
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                dist[i][j] = -1;
	            }
	        }

	        Queue<int[]> q = new ArrayDeque<>();

	        // 이 섬에 속하는 모든 칸을 시작점으로 큐에 넣는다 (멀티 소스 BFS)
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (map[i][j] == islandId) {
	                    q.add(new int[]{i, j});
	                    dist[i][j] = 0; // 육지에서 시작, 바다는 dist>0부터
	                }
	            }
	        }

	        int minBridge = Integer.MAX_VALUE;

	        while (!q.isEmpty()) {
	            int[] cur = q.poll();
	            int x = cur[0];
	            int y = cur[1];

	            // 지금까지 찾은 최소 답보다 이미 거리가 크면 더 볼 필요 없음
	            if (dist[x][y] >= currentBest) continue;

	            for (int d = 0; d < 4; d++) {
	                int nx = x + dx[d];
	                int ny = y + dy[d];

	                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

	                // 같은 섬이면 그냥 무시 (이미 시작점들로 넣어줬음)
	                if (map[nx][ny] == islandId) continue;

	                // 다른 섬을 만난다면, 지금까지 건너온 바다 칸 수(dist[x][y])가 다리 길이
	                if (map[nx][ny] != 0 && map[nx][ny] != islandId) {
	                    minBridge = Math.min(minBridge, dist[x][y]);
	                    continue;
	                }

	                // 바다(0)인 경우만 계속 확장
	                if (map[nx][ny] == 0 && dist[nx][ny] == -1) {
	                    dist[nx][ny] = dist[x][y] + 1;
	                    q.add(new int[]{nx, ny});
	                }
	            }
	        }

	        return (minBridge == Integer.MAX_VALUE) ? -1 : minBridge;
	    }
}
