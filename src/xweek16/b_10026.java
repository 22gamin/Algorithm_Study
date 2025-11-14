package xweek16;

import java.util.*;
import java.io.*;

public class b_10026 {
	static int N,color,nonColor;
	static char graph[][];
	static boolean visited[][];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static void see(int startX, int startY, char c) {
		
		for(int i = 0; i<4; i++) {
			int x = startX + dx[i];
			int y = startY + dy[i];
			
			if(x>=0 && y>=0 && x<N && y<N && graph[x][y] == c && !visited[x][y]) {
				visited[x][y] = true;

				see(x,y,c);
			}
		}
	}
	
	static void notSee(int startX, int startY, char c) {
		
		for(int i = 0; i<4; i++) {
			int x = startX + dx[i];
			int y = startY + dy[i];
			
			if(x>=0 && y>=0 && x<N && y<N && !visited[x][y]) {
				if (c == 'B' && graph[x][y] =='B') {
					visited[x][y] = true;
					notSee(x,y,c);
				} else if(c != 'B' && graph[x][y] !='B'){
					visited[x][y] = true;
					notSee(x,y,c);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j<N; j++) {
				graph[i][j] = str.charAt(j);
			}
		} //입력 끝
		
		//dfs
		
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;

					see(i,j,graph[i][j]);
					color++;
				}
			}
		}

		visited = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					notSee(i,j,graph[i][j]);
					nonColor++;
				}
			}
		}
		System.out.println(color + " " + nonColor);
	}

}
