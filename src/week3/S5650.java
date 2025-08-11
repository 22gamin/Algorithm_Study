package practice;

import java.io.*;
import java.util.*;
 
public class S5650 {
    static int N;
    static int[][] map;
    static List<int[]>[] wormholes; // 6~10 웜홀 좌표 저장
    static int maxScore;
     
    // 상(0), 우(1), 하(2), 좌(3)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
 
    // 블록 반사 규칙 (blockType 1~5)
    // reflect[block][dir] = newDir
    static int[][] reflect = {
        {}, // 0번 인덱스 사용 X
        {2, 3, 1, 0}, // block 1
        {1, 3, 0, 2}, // block 2
        {3, 2, 0, 1}, // block 3
        {2, 0, 3, 1}, // block 4
        {2, 3, 0, 1}  // block 5 (사각형: 모든 방향 반대)
    };
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            wormholes = new ArrayList[11]; // 0~10 (6~10만 사용)
            for (int i = 6; i <= 10; i++) wormholes[i] = new ArrayList<>();
 
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] >= 6 && map[i][j] <= 10) {
                        wormholes[map[i][j]].add(new int[]{i, j});
                    }
                }
            }
 
 
            maxScore = 0;
            // 모든 빈칸에서 4방향 시뮬레이션
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        for (int d = 0; d < 4; d++) {
                            simulate(i, j, d);
                        }
                    }
                }
            }
 
            sb.append("#").append(tc).append(" ").append(maxScore).append("\n");
        }
        System.out.print(sb.toString());
    }
 
    static void simulate(int sx, int sy, int dir) {
        int x = sx;
        int y = sy;
        int d = dir;
        int score = 0;
 
        while (true) {
            x += dx[d];
            y += dy[d];
 
            // 벽에 부딪힘
            if (x < 0 || y < 0 || x >= N || y >= N) {
                d = (d + 2) % 4; // 반대 방향
                score++;
                continue;
            }
 
            // 게임 종료 조건
            if ((x == sx && y == sy) || map[x][y] == -1) {
                maxScore = Math.max(maxScore, score);
                return;
            }
 
            int cell = map[x][y];
 
            // 블록
            if (cell >= 1 && cell <= 5) {
                d = reflect[cell][d];
                score++;
            }
            // 웜홀
            else if (cell >= 6 && cell <= 10) {
                int[] next = wormholes[cell].get(0)[0] == x && wormholes[cell].get(0)[1] == y
                        ? wormholes[cell].get(1)
                        : wormholes[cell].get(0);
                x = next[0];
                y = next[1];
            }
            // 0일 경우: 그냥 직진
        }
    }
}
