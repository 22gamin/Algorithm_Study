import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args )throws IOException {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [] in = new int[n+1];
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		
		for(int i =0; i<n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for(int i = 0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken());
			int e = Integer.parseInt(st2.nextToken());
			graph[s].add(e);
			in[e]++;
		}
		
		
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=n; i++) {
			if(in[i]==0) {
				q.offer(i);
				sb.append(i+" ");
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int nx : graph[x]) {
				in[nx]--;
				if(in[nx]==0) {
					q.offer(nx);
					sb.append(nx+" ");
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}
}
