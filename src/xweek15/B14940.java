package xweek15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] vis = new int[n][m];
		int startx=0, starty=0;		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					startx = i;
					starty = j;
				}else if(map[i][j] == 0) vis[i][j] = -1;
			}
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startx, starty});
		
		vis[startx][starty] = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d =0; d<4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(vis[nx][ny]>0 || map[nx][ny] == 0) continue;
				q.add(new int[] {nx,ny});
				vis[nx][ny] = vis[cur[0]][cur[1]] + 1;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(vis[i][j]>0) System.out.print(vis[i][j]-1 +" ");
				else if(vis[i][j] == -1) System.out.print(0 +" ");
				else System.out.print(-1+" ");
			}
			System.out.println();
		}
	}
}
