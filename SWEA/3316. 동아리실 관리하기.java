package test;
	
	import java.util.*;
	import java.io.*;
	class Solution
	{	
		
		
		public static void main(String[] args) throws Exception
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			for(int tc =1; tc<=t; tc++) {
				String a = br.readLine();
				int n =a.length();
				long [][] dp  = new long[n+1][16];
				int module = 1000000007;
				
				for(int i =1; i<=n;i++) {
					int manager = 1 << (a.charAt(i-1)-'A');
					if(i==1) { //day 1은 초기화 해줘야함 ㅇㅇㅇ
						for(int j=1; j<16; j++) {
							if((j&1)!=0 && (j&manager)!=0) {
								dp[i][j] = 1;
							}
						}
					}else {
						for(int j=1; j<16; j++) {
							if((j&manager)==0) {
								continue;
							}
							
							for(int k=1; k<16; k++) {
								if((j&k)!=0) {
									dp[i][j] = (dp[i][j]+dp[i-1][k]) %module;
								}
							}
						}
					}
				}
				
				
				long result = 0;
				
				for(int i =1; i<16; i++) {
					result=(result + dp[n][i]) %module;
				}
				System.out.println("#"+tc+" "+result);
				
			}
		}
	}
