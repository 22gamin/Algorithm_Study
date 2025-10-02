package xweek10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500 {
	static int n, m, maxnum = 0, total=0;
	static int[][] map, vis;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		vis = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				vis[i][j]=1;
				dfs(i, j, 1, map[i][j]);	
				vis[i][j]=0;
			}
		}
		System.out.println(maxnum);
	}
	public static void dfs(int x, int y, int r, int size) {
		if(r == 4) {
			if(maxnum<size) {
				maxnum = size;
				return;
			}
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<0||nx>=n||ny<0||ny>=m||vis[nx][ny]==1) continue;
			vis[nx][ny] = 1;
			dfs(nx, ny, r+1, size+map[nx][ny]);
			vis[nx][ny] = 0;				
		}
		
		int s=0;
		for(int i=0; i<4; i++){
			s+=map[x][y];
			for(int j=0; j<4; j++){
				if(i==j) continue;
				int nx = x + dx[j];
				int ny = y + dy[j];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				s+=map[nx][ny];
			}
			maxnum = Integer.max(maxnum, s);
			s=0;
		}
	}		
}