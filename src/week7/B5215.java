package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test<=t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[] ing = new int[n+1];
			int[] k = new int[l+1];
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				ing[i] = Integer.parseInt(st.nextToken());
				k[i] = Integer.parseInt(st.nextToken());
			}
			int[][] d = new int[n+1][l+1];
			for(int i=1; i<=n; i++) {
				for(int w = 1; w<=l; w++) {
					// 조합에 넣지 않는 경우
					if(w<k[i]) d[i][w] = d[i-1][w];
					// 조합에 넣는 경우
					else {
						d[i][w] = Math.max(d[i-1][w], ing[i]+d[i-1][w - k[i]]);
					}
				}
			}
			System.out.println("#"+test+" "+d[n][l]);
		}
	}
}
