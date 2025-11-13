package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503 {
	static int N, M;
	static int[][] map;
	static int x, y;
	static int count = 0; // 청소 칸 수

	// 방향: 0=북, 1=동, 2=남, 3=서
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean();
		System.out.println(count);
	}

	static void clean() {
		while (true) {
			// 1.현재 칸 청소 (0:청소 x, 1:벽, 2:청소함)
			if (map[x][y] == 0) {
				map[x][y] = 2;
				count++;
			}

			// 2. 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
			boolean found = false;
			for (int d = 0; d < 4; d++) {
				// 반시계 회전
				dir = (dir + 3) % 4;
				int nx = x + dr[dir];
				int ny = y + dc[dir];

				// 범위 안이고, 아직 청소 안된 빈 칸(0)이면 전진
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
					x = nx;
					y = ny;
					found = true;
					break;
				}
			}

			// 주변에 청소할 곳 있었으면 이동했으니 다시 루프
			if (found)
				continue;

			// 3. 주변 4칸에 청소할 곳이 없으면 뒤로 한 칸
			int backX = x - dr[dir];
			int backY = y - dc[dir];

			// 뒤가 벽(1)이면 작동 종료
			if (backX < 0 || backX >= N || backY < 0 || backY >= M || map[backX][backY] == 1) {
				break;
			}

			// 벽이 아니면 후진
			x = backX;
			y = backY;
		}
	}
}
