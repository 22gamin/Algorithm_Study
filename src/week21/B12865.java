package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] w = new int[n+1];
		int[] v= new int[n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			w[i]=Integer.parseInt(st.nextToken());
			v[i]=Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n+1][k+1];
		
		for(int i=1;i<=n;i++) {
			for(int weight=1; weight<=k; weight++) {
				if(w[i]>weight) {
					dp[i][weight] = dp[i-1][weight];
				}else {
					dp[i][weight]=Math.max(dp[i-1][weight],dp[i-1][weight-w[i]]+v[i]);
				}
			}
		}
		
		System.out.print(dp[n][k]);
	}

}
