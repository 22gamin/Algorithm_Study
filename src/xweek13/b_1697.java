package xweek13;

import java.util.*;
import java.io.*;

public class b_1697 {
	static int[] dx = {-1,1,2};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(K==N) {
			System.out.println(0);
			return;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		pq.add(new int[] {N,0}); //x,초,거리
		int min = Integer.MAX_VALUE;
		boolean[] visited = new boolean[100001];
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			
			if(curr[0] == K) {
		
				min = Math.min(curr[1], min);
				break;
			}
			
			for(int i =0; i<3; i++) {
				int x;
				if(dx[i] == 2) {
					x = curr[0] * 2;
				} else {
					x = curr[0] + dx[i];
				}
				
				if(x>=0 && x<=100000 && !visited[x]) {
					visited[x] = true;
					pq.add(new int[] {x,curr[1]+1});
				}
			}
			
		}
		System.out.println(min);
	}

}
