package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B2667 {
	
	static int[][] map;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Integer> list = new ArrayList<>();
	static int total_count=0, count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String line=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=line.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					BFS(i,j,map);
					list.add(count);
					total_count++;
				}
			}
		}
		
		System.out.println(total_count);
		Collections.sort(list);
		for(int n : list) {
			System.out.println(n);
		}
	}
	
	static void BFS(int x, int y, int[][] map) {
		count=0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		map[x][y]=0; // 방문처리 
		count++;
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			
			for(int d=0;d<4;d++) {
				int nx=cur[0]+dx[d];
				int ny=cur[1]+dy[d];
				if(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]==1) {
					queue.add(new int[] {nx,ny});
					map[nx][ny]=0;
					count++;
				}
			}
		}
		
	}
}
