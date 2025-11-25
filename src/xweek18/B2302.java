package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2302 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int dp[] = new int[n+2];
		
		for(int i=0; i<m; i++) {	
			int a = Integer.parseInt(br.readLine());
			dp[a] = -1;
		}
		dp[0] = -1; 
		dp[n+1] = -1;

		long total = 1;
		for(int i=1; i<=n+1; i++) {
			// vip 아닐때
			if(dp[i] != -1) {
				if(dp[i-1] == -1) {
					dp[i] =  1;
				}else if(dp[i-2] == -1 ){
					dp[i] = 2;
				}else {
					dp[i] = dp[i-1] + dp[i-2];
				}
			}else {
				if(dp[i-1] != -1) {
					total *= dp[i-1];
				}
			}
		}
		System.out.println(total);
	}
}
