package swea;

import java.util.*;
import java.io.*;

public class s_1859 {

	public static void main(String[] args) throws IOException {

		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());  // 날 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] prices = new int[N];

			for (int i = 0; i < N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			// 뒤에서부터 탐색
			long profit = 0;
			int maxPrice = 0;

			for (int i = N - 1; i >= 0; i--) {
				if (prices[i] > maxPrice) {
					maxPrice = prices[i];  // 최고가 갱신
				} else {
					profit += (maxPrice - prices[i]);  // 이익 누적
				}
			}

			System.out.println("#" + tc + " " + profit);
		}

}
}
// 뒤집어서 맨뒤의 숫자를 가장 큰 값이라고 생각
// 하다가 나보다 더 큰 수 나오면 max 값 갱신하고 앞에것들 다 계산