import java.util.*;
import java.io.*;

public class swea_2105_김민종 {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int maxDesserts;
    
    // 방향: ↘, ↙, ↖, ↗
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            maxDesserts = -1;


            for (int i = 0; i < N; i++) {           // 모든 가능한 시작점(i, j)을 탐색
                for (int j = 0; j < N; j++) {
                    visited = new boolean[101];     // 디저트 종류는 1~100
                    
                    visited[map[i][j]] = true;
                    
                    dfs(i, j, i, j, 0, 1);          // 첫 번째 방향(↘)으로 DFS 탐색 시작
                }
            }

            System.out.println("#" + tc + " " + maxDesserts);
        }
    }
    
    // DFS
    public static void dfs(int x, int y, int startX, int startY, int dir, int count) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (dir == 3 && nx == startX && ny == startY) {         // 마지막 방향(↗)에서 시작점으로 돌아왔을 때
            maxDesserts = Math.max(maxDesserts, count);
            return;
        }

        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {       //지도 범위를 벗어나거나
            return;
        }
        if (visited[map[nx][ny]]) {                         //이미 방문했으면
            return;
        }

        visited[map[nx][ny]] = true;
        
        dfs(nx, ny, startX, startY, dir, count + 1);        // 현재 방향 그대로 직진

        if (dir < 3) {                                      // 방향 꺾기 (마지막 방향이 아닐 때만)
            dfs(nx, ny, startX, startY, dir + 1, count + 1);
        }
        
        visited[map[nx][ny]] = false;                       //백트래킹
    }
}