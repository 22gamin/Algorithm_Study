package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int dp[][] = new int[31][31]; // m개 중에서 n개를 고르는 경우의 수
			for (int i = 0; i <= 30; i++) {
				dp[i][0] = 1; // nC0 = 1
				dp[i][i] = 1; // nCn = 1
			}

			for (int i = 1; i <= 30; i++) { // i = 전체 개수 (M)
				for (int j = 1; j < i; j++) { // j = 선택 개수 (N)
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
			
			System.out.println(dp[m][n]);
		}
	}

}
