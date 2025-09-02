import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889 {

	static int[][] team;
	static int N;
	static boolean[] picked; // 스타트 팀 여부
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		picked = new boolean[N];
		picked[0] = true; // 대칭 충복 제거 0번(1번 사람)을 스타트 팀에 고정
		dfs(1, 1); // idx=1부터, 현재 스타트 팀 인원=1 (0번 고정)
		
		System.out.println(answer);
	}

	// idx : 현재 보고 있는 사람 번호
	// cnt : 지금까지 스타트 팀에 뽑힌 사람 수
	static void dfs(int idx, int cnt) {
		// 가지치기
		// 이미 너무 많이 뽑음, 남은 사람을 뽑아도 못채움
		int remain = N - idx;
		if (cnt > N / 2 || cnt + remain < N / 2)
			return;
		
		// 기저 조건
		if (cnt == N / 2) {
			evaluate();
			return;
		}
		
		// 범위 밖
		if (idx >= N) return;
		
		// 선택
		picked[idx]=true;
		dfs(idx+1, cnt+1);
		
		// 미선택
		picked[idx]=false;
		dfs(idx+1, cnt);
	}

	static void evaluate() {
		int start = 0, link = 0;
		// 팀 내부 쌍만 합치기
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if(picked[i] && picked[j]) {
					start+=team[i][j] + team[j][i];
				}
				else if(!picked[i] & !picked[j]) {
					link+=team[i][j] + team[j][i];
				}
			}
		}
		answer = Math.min(answer, Math.abs(start-link));
	}
}
