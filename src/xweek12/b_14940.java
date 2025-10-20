package xweek12;

import java.util.*;
import java.io.*;

public class b_14940 {

	static int n, m, graph[][], visited[][],answer[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new int[n][m];
		visited = new int[n][m];
		answer = new int[n][m];
		int[] arrive = new int[2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				answer[i][j] = -1;
				if (graph[i][j] == 2) {
					arrive = new int[]{i,j};
					answer[i][j] = 0;
				}
				else if (graph[i][j] == 0) {
					answer[i][j] = 0;
				}
			}
		}
		visited[arrive[0]][arrive[1]] = 1;
		bfs(arrive[0], arrive[1]);
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	static void bfs(int i, int j) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			for(int d = 0; d<4; d++) {
				int x = curr[0] + dx[d];
				int y = curr[1] + dy[d];
				
				if (x>= 0 && y>= 0 && x<n && y<m && graph[x][y] != 0 && visited[x][y] == 0) {
					
					visited[x][y] = 1;
					answer[x][y] = answer[curr[0]][curr[1]]+1;
					queue.add(new int[] {x,y});
				}
			}
		}

	}

	
}
