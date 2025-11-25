package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] w = new int[n + 1];
		int[] v = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		int[][] k = new int[n + 1][W + 1];

		for (int i = 1; i <= n; i++) {
			for (int weight = 1; weight <= W; weight++) {
				if(w[i]>weight) {
					k[i][weight]=k[i-1][weight];
				}else {
					k[i][weight]=Math.max(k[i-1][weight-w[i]]+v[i], k[i-1][weight]);
				}
			}
		}
		System.out.println(k[n][W]);
	}
}
