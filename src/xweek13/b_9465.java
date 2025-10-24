package xweek13;

import java.util.*;
import java.io.*;

public class b_9465 {
	static int n, graph[][], dp[][], max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			graph = new int[2][n];
			dp = new int[2][n];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝

			if (n==1) {
				System.out.println(Math.max(graph[0][0], graph[1][0]));
				continue;
			}
			
			dp[0][0] = graph[0][0];
			dp[1][0] = graph[1][0];
			dp[0][1] = dp[1][0] + graph[0][1];
			dp[1][1] = dp[0][0] + graph[1][1];
			
			for(int i = 2; i<n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], Math.max(dp[0][i-2], dp[1][i-2]))+graph[0][i];
				dp[1][i] = Math.max(dp[0][i-1], Math.max(dp[0][i-2], dp[1][i-2]))+graph[1][i];
			}

			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));

		}
	}

}
