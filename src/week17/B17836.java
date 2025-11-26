package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17836 {

	static int N, M, T;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int gramX = -1, gramY = -1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					gramX = i;
					gramY = j;
				}
			}
		}
		int[][] dist = bfs();
		// 1) 검 없이 바로 공주에게
		int plainTime = dist[N - 1][M - 1];

		// 2) 검을 먹고 공주에게
		int swordTime = INF;
		if (gramX != -1 && dist[gramX][gramY] != INF) {
			int distToGram = dist[gramX][gramY];
			int distGramToPrincess = (N - 1 - gramX) + (M - 1 - gramY); // 벽 무시 직선 거리
			swordTime = distToGram + distGramToPrincess;
		}

		int ans = Math.min(plainTime, swordTime);

		if (ans <= T) {
			System.out.println(ans);
		} else {
			System.out.println("Fail");
		}
	}

	// 벽(1)은 못 지나감, 0/2는 지나갈 수 있음
	static int[][] bfs() {
		int[][] dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j] = INF;
			}
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		dist[0][0] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				// 벽(1)은 검 없으면 못 감, 검도 아직 안 먹은 BFS라 여기서는 막기
				if (map[nx][ny] == 1)
					continue;

				// 아직 방문 안 했거나 더 짧게 갈 수 있을 때
				if (dist[nx][ny] > dist[x][y] + 1) {
					dist[nx][ny] = dist[x][y] + 1;
					q.add(new int[] { nx, ny });
				}
			}
		}
		return dist;
	}
}
