import java.util.*;
import java.io.*;

public class boj_16236 {
    static int size = 2;
    static int[][] arr;
    static int startX, startY, N;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        startX = 0;
        startY = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    startX = j;
                    startY = i;
                    arr[i][j] = 0;
                }
            }
        }

        int time = 0;
        int cnt = 0;
        while (true) {
            int[] result = bfs();

            if (result == null)
                break;

            int eatX = result[0];
            int eatY = result[1];
            int dist = result[2];

            // 상어 상태 업데이트
            time += dist;
            cnt++;
            arr[eatY][eatX] = 0;
            startX = eatX;
            startY = eatY;

            if (cnt == size) {
                size++;
                cnt = 0;
            }
        }

        System.out.println(time);
    }

    static int[] bfs() {
        // 방문했는지 확인용 + 거리 저장용 배열
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1); // 방문 안했으면 -1
        }
        dist[startY][startX] = 0;// 시작점이니까 0

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { startX, startY });

        // 얘네 셋을 반환해줄거임, 움직일 x, y 좌표 값과 최소 거리
        int ansX = -1;
        int ansY = -1;
        int minD = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            if (dist[curY][curX] > minD)
                continue;

            for (int d = 0; d < 4; d++) {
                int nX = curX + dx[d];
                int nY = curY + dy[d];

                // 다음 좌표가 배열 범위 안이고 방문하지 않았으며 상어의 크기보다 크지 않을 때
                if (nX < N && nX >= 0 && nY < N && nY >= 0 && dist[nY][nX] == -1 && arr[nY][nX] <= size) {
                    dist[nY][nX] = dist[curY][curX] + 1;

                    // 다음 위치에 물고기가 있고 물고기의 크기가 상어의 크기보다 작을 경우 먹으러 감
                    if (arr[nY][nX] > 0 && arr[nY][nX] < size) {
                        int curD = dist[nY][nX];

                        // 거리가 더 짧은거
                        if (curD < minD) {
                            minD = curD;
                            ansX = nX;
                            ansY = nY;
                        } // 거리가 같으면
                        else if (curD == minD) {
                            // 위에 있는거부터
                            if (nY < ansY) {
                                ansX = nX;
                                ansY = nY;
                            } // 그 다음은 왼쪽에 있는거
                            else if (nY == ansY && nX < ansX) {
                                ansX = nX;
                                ansY = nY;
                            }
                        }
                    }
                    q.offer(new int[] { nX, nY });
                }
            }
        }
        if (ansX == -1) {
            return null;
        } else {
            return new int[] { ansX, ansY, minD };
        }
    }
}
