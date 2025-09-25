package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 {
	static int[]dx = {0,1,0,-1};
	static int[]dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		int[][] map = new int[m*h][n];
		int emptycount=0;
		for(int i=0; i<m*h; i++) {			
			st = new StringTokenizer(br.readLine());
			for(int w=0; w<n; w++) {
				map[i][w] = Integer.parseInt(st.nextToken());
				if(map[i][w] == 1) q.add(new int[]{i,w});
				if(map[i][w] == 0) emptycount++;
			}
		}
		
		int[][] vis = new int[m*h][n];
		int totalday=-1;
		while(!q.isEmpty()) {
			totalday++;
			int len = q.size();
			// 큐에 들어가있는 익은 토마토 
			for(int i=0; i<len; i++) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];	
				for(int d=0; d<4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					
					if(x/m != nx/m) continue;
					
					if(nx<0||nx>=m*h||ny<0||ny>=n) continue;
					if(map[nx][ny] == 0) {
						map[nx][ny] = 1;
						q.add(new int[] {nx,ny});
						emptycount--;						
					}
				}
				if(x-m>=0) {
					if(map[x-m][y] ==0) {
						map[x-m][y] = 1;
						q.add(new int[] {x-m,y});
						emptycount--;
						
					}
				}
				if(x+m<m*h) {
					if(map[x+m][y] == 0) {
						map[x+m][y]=1;
						q.add(new int[] {x+m,y});
						emptycount--;
					}				
				}				
			}
		}			
		if(emptycount == 0) System.out.println(totalday);
		else System.out.println(-1);
	}

}
