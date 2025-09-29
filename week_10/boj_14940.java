import java.util.*;
import java.io.*;

public class boj_14940 {
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //지도 정보 입력
        int[][] arr = new int[n][m];
        //방문 확인용
        boolean[][] check = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) {
                    q.offer(new int[] { i, j });
                    arr[i][j] = 0;
                    check[i][j] = true;
                }
            }
        }
        
        //bfs
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY >= 0 && nextY < n && nextX < m && nextX >= 0 && arr[nextY][nextX] == 1
                        && !check[nextY][nextX]) {
                    arr[nextY][nextX] = arr[y][x] + 1;
                    check[nextY][nextX] = true;
                    q.offer(new int[] { nextY, nextX });
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    sb.append(-1).append(' ');
                } else {
                    sb.append(arr[i][j]).append(" ");
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
