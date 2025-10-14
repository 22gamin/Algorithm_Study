package xweek12;

import java.util.*;
import java.io.*;

public class b_2579 {
	static int N,stairs[],dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stairs = new int[N];
		
		for(int n = 0; n<N; n++) {
			stairs[n] = Integer.parseInt(br.readLine());
		}
		// 입력 끝
		dp = new int[N];
		
		if(N==1) {
			System.out.println(stairs[0]);
			return;
		}
		
		if(N == 2) {
			System.out.println(stairs[0] + stairs[1]);
			return;
		}
		
		dp[0] = stairs[0];
		dp[1] = stairs[0] + stairs[1];
		dp[2] = Math.max(dp[0] + stairs[2], stairs[1] + stairs[2]);
		
		for(int i = 3; i<N; i++) {
			dp[i] = Math.max(dp[i-2] + stairs[i] , dp[i-3] + stairs[i-1] + stairs[i]);
		}

		System.out.println(dp[N-1]);
	}

}
