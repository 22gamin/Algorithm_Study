package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2533 {
	static List<Integer>[] li;
	static int[] vis;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		vis = new int[N+1];
		dp = new int[N+1][2];
		List<Integer> gro = new ArrayList<>();
		li = new ArrayList[N+1];
		for(int i=1; i<=N; i++) li[i] = new ArrayList<>();
		for(int i=1; i<=N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			li[a].add(b);
			li[b].add(a);
		}
		dfs(1);
		int answer = Math.min(dp[1][0], dp[1][1]);
		System.out.println(answer);
	}
	public static void dfs(int start) {
		vis[start] = 1;
		// 현재 비용
		dp[start][0] = 0;
		dp[start][1] = 1;
		for(int child : li[start]) {
			if(vis[child] == 0) {
				dfs(child);
				// 현재 노드 선택x
				dp[start][0] += dp[child][1];
				// 현재 노드 선택o 
				dp[start][1] += Math.min(dp[child][0], dp[child][1]);				
			}
		}
	}
}
