package xweek10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 유니온 파인드?
// r이 루트 

public class B15681 {
	static List<Integer> li[], child[];
	static int[] parents, size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		li = new ArrayList[n+1];
		child = new ArrayList[n+1];
		parents = new int[n+1];
		size = new int[n+1];
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList<>();
			child[i] = new ArrayList<>();
		}
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			li[u].add(v);
			li[v].add(u);
		}
		//for(int i=1; i<=n; i++) {
			makeTree(r, r);
		//}
		countsubtreeNode(r);
		for(int i=0; i<q; i++) {
			int c = Integer.parseInt(br.readLine());
			System.out.println(size[c]);
		}
		// test
		//for(int i=1; i<=n; i++) System.out.println(parents[i]);
	}
	public static void makeTree(int currentNode, int parent) {
		for(int node : li[currentNode]) {
			if(node!=parent) {
				child[currentNode].add(node);
				parents[node] = currentNode;
				makeTree(node, currentNode);
			}
		}
	}
	public static void countsubtreeNode(int cnode) {
		size[cnode] = 1;
		for(int node : child[cnode]) {
			countsubtreeNode(node);
			size[cnode]+=size[node];
		}
	}
}
