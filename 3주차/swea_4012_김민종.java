import java.io.*;
import java.util.*;

public class swea_4012_김민종 {
    static int N, answer;
    static int[][] S;
    static boolean[] pick; // true면 A, false면 B

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) S[i][j] = Integer.parseInt(st.nextToken());
            }

            answer = Integer.MAX_VALUE;
            pick = new boolean[N];
            pick[0] = true;                // 대칭 제거: 0번은 항상 A

            comb(1, 1);                    // idx=1부터, A에 현재 1명(0번)

            System.out.println("#" + t + " " + answer);
        }
    }

    //A에 cnt명을 선택한 상태로, 다음 후보 idx부터 진행
    static void comb(int idx, int cnt) {
        if (cnt == N / 2) {                // 팀 만들고 시너지 계산
            int sumA = 0, sumB = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (pick[i] && pick[j]) sumA += S[i][j] + S[j][i];
                    else if (!pick[i] && !pick[j]) sumB += S[i][j] + S[j][i];
                }
            }
            int diff = Math.abs(sumA - sumB);
            if (diff < answer) answer = diff;
            return;
        }
        if (idx >= N) return;

        // 가지치기(남은 인원으로 N/2 채울 수 없는 경우 방지)
        if (cnt + (N - idx) < N / 2) return;

        // 현재 idx를 A에 넣기
        pick[idx] = true;
        comb(idx + 1, cnt + 1);

        // 현재 idx를 B에 넣기
        pick[idx] = false;
        comb(idx + 1, cnt);
    }
}
