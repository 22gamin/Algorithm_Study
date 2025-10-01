package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16234 {
	static int N,L,R;
	static int[][] map;
	static boolean visited[][];
	static int[] dx = {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		// 인구 수 입력
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int days=0;
		while(true) {
			visited=new boolean[N][N];
			boolean moved = false;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						List<int[]> union = bfs(i,j);
						if(union.size()>1) {
							moved=true;
							int sum=0;
							for(int[] cell : union) {
								sum+=map[cell[0]][cell[1]];
							}
							int avg = sum/union.size();
							for(int[] cell : union) {
								map[cell[0]][cell[1]]=avg;
							}
						}
					}
				}
			}
			
			if(!moved) break; // 더 이상 인구 이동이 없다면 종료
			days++;
		}
		System.out.println(days);
	}
	
	static List<int[]> bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		List<int[]> union = new ArrayList<>();
		
		queue.add(new int[] {x,y});
		visited[x][y]=true;  
		union.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			
			for(int d=0;d<4;d++) {
				int nx=cur[0]+dx[d];
				int ny=cur[1]+dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
					int diff = map[cur[0]][cur[1]] - map[nx][ny];
					if(L<=Math.abs(diff) && Math.abs(diff)<=R ) {
						visited[nx][ny]=true;  
						queue.add(new int[] {nx,ny});
						union.add(new int[] {nx,ny});
					}
				}
			}
		}
		return union;
	}
}



