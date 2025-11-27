package xweek18;

import java.util.*;
import java.io.*;

public class b_7579 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] active = new int[N];
		int[] cost = new int[N];
		int totalCost = 0;

		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n<N; n++) {
			active[n] = Integer.parseInt(st.nextToken());
		} // 사용중인 메모리 바이트 수
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n<N; n++) {
			cost[n] = Integer.parseInt(st.nextToken());
			totalCost += cost[n];
		} // 앱을 비활성화 했을 경우 비용
		// 입력 끝
		
		int[] dp = new int[totalCost+1];
		dp[0] = 0;
		
		for(int i = 0; i<N; i++) {
			for(int j = dp.length-1; j>=cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-cost[i]]+active[i]);
			}
		}
		
		for(int i = 0; i<dp.length; i++) {
			if(dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}

	}

}
