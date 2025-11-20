package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxnum = 0;
		int[] dp = new int[n+50];
		for(int i=n-1; i>=0; i--) {
			// t[i] + i가 n초과일때 상담x
			if(t[i]+i<=n) {
				dp[i] = Math.max(dp[i+1], dp[i+t[i]]+p[i]);
				maxnum = Math.max(dp[i], maxnum);
			}
			// 꼭 연달아서 상담해야하는거 아니니까 
			else dp[i] = dp[i+1];
		}
		System.out.println(maxnum);		
	}
}
