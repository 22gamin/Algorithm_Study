package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1197 {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static Edge[] edgeList;
	static int[] parents;
	static int[] rank; 
	static int V,E;
	
	static void make() {
		for(int i=1;i<=V;i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot)
			return false;
		
		if(rank[aRoot] < rank[bRoot]) {
			parents[aRoot] = bRoot;
		}
		else if(rank[aRoot]>rank[bRoot]) {
			parents[bRoot]=aRoot;
		}
		else {
			parents[bRoot]=aRoot;
			rank[aRoot]++;
		}
		return true;
	}
	
 	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        rank = new int[V + 1];
        edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgeList); // 간선 가중치 오름차순 정렬
        make();
        
        int result = 0; // 최소 신장 트리 비용
        int cnt = 0;    // 선택된 간선 수

        for (Edge edge : edgeList) {
            if (!union(edge.from, edge.to)) // 같은 집합이면 skip
                continue;

            result += edge.weight;
            if (++cnt == V - 1) break; // MST 완성 (간선 V-1개 선택 완료)
        }

        System.out.println(result);
	}

}
