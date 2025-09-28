package week_9;

import java.util.*;
import java.io.*;

public class boj_7569 {
    // 상하좌우위아래
    static int[] dx = { 0, 0, -1, 1, 0, 0 };
    static int[] dy = { -1, 1, 0, 0, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][N][M];

        Queue<int[]> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                    if (arr[h][n][m] == 1) {
                        q.offer(new int[] { h, n, m });
                    }
                }
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];

            for (int i = 0; i < 6; i++) {
                int nextZ = z + dz[i];
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextZ >= 0 && nextZ < H && nextY >= 0 && nextY < N && nextX >= 0 && nextX < M
                        && arr[nextZ][nextY][nextX] == 0) {
                    arr[nextZ][nextY][nextX] = arr[z][y][x] + 1;
                    q.offer(new int[] { nextZ, nextY, nextX });
                }
            }
        }

        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, arr[h][n][m]);
                }
            }
        }

        System.out.println(max - 1);
    }
}
