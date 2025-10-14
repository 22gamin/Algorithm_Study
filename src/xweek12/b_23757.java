package xweek12;

import java.util.*;
import java.io.*;

public class b_23757 {
	static int N, M,gifts[], child[];
	
	public static class Box implements Comparable<Box>{

		int idx;
		int cnt;
		
		public Box(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Box o) {
			return o.cnt - this.cnt;
		}
		
		@Override
		public String toString() {
			return "[" + this.idx + " " + this.cnt + "]";
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		PriorityQueue<Box> pq = new PriorityQueue<>();
		
		gifts = new int[N];
		child = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n<N; n++) {
			pq.offer(new Box(n,Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m<M; m++) {
			child[m] = Integer.parseInt(st.nextToken());
		}
		
		//입력 끝
		int result = 1;

		for(int num : child) {
			Box box = pq.poll();
			
			if (box.cnt >= num) {
				box.cnt -= num;
				pq.offer(new Box(box.idx, box.cnt));
			}
			else {
				result = 0;
				break;
			}
		}
		
		System.out.println(result);

	}

}
