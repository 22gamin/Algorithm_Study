package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B12980 {
	static int N, S;
	static int[] arr;

	static List<Integer> zeroPos = new ArrayList<>(); // 0의 위치
	static List<Integer> missing = new ArrayList<>(); // 사용되지 않은 수들
	static long answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];

		boolean[] used = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 0) {
				zeroPos.add(i);
			} else {
				used[arr[i]] = true;
			}
		}

		for (int v = 1; v <= N; v++) {
			if (!used[v]) {
				missing.add(v);
			}
		}

		// 0의 개수-> 모든 순열 생성
		permuteAndCount();
		System.out.println(answer);
	}

	static void permuteAndCount() {
		int k = zeroPos.size();
		if (k == 0) {
			// 이미 완성되어 있는 경우
			if (scoreAscendingPairs(arr) == S) answer++;
            return;
		}

		// missing 리스트의 모든 순열을 순회
		int[] pick = new int[k];
		boolean[] used = new boolean[k];
		// missing 을 정렬하면 사전순 순열 생성이 깔끔
		Collections.sort(missing);
		dfsPerm(0, pick, used);
	}

	static void dfsPerm(int depth, int[] pick, boolean[] used) {
		int k = zeroPos.size();
		if (depth == k) {
			// pick 배열을 0 위치에 채운 배열을 만들어 점수 계산
			int[] filled = arr.clone();
			for(int i=0;i<k;i++) {
				filled[zeroPos.get(i)]=missing.get(pick[i]);
			}
			if(scoreAscendingPairs(filled)==S) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < k; i++) {
			if (used[i])
				continue;
			used[i] = true;
			pick[depth] = i;
			dfsPerm(depth + 1, pick, used);
			used[i] = false;
		}
	}
	
	// 점수 S = 오름차순 쌍 수 
	static int scoreAscendingPairs(int[] a) {
		int n = a.length;
		int s=0;
		for(int i=0;i<n;i++) {
			int ai=a[i];
			for(int j=i+1;j<n;j++) {
				if(ai<a[j]) s++;
			}
		}
		return s;
	}
}
