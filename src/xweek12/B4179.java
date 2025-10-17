package xweek12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179 {
	static char[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		Queue<int[]> fireQ = new LinkedList<>();
		Queue<int[]> perQ = new LinkedList<>();
		int str=0, endd=0;
		
		for(int i=0; i<r; i++) {
			String s = br.readLine();
			
			for(int j=0; j<c; j++) {
				char a = s.charAt(j);
				map[i][j] = a;
				if(a == 'F') fireQ.add(new int[] {i,j});
				else if(a == 'J') {
					perQ.add(new int[] {i,j});
					str = i;
					endd = j;
				}
			}
		}
		int[][] firevis = new int[r][c];
		int[][] pervis = new int[r][c];
		int[][] cnt = new int[r][c];
		// 불 -> 지훈이
		while(!perQ.isEmpty()) {			
			// 불
			int fireQlen = fireQ.size();
			for(int i=0; i<fireQlen; i++) {
				int[] curFire = fireQ.poll();				
				int x = curFire[0];
				int y = curFire[1];
				firevis[x][y] = 1;
				for(int d=0; d<4; d++) {
					int nx = dx[d] + x;
					int ny = dy[d] + y;
					if(nx<0||nx>=r||ny<0||ny>=c) continue;
					// 방문한적없고, 벽 아니라면 
					if(firevis[nx][ny] != 1 && map[nx][ny]!='#') {
						firevis[nx][ny] = 1;
						map[nx][ny] = 'F';
						fireQ.add(new int[] {nx,ny});
					}					
				}
			}
			// 지훈이
			int perQlen = perQ.size();
			cnt[str][endd]=1;
			for(int i=0; i<perQlen; i++) {
				int[] curPer = perQ.poll();
				pervis[curPer[0]][curPer[1]] = 1;
				
				for(int d=0; d<4; d++) {
					int nx = dx[d] + curPer[0];
					int ny = dy[d] + curPer[1];
					if(nx<0||nx>=r||ny<0||ny>=c) {						
						System.out.println(cnt[curPer[0]][curPer[1]]);
						return;												
					}
					
					// 방문한적없고, 벽 아니라면, 불 아니라면
					if(pervis[nx][ny] != 1 && map[nx][ny]!='#' && map[nx][ny]!='F') {
						pervis[nx][ny] = 1;
						map[nx][ny] = 'J';
						perQ.add(new int[] {nx,ny});
						cnt[nx][ny]=(cnt[curPer[0]][curPer[1]]+1);
					}					
				}
			}			
		}
		System.out.println("IMPOSSIBLE");
	}
}