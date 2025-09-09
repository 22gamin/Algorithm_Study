package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717 {
	static int N, M;
	static int[] parents;

	static void make(int n) {
		parents = new int[n + 1];
		for (int i = 0; i <= n; i++)
			parents[i] = i;
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		// 단순히 루트 번호가 큰 쪽에 작은 쪽을 붙임
		if (aRoot > bRoot)
			parents[bRoot] = aRoot;
		else
			parents[aRoot] = bRoot;

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		make(N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int mod = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (mod == 0) {
				union(a, b);
			} else {
				sb.append(find(a) == find(b) ? "YES" : "NO").append('\n');
			}
		}
		System.out.print(sb.toString());
	}
}
