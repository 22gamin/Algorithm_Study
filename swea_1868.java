import java.util.*;
import java.io.*;

public class swea_1868 {
    static int N;
    static char[][] board;
    static int[][] mineCounts;
    static boolean[][] visited;
    
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            mineCounts = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            // 지뢰가 아닌 모든 칸에 대해 주변 지뢰 개수 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.') {
                        int count = 0;
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == '*') {
                                count++;
                            }
                        }
                        mineCounts[i][j] = count;
                    }
                }
            }

            int clicks = 0;

            // 주변 지뢰가 0인 칸 먼저 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.' && mineCounts[i][j] == 0 && !visited[i][j]) {
                        clicks++;           // 주변 지뢰가 0인 칸 클릭
                        bfs(i, j);          // 해당 칸을 기준으로 BFS
                    }
                }
            }
            
            // 나머지 칸들(숫자가 있는 칸) 하나씩 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.' && !visited[i][j]) {
                        clicks++;
                    }
                }
            }
            System.out.println("#" + tc + " " + clicks);
        }
    }
    
    //0칸을 눌렀을 때 주변의 인접한 모든 숫자가 있는 칸까지 열리게 하는 역할
    public static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            for (int d = 0; d < 8; d++) {           //8방향 탐색
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 유효성 검사
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (mineCounts[nx][ny] == 0) {
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}