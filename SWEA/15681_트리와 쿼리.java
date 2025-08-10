import java.util.*;
import java.io.*;

public class Main{
	static int n, r, q;
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<ArrayList<Integer>> tree;
	static int[] dp ;
	static int[] visit;
 	public static void main(String[] arg)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		tree = new ArrayList<>();
		for(int i =0; i<=n; i++) {
			graph.add(new ArrayList<>());
			tree.add(new ArrayList<>());
		}
		dp=new int[n+1];
		visit = new int[n+1];
		for(int i =0; i<n-1; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b =Integer.parseInt(st2.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		makeTree(r);
		StringBuilder sb = new StringBuilder ();
		
		for(int i =0; i<q; i++) {
			int x = Integer.parseInt(br.readLine());
			if(dp[x]==0) {
				findSeg(x);
			}
			sb.append(dp[x]).append("\n");
		}
		System.out.print(sb.toString());
		
 	}
 	
 	static int findSeg(int x) {
 		dp[x]++;
 		
 		for(int nx : tree.get(x)) {
 			if(dp[nx]==0) {
 				dp[x] += findSeg(nx);
 			}else {
 				dp[x] += dp[nx];
 			}
 			
 		}
 		return dp[x];
 	}
 	
 	
 	static void makeTree(int x) {
 		visit[x]=1;
 		for(int nx : graph.get(x)) {
 			if(visit[nx]==0) {
 				tree.get(x).add(nx);
 				makeTree(nx);
 			}
 		}
 	}
 	
 }
