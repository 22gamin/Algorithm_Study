package week2;

import java.util.*;

public class B2606 {

	static class Graph {
		int vertex;
		LinkedList<Integer>[] list;
		int cnt=0;
		public Graph(int vertex) {
			this.vertex=vertex;
			list = new LinkedList[vertex];
			for(int i=0;i<vertex;i++) {
				list[i] = new LinkedList<>();
			}
		}
		
		public void addEdge(int source, int destination) {
			list[source].addFirst(destination);
			list[destination].addFirst(source);
		}
		
		public int DFS(int v) {
			boolean[] visited = new boolean[vertex];
			DFS(v,visited);
			return cnt-1;
		}
		
		public void DFS(int v, boolean[] visited) {
			visited[v] = true;
			cnt++;
			for(int i=0;i<list[v].size();i++) {
				int dest=list[v].get(i);
				if(!visited[dest])
					DFS(dest, visited);
			}
		}
	}
		
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int computer=sc.nextInt();
		int link=sc.nextInt();
		
		Graph graph = new Graph(computer+1);
		for(int i=0;i<link;i++) {
			int source=sc.nextInt();
			int destination=sc.nextInt();
			graph.addEdge(source, destination);
		}
		
		System.out.println(graph.DFS(1));
	}

}
