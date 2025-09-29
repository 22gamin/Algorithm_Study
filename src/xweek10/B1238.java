package xweek10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1238 {
	public static class pair implements Comparable<pair>{
		int y, cost;
		public pair(int y, int cost) {
			this.y=y;
			this.cost=cost;
		}
		public int compareTo(pair other) {
			return this.cost-other.cost;
		}
		
	}
	static List<pair>[] li;
	static int[] dist;
	static int INF = Integer.MAX_VALUE, maxnum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		li = new ArrayList[m+1];
		for(int i=1; i<=m; i++) li[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 1. 경유도시 x
			// 2. a->x + x->a o
			li[a].add(new pair(b,c));			
		}
		int[] arr = new int[n+1];
		dist = new int[n+1];
		for(int i=1; i<=n; i++) {
			Arrays.fill(dist, INF);
			bfs(i);
			int lenstart = dist[x];
			arr[i] = lenstart;
		}
		Arrays.fill(dist, INF);
		bfs(x);
		for(int i=1; i<=n; i++) {
			int tmp = dist[i];
			tmp+=arr[i];
			if(maxnum<tmp) maxnum = tmp;
		}
		System.out.println(maxnum);
	}
	public static void bfs(int start) {
		PriorityQueue<pair> pq = new PriorityQueue<>();
		pq.add(new pair(start, 0));
		dist[start]=0;
		while(!pq.isEmpty()) {
			pair cur = pq.poll();
			for(pair c : li[cur.y]) {
				if(dist[c.y]<dist[cur.y]+c.cost)continue;
				dist[c.y] = dist[cur.y]+c.cost;
				pq.add(new pair(c.y, dist[c.y]));
			}
		}
	}
}
