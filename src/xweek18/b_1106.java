package xweek18;

import java.util.*;
import java.io.*;

public class b_1106 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[101+C];
		
		Arrays.fill(dp, 1000000);
		dp[0] = 0;
		
		for(int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int visiter = Integer.parseInt(st.nextToken());
			
			for(int i = visiter; i< dp.length; i++) {
				dp[i] = Math.min(dp[i], dp[i-visiter]+cost);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = C; i<dp.length; i++) {
			min = Math.min(min, dp[i]);
		}
		System.out.println(min);
	}

}
