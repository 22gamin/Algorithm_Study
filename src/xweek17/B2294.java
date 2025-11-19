package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2294 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] cost = new int[n];
		
		for(int i=0; i<n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[10001];
		
		Arrays.fill(dp, 10001);
		// 있어야함 
		dp[0]=0;
		// 가치에 따른 동전의 개수 저장 
		for(int i=0; i<cost.length; i++) {
			for(int w = cost[i]; w<dp.length; w++) {
				dp[w] = Math.min(dp[w], dp[w - cost[i]]+ 1);
			}
		}
		if(dp[k] == 10001) System.out.println(-1);
		else System.out.println(dp[k]);
	}
}
