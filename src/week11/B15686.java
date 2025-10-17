package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15686 {

	static int N, M;
	static List<int[]> houses = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int v = Integer.parseInt(st.nextToken());
				if (v == 1)
					houses.add(new int[] { r, c });
				else if (v == 2)
					chickens.add(new int[] { r, c });
			}
		}
		comb(0, 0, new int[M]);

        System.out.println(answer);
	}

	static void comb(int start, int depth, int[] pick) {
		if (depth == M) {
			answer = Math.min(answer, cityDistance(pick));
			return;
		}
		int size = chickens.size();
		for (int i = start; i <= size - (M - depth); i++) {
			pick[depth] = i;
			comb(i + 1, depth + 1, pick);
		}
	}

	static int cityDistance(int[] pick) {
		int sum = 0;
		for (int[] h : houses) {
			int hr = h[0], hc = h[1];
			int best = Integer.MAX_VALUE;
			for (int idx : pick) {
				int[] ch = chickens.get(idx);
				int d = Math.abs(hr - ch[0]) + Math.abs(hc - ch[1]);
				if (d < best)
					best = d;
				if (best == 0)
					break;
			}
			sum += best;
			if (sum >= answer)
				return sum;
		}
		return sum;
	}
}
