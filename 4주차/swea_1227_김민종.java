import java.util.*;
import java.io.*;

public class swea_1227_김민종 {
    static int[][] maze;
    static boolean[][] visited;
    static int startX, startY;
    
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int testCase = Integer.parseInt(br.readLine());
            
            maze = new int[100][100];
            visited = new boolean[100][100];
            
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    maze[i][j] = line.charAt(j) - '0';
                    if (maze[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }
            
            int ans = bfs();
            System.out.println("#" + testCase + " " + ans);
        }
    }
    
    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            if (maze[x][y] == 3) {
                return 1; // 도착점(3)을 찾으면 1 반환
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 유효성 검사: 미로 범위, 벽(1), 방문 여부
                if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && maze[nx][ny] != 1 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return 0; // 도착점을 찾지 못하면 0 반환
    }
}