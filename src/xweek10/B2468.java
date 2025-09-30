package xweek10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2468 {
	static int[][] map, vis;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int limitnum = 0, minnum = 100;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				limitnum = Integer.max(a, limitnum);
				minnum = Integer.min(a, minnum);
				
			}
		}
		if(minnum == limitnum) {
			System.out.println(1);
			return;
		}
		int maxnum = 0;
		for(int i=1; i<=limitnum; i++) {
			vis = new int[n][n];
			int len = bfs(i);
			maxnum = Integer.max(maxnum, len);
		}
		
		System.out.println(maxnum);
	}
	public static int bfs(int h) {
		int count=0;
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] <=h || vis[i][j] == 1) continue;
				q.add(new int[] {i,j});
				count++;
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					for(int d=0; d<4; d++) {
						int nx = cur[0]+dx[d];
						int ny = cur[1]+dy[d];
						if(nx<0||nx>=n||ny<0||ny>=n||vis[nx][ny] == 1) continue;
						if(map[nx][ny] <= h) continue;
						q.add(new int[] {nx,ny});
						vis[nx][ny] = 1;
					}
				}
			}
		}
		return count;
	}
}
