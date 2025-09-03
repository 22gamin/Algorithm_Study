package week1;

import java.util.Arrays;
import java.util.Scanner;

// 중복 수열
public class B10971 {
	static int n, m;
	static int[] num;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n];
		result = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num); // 사전순 보장

		dfs(0);
		System.out.print(sb.toString());
	}

	static void dfs(int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				if (i > 0) {
					sb.append(' ');
				}
				sb.append(result[i]);
			}
			sb.append('\n');
			return;
		}

		int lastUsed = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (num[i] == lastUsed) // 같은 값은 이 depth에서 스킵
				continue;
			lastUsed = num[i];

			result[depth] = num[i];
			dfs(depth + 1);
		}
	}
}
