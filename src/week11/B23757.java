package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B23757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int need = Integer.parseInt(st.nextToken());
			if(pq.isEmpty()) { // 상자가 없으면 실패 
				System.out.println(0);
				return;
			}
			
			int top = pq.poll();
			if(top<need) { // 원하는 만큼 못 주면 실패
				System.out.println(0);
				return;
			}
			
			int rest = top - need;
			if(rest > 0) pq.add(rest);
		}
		System.out.println(1);
	}
}





