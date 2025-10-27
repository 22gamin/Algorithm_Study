package xweek14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502 {
	static int n, m, wallnum = 0, maxnum = Integer.MIN_VALUE, t = 0;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	static List<int[]> ground;
	static int[] selectwall = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		ground = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) ground.add(new int[] {i, j});
				else if(map[i][j] == 1) wallnum++;
			}
		}
		comb(0, 0);
		System.out.println(maxnum);
	}
	public static void comb(int start, int cnt) {
		if(cnt == 3) {
			// 벽 세우기
			for(int index : selectwall) {
				int[] cor = ground.get(index);
				map[cor[0]][cor[1]] = 1;
			}
			int safezone = m*n - (wallnum+3) - bfs();
			maxnum = Math.max(maxnum, safezone);
			// 원상복구
			for(int index : selectwall) {
				int[] cor = ground.get(index);
				map[cor[0]][cor[1]] = 0;
			}
			return;
		}
		for(int i=start; i<ground.size(); i++) {
			selectwall[cnt] = i;
			comb(i+1, cnt+1);
		}
		
	}
	// 바이러스부터 지역을 세기
	public static int bfs() {
		Queue<int[]> virus = new LinkedList<>();
		int[][] vis = new int[n][m];
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 2) {
					virus.add(new int[] {i, j});
					vis[i][j] = 1;
				}
			}
		}
		
		while(!virus.isEmpty()) {
			int[] cur = virus.poll();
			int xx = cur[0];
			int yy = cur[1];
			cnt++;
			for(int d=0; d<4; d++) {
				int nx = xx + dx[d];
				int ny = yy + dy[d];
				if(nx<0||nx>=n|| ny<0 || ny>=m) continue;
				if(map[nx][ny] == 1||vis[nx][ny] == 1) continue;
				virus.add(new int[] {nx,ny});
				vis[nx][ny] = 1;
				
			}
		}
		return cnt;
	}
}
