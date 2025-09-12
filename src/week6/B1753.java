package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
	
	static class Node {
		int to, weight;
		Node next;

		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int no, totalDistance;
		
		public Vertex(int no, int totalDistance) {
			super();
			this.no = no;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.totalDistance, o.totalDistance);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V+1];
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to,weight,adjList[from]);
		}
		
		int[] minDistance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(minDistance, INF);
		minDistance[start]=0;
		
		pq.offer(new Vertex(start, minDistance[start]));
		
		while(!pq.isEmpty()) {
			Vertex stopOver = pq.poll();
			if(visited[stopOver.no]) continue;
			visited[stopOver.no]=true;
			
			for(Node temp=adjList[stopOver.no]; temp!=null; temp=temp.next) {
				if(!visited[temp.to] &&
						minDistance[temp.to] > stopOver.totalDistance + temp.weight) {
					minDistance[temp.to] = stopOver.totalDistance + temp.weight;
					pq.offer(new Vertex(temp.to,minDistance[temp.to]));
				}
			}
		}
		
		for(int i=1;i<=V;i++) {
			if(minDistance[i] == INF)
				System.out.println("INF");
			else
				System.out.println(minDistance[i]);
		}
  	}
}








