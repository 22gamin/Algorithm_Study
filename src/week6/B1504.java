package 과목평가;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504 {

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

	static class Vertex implements Comparable<Vertex> {
		int no, totalDistance;

		public Vertex(int no, int totalDistance) {
			this.no = no;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.totalDistance, o.totalDistance);
		}
	}

	static int N, E;
	static Node[] adjList;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new Node[N + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			// 양방향 그래프
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		// 다익스트라 3번 실행
		int[] distFrom1 = dijkstra(1);
		int[] distFromV1 = dijkstra(v1);
		int[] distFromV2 = dijkstra(v2);

		long path1 = (long) distFrom1[v1] + distFromV1[v2] + distFromV2[N];
		long path2 = (long) distFrom1[v2] + distFromV2[v1] + distFromV1[N];
		long answer = Math.min(path1, path2);

		if (answer >= INF)
			System.out.println(-1);
		else
			System.out.println(answer);

	}

	static int[] dijkstra(int start) {
		int[] minDistance = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0;

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, 0));

		while (!pq.isEmpty()) {
			Vertex stopOver = pq.poll();
			if (visited[stopOver.no])
				continue;
			visited[stopOver.no] = true;

			for (Node temp = adjList[stopOver.no]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && minDistance[temp.to] > stopOver.totalDistance + temp.weight) {
					minDistance[temp.to] = stopOver.totalDistance + temp.weight;
					pq.offer(new Vertex(temp.to, minDistance[temp.to]));
				}
			}
		}
		return minDistance;
	}

}
