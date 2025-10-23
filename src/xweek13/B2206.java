package xweek13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		if(n == 1 && m == 1) {
			System.out.println(1);
			return;
		}
		
		Queue<int[]> li = new LinkedList<>();
		int[][][] vis = new int[n][m][2];
		// x, y, 벽부쉈는지 여부
		li.add(new int[] {0,0,0});
		vis[0][0][0] = 1;
		while(!li.isEmpty()) {
			int[] cur = li.poll();
			int xx = cur[0];
			int yy = cur[1];
			int chk = cur[2];
			
			for(int d=0; d<4; d++) {
				int nx = xx + dx[d];
				int ny = yy + dy[d];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				// 벽이 아닐때 
				if(map[nx][ny] == 0) {
					// 방문안했을때만 
					if(vis[nx][ny][chk] == 0) {						
						li.add(new int[] {nx,ny,chk});
						vis[nx][ny][chk] = vis[xx][yy][chk] + 1;
					}					
				}
				// 벽일때
				else {
					// 이미 벽 부쉈을때
					if(chk == 1) {
						continue;
					}
					// 벽 아직 안부쉈을때 부수기 
					else {
						vis[nx][ny][1] = vis[xx][yy][chk] + 1;					
						li.add(new int[] {nx, ny, 1});
					}
				}				
			}
			
		}
		int total0 = vis[n-1][m-1][0];
		int total1 = vis[n-1][m-1][1];
		
		if(total0 == 0 && total1 == 0)System.out.println(-1);
		else{
			if(total0 == 0 && total1 !=0) System.out.println(total1);
			else if(total0 != 0 && total1 ==0) System.out.println(total0);
			else System.out.println(Math.min(total0, total1));
		}		
	}
}
