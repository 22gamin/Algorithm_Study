package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3109 {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;

	// 오른쪽 위 -> 오른쪽 -> 오른쪽 아래
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int answer = 0;
		for (int r = 0; r < R; r++) { // 첫번째 열 검사
			if (dfs(r, 0))
				answer++;
		}
		System.out.println(answer);
	}

	static boolean dfs(int r, int c) {
		visited[r][c] = true;
		if (c == C - 1)
			return true;

		for (int k = 0; k < 3; k++) {
			int nr = r + dx[k];
			int nc = c + dy[k];
			if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
			if(map[nr][nc]=='x' || visited[nr][nc]) continue;
			if(dfs(nr,nc)) return true; // 한 경로 성공하면 바로 고정
		}
		return false;
	}
}
