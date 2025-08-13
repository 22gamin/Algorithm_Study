
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b7Yf6ABcBBASw
 *      SWEA- 1486. 장훈이의 높은 선반
 * @category combination, powerset
 * @memory combi(27,056 kb)/powerset(24,916 kb)/dfs(21,792 kb)
 * @time combi(112 ms)/powerset(178 ms)/dfs(106 ms) 
 * 높이차가 가장 작은 탑의 높이를 만드는 점원의 인원 수가 몇명이 될지, 누가 될지 알 수 없음 
 * --> 전부 다 해봐야함 1명부터 주어진 점원까지 모든 경우의 수를 만들어 보는 방법 : 조합, 부분집합
 * 
 */
public class swea_1486_김민종 {

	static int N;// 점원의 수 N
	static int B;// 선반의 높이 B
	static int[] H; // 각 점원의 키 H
	static int gapMin; // 최소 차이 값을 저장할 변수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 최소 높이차에 큰 값 셋팅
			gapMin = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			H = new int[N];
			for (int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			// --------------Input End------------------

			//조합으로 구하기
			combination(0, 0);
//			makePowerSet();
//			dfs(0, 0);

			System.out.println("#" + tc + " " + gapMin);
		}

	}

	/**
	 * 조합 만들어가면서, 뽑을 때마다 B를 넘는지 확인하기.
	 * @param idx : 이번 순서에 뽑을 순번
	 * @param sum : 탑의 높이(누적)
	 */
	static void combination(int idx, int sum) {
		//더해져 온 높이가 선반 보다 높은지 계속 확인
		if(sum>=B&& sum-B<gapMin) {
			gapMin = sum-B;
			return;
		}
		
		//N번째 점원에 도달하면 return
		if(idx==N) return;
		
		for (int i = idx; i <N; i++) {
			//이번에 탑에 참여하는 점원의 키 더해서 다음으로.
			combination(i+1, sum+H[i]);
		}
	}

	// DFS+백트랙킹 : 사실상 부분집합!
	static void dfs(int idx, int sum) {
		//부분집합 완성되면 최소값 갱신 
		if(idx==N){
			if(sum>=B) {
				gapMin=Math.min(sum-B, gapMin);
			}
			return;
		}
		//가지치기 : 이미 구해둔 gapMin의 값보다 더 커진 경우 고려하지 않음
		if(sum-B>=gapMin) return;
		
		dfs(idx+1, sum+H[idx]); //이번 순서의 점원 탑에 참여하고 다음으로
		dfs(idx+1, sum); //이번 순서의 점원 탐에 참여 안하고 다음으로
	}

	// 부분집합(feat. 비트마스킹)
	static void makePowerSet() {
		
		//탑 참여 여부 확인을 위해 점원 수 만큼 비트를 밀어줌
		// N=5, 1<<N ==> 100000(00000~11111)까지 반복문 돎
		// 00000, 00001, 000011, 0000100 ...
		for (int i = 0; i <(1<<N); i++) {
			int sum = 0;
			//특정 점원이 현재 탑에 참여하고 있는지 확인
			for (int j = 0; j < N; j++) {
				if((i&(1<<j))>0) { //j번째 점원이 탑에 참여하고 있는지 검사
					//탑에 키값을 누적
					sum+=H[j];
					if(sum-B> gapMin) {//저장되어 있는 gapMin보다 작으면 더 안보기
						break;
					}
				}
			}
			if(sum>=B&&sum-B<gapMin) {
				gapMin = sum-B;// 갱신
			}
		}

	}

}