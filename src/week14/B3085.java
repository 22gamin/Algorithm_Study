package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B3085 {
    static int N;
    static char[][] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        a = new char[N][N];
        for (int i = 0; i < N; i++) a[i] = br.readLine().trim().toCharArray();

        int ans = 1;

        // 오른쪽, 아래만 스왑해보면 모든 인접쌍을 커버
        int[][] dirs = {{0,1},{1,0}};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni >= N || nj >= N) continue;
                    if (a[i][j] == a[ni][nj]) continue; // 다른 색만 의미 있음

                    swap(i, j, ni, nj);
                    ans = Math.max(ans, evaluate());     // 전체 검사(간단/안전)
                    swap(i, j, ni, nj);                  // 복구
                }
            }
        }
        System.out.println(ans);
    }

    static void swap(int i, int j, int ni, int nj) {
        char t = a[i][j]; a[i][j] = a[ni][nj]; a[ni][nj] = t;
    }

    // 보드 전체에서 행/열 연속 최댓값 계산
    static int evaluate() {
        int best = 1;

        // 행 검사
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (a[i][j] == a[i][j-1]) cnt++;
                else { best = Math.max(best, cnt); cnt = 1; }
            }
            best = Math.max(best, cnt);
        }

        // 열 검사
        for (int j = 0; j < N; j++) {
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (a[i][j] == a[i-1][j]) cnt++;
                else { best = Math.max(best, cnt); cnt = 1; }
            }
            best = Math.max(best, cnt);
        }
        return best;
    }
}
