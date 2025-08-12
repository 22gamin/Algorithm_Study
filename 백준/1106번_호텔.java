import java.io.*;
import java.util.*;

public class Main {
	static int c, n;
	static double[] dp;
	public static void main(String[] args )throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		dp = new double[c+100];
		for(int i = 0;i<c+100; i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		dp[0] = 0;
		while(n-->0) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st2.nextToken());
			int v = Integer.parseInt(st2.nextToken());
			for(int i =1; i<c+100; i++) {
				if(i-v >=0) {
					dp[i] = Math.min(dp[i], dp[i-v]+w);
				}
			}
		}
		double min = Double.MAX_VALUE;
		for(int i = c; i<c+100; i++) {
			min = Math.min(dp[i], min);
			
		}
		System.out.println((int)min);
	}
	
	
}
