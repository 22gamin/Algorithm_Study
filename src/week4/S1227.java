package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class S1227 {
    // 미로를 저장 할 Map
    static int[][] map;
    // 방문 여부를 저장 할 visit
    static boolean[][] visit;
    // 방향을 저장하는 배열
    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};
    // 시작지점과 목표 지점
    static int[] start,end;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++) {
            br.readLine();

            // 100으로 초기화해준다.
            map = new int[100][100];
            visit = new boolean[100][100];
            for(int i = 0; i < 100; i++){
                String line = br.readLine();
                for(int j = 0; j < 100; j++){
                    map[i][j] = line.charAt(j) - '0';
                    // 저장을 하면서 시작 지점이면 start에 저장
                    if(map[i][j] == 2){
                        start = new int[]{i,j};
                    }
                    // 목표 지점이라면 end에 저장
                    if(map[i][j] == 3){
                        end = new int[]{i,j};
                    }
                }
            }
            sb.append("#" + tc + " " + (bfs() ? "1" : "0")).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bfs(){
        // bfs를 위해 큐 선언
        Queue<int []> queue = new LinkedList<>();
        // 시작 지점 큐에 삽입 및 방문 처리
        queue.offer(start);
        visit[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] ns = queue.poll();
            int x = ns[0];
            int y = ns[1];

            for(int i = 0 ; i < 4; i++){
                int nX = x + dirX[i];
                int nY = y + dirY[i];

                // 벽이거나 Or 배열 밖이라면 continue (테두리는 벽이므로 처리 안해도 됨)
                if(map[nX][nY] == 1 || visit[nX][nY]){
                    continue;
                }

                if(nX == end[0] && nY == end[1]){
                    return true;
                }
                // 방문 처리 후 큐에 삽입
                visit[nX][nY] = true;
                queue.offer(new int[] { nX, nY});
            }
        }
        return false;
    }
}