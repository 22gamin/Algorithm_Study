package test;

import java.util.*;
import java.io.*;

public class s_3499 {
	static int N;
	static String[] cards;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			N = Integer.parseInt(br.readLine());
			cards = new String[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				cards[n] = st.nextToken();
			}
			// 입력 끝
			div();

			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < N; i++) {
				sb.append(cards[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static void div() {
		String[] one = new String[N / 2 + 1];
		String[] two = new String[N / 2 + 1];

		if (N % 2 == 0) {
			for (int o = 0; o < N / 2; o++) {
				one[o] = cards[o];
			}
			int idx = 0;
			for (int t = N / 2; t < N; t ++) {
				two[idx++] = cards[t];
			}
		}
		else {
			for (int o = 0; o < N / 2+1; o++) {	
				one[o] = cards[o];
			}
			int idx = 0;
			for (int t = N / 2+1; t < N; t ++) {
				two[idx++] = cards[t];

			}
		}
		// 놓기
		int oneIdx = 0;
		int twoIdx = 0;
		for (int c = 0; c < N; c++) {
			if (c % 2 != 0) {
				cards[c] = two[oneIdx];
				oneIdx++;
			} else {
				cards[c] = one[twoIdx];
				twoIdx++;
			}
		}

	}

}
