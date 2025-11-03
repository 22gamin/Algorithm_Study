import java.io.*;
import java.util.*;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m  =Integer.parseInt(st.nextToken());
		
		int [] in  = new int[n+1];
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		for(int i = 0; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		
		for(int i = 0; i<m ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st2.nextToken());
			int a = Integer.parseInt(st2.nextToken());
			for(int j = 0 ; j<x-1; j++) {
				int b = Integer.parseInt(st2.nextToken());
				in[b]++;
				graph[a].add(b);
				a = b;
			}
		}
		
		
		
		Queue<Integer> q= new LinkedList<>();
		
		for(int i =1; i<=n; i++) {
			if(in[i]==0) {
				q.offer(i);
			}
		}
		
		
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()){
			int cur = q.poll();
			sb.append(cur).append("\n");
			count++;
			for(int next : graph[cur]) {
				in[next]--;
				if(in[next]==0) {
					q.offer(next);
				}
			}	
		}
		if(count != n) {
			System.out.println("0");
		}else {
			System.out.println(sb.toString());
		}
		
		
	}
	
		
		
}
