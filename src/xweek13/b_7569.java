package xweek13;

import java.util.*;
import java.io.*;

public class b_7569 {
	
	static int M,N,H,map[][][],answer[][][];
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[N][M][H];
		answer = new int[N][M][H];
		Queue<int[]> queue = new LinkedList<>();
		
		for(int h = 0; h<H; h++) {
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j][h] = num;
					answer[i][j][h] = num;
					
					if(map[i][j][h] == 1) queue.add(new int[] {i,j,h,0});
				}
			}
		}
		//입력 끝
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int dic = 0; dic<6; dic++) {
				int x = curr[0] + dx[dic];
				int y = curr[1] + dy[dic];
				int z = curr[2] + dz[dic];
				
				if(x>=0 && y>=0 && z>=0 && x<N && y<M && z<H && map[x][y][z] == 0 && answer[x][y][z] == 0) {
					answer[x][y][z] = curr[3]+1;
					queue.add(new int[] {x,y,z,curr[3]+1});
				}
			}
		}
		int max = 0;
		for(int h = 0; h<H; h++) {
			for(int i = 0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(answer[i][j][h] == 0) {
						System.out.println(-1);
						return ;
					}
					max = Math.max(max, answer[i][j][h]);
				}
			}
		}
		
		if(max == 1) System.out.println(0);
		else System.out.println(max);
	}

}
