package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2644 {
	static int N;
	static List<Integer>[] list;
	static boolean[] visited;
	static int[] dist; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n1=Integer.parseInt(st.nextToken());
		int n2=Integer.parseInt(st.nextToken());
		
		list=new LinkedList[N+1];
		
		for(int i=1;i<=N;i++) {
			list[i]=new LinkedList<>();
		}
		
		st=new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		visited=new boolean[N+1];
		dist = new int[N+1];
		
		int result=bfs(n1, n2);
		System.out.println(result);

	}
	
	static int bfs(int start, int target) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		dist[start]=0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur==target) {
				return dist[cur];
			}
			
			for(int next : list[cur]) {
				if(!visited[next]) {
					visited[next]=true;
					dist[next]=dist[cur]+1;
					queue.add(next);
				}
			}
		}
		return -1;
	}

}
