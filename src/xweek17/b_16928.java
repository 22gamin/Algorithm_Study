package xweek17;

import java.util.*;
import java.io.*;

public class b_16928 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new HashMap<>();
		int[] dist = new int[101];
		
		Arrays.fill(dist, -1);

		for(int i = 0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			
			map.put(before, after);
		} // 입력 끝
		
		Queue<Integer> queue = new LinkedList<>();
		
		dist[1] = 0;
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			if(curr==100) {
				System.out.println(dist[100]);
				return ;
			}
			
			for(int roll = 1; roll<7; roll++) {
				int next = curr+roll;  //주사위로 이동
				
				if(next > 100) continue;
				
				if(map.containsKey(next)) {
					next = map.get(next); //뱀 사다리 이동
				}
				
				if(dist[next] == -1) { //한 번도 안 온 곳
					dist[next] = dist[curr] + 1;
					queue.add(next);
				}
			}
		}
		
	}

}
