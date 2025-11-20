package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순방향
public class B15486_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		
		int[] dp = new int[n+50];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxnum = 0;
		
		for(int i=0; i<=n; i++) {
			maxnum = Math.max(maxnum, dp[i]);
			if(i == n) break;
			// t[i] + i가 n초과일때 상담x
			if(t[i]+i<=n) {
				dp[i+t[i]] = Math.max(maxnum+p[i], dp[i+t[i]]);
			}
		}
		System.out.println(maxnum);		
	}
}
