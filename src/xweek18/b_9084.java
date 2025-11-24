package xweek18;

import java.util.*;
import java.io.*;

public class b_9084 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] coins = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				coins[i] = Integer.parseInt(st.nextToken()); 
			}
			
			int M = Integer.parseInt(br.readLine());
			//입력 끝
			
			int[] dp = new int[M+1];
			dp[0] = 1; //0을 만드는 법 1개 - 아무것도 안 쓰기
			
			for(int coin : coins) {
				for(int i =coin; i<=M; i++) {
					dp[i] += dp[i-coin];
				}
			}
			sb.append(dp[M]).append("\n");
		}
		System.out.println(sb);
	}

}
