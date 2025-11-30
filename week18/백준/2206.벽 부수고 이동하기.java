import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x, y, dist, broken;

        public Node(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; // 0 안부숨, 1 부숨

        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 공백 없이 들어오는 입력 처리
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 1, 0)); // 시작점도 거리에 포함하므로 1부터 시작
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist; // 도착
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

           
                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][cur.broken]) {
                        visited[nx][ny][cur.broken] = true;
                        q.add(new Node(nx, ny, cur.dist + 1, cur.broken));
                    }
                }
                
            
                else if (map[nx][ny] == 1) {
                    if (cur.broken == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true; 
                        q.add(new Node(nx, ny, cur.dist + 1, 1));
                    }
                }
            }
        }

        return -1;
    }
}
