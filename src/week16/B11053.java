package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			dp[i]=1; // 자기 자신만 선택하는 경우
			
			for(int j=1;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max_value=1;
		for(int i=0;i<=n;i++) {
			max_value=Math.max(max_value, dp[i]);
		}
		System.out.println(max_value);
	}
}


