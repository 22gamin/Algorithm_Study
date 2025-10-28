package xweek14;

import java.util.*;
import java.io.*;

public class b_13549 {
	static int N,K;
	static int[] dist;
	static int[] dx = {-1,1,2};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		//입력 끝
		
		dist = new int[100001];
		
		for(int i = 0; i<100001; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		queue.add(new int[] {N,0});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if(curr[0] == K) {
				System.out.println(curr[1]);
				return;
			}
			
			for(int i = 0; i<3; i++) {
				if(dx[i] == 2) {
					int x = curr[0] * 2;
					
					if(x>=0 && x<=100000 && dist[x] > curr[1]) {
						dist[x] = curr[1];
						queue.add(new int[] {x,dist[x]});
					}
				} else {
					int x = curr[0] + dx[i];
					
					if(x>=0 && x<=100000 && dist[x] > curr[1]+1) {
						dist[x] = curr[1]+1;
						queue.add(new int[] {x,dist[x]});
					}
				}
			}
		}

	}



}
