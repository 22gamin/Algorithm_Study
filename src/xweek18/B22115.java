package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B22115 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c[] = new int[n];
		// 커피의 개수 N, 창영이가 섭취해야 하는 카페인의 양 K
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		int dp[] = new int[k+1];
		
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		for(int i=0; i<n; i++) {
			for(int w = k; w>=c[i]; w--) {
				dp[w] = Math.min(dp[w], dp[w - c[i]] + 1);
			}
		}
		if(dp[k] == 100001) System.out.println(-1);
		else System.out.println(dp[k]);		
	}
}
