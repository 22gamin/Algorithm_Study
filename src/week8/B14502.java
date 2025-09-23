package week8;

import java.util.*;
import java.io.*;

public class B14502 {
    static int N, M;
    static int[][] lab;
    static int[][] copy;
    static int answer = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);
        System.out.println(answer);
    }

    // 벽 3개 세우기 (백트래킹)
    static void buildWall(int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) { // 빈 칸이면 벽 세움
                    lab[i][j] = 1;
                    buildWall(count + 1);
                    lab[i][j] = 0; // 원상복구 (백트래킹)
                }
            }
        }
    }

    // 바이러스 퍼뜨리기 (BFS)
    static void spreadVirus() {
        copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = lab[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();

        // 모든 바이러스 시작점 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (copy[nx][ny] == 0) {
                        copy[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        answer = Math.max(answer, getSafeArea());
    }

    // 안전 영역 개수 세기
    static int getSafeArea() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
