package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589 {
	static int H, W;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		for (int i = 0; i < H; i++) {
			String line = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int answer = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(map[i][j]=='L') {
					answer = Math.max(answer, bfs(i,j));
				}
			}
		}
		System.out.println(answer);
	}

	static int bfs(int x, int y) {
		boolean[][] visited = new boolean[H][W];
        int[][] dist = new int[H][W];
		Queue<int[]> queue = new LinkedList<>();
		visited[x][y]=true;
		dist[x][y]=0;
		queue.add(new int[] { x, y });

		int localMax = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			for (int d = 0; d < 4; d++) {
				int nx = cur_x + dx[d];
				int ny = cur_y + dy[d];
				if (nx >= 0 && nx < H && ny >= 0 && ny < W 
						&& map[nx][ny] == 'L' && !visited[nx][ny]) {
					visited[nx][ny]=true;
					dist[nx][ny]=dist[cur_x][cur_y]+1;
					localMax=Math.max(localMax, dist[nx][ny]);
					queue.add(new int[] { nx, ny });
				}
			}
		}
		return localMax;
	}
}
