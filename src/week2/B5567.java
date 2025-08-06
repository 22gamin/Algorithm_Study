package week2;

import java.util.*;

public class B5567 {

	static List<Integer>[] list;
	static boolean[] visited;
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		list=new LinkedList[n+1];
		visited=new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i]=new LinkedList<>();
		}
		
		for(int i=0;i<m;i++) {
			int source=sc.nextInt();
			int destination=sc.nextInt();
			list[source].add(destination);
			list[destination].add(source);
		}
		
		bfs(1);
		System.out.println(count);
	}
	
	static void bfs(int start) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start,0});
		visited[start]=true;
		
		
		while(!queue.isEmpty()) {
			int[] current=queue.poll();
			int person=current[0];
			int depth=current[1];
			
			if (depth >= 2) continue;
			for(int next : list[person]) {
				if(!visited[next]) {
					visited[next]=true;
					count++;
					queue.offer(new int[] {next,depth+1});
				}
			}
		}
	}
}
