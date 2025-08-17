package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1486 {
	static int n,b,bestDiff;
	static int[] height;
	static int[] suffix; // 남은 최대 합 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			height=new int[n];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				height[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(height);
			reverse(height); // 내림차순 정렬
			
			suffix=new int[n+1];
			for(int i=n-1;i>=0;i--) {
				suffix[i]=suffix[i+1]+height[i];
			}
			
			bestDiff = Integer.MAX_VALUE;
			dfs(0,0);
			
			sb.append("#").append(t).append(' ').append(bestDiff).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void dfs(int cnt, int sum) {
		// b 이상이면 차이 갱신 후 리
		if(sum>=b) {
			int diff=sum-b;
			if(diff<bestDiff) {
				bestDiff=diff;
				return;
			}
		}
		
		if(cnt==n) return;
		
		
		dfs(cnt+1,sum+height[cnt]);
		dfs(cnt+1,sum);
		
	}
	
	static void reverse(int[] height) {
		for(int i=0,j=height.length-1;i<j;i++,j--) {
			int temp=height[i];
			height[i]=height[j];
			height[j]=temp;
		}
	}

}
