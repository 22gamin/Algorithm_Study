package swea;

import javax.xml.transform.stream.StreamSource;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class s_1227 {

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static int bfs(int[] start){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){

            int[] curr = queue.poll();

            for(int k = 0; k<4; k++){
                int x = curr[0] + dx[k];
                int y = curr[1] + dy[k];

                if (x < 0 || y < 0 || x >= 100 || y >= 100) continue;

                if (graph[x][y] == 0 && !visited[x][y]){
                    visited[x][y] = true;
                    queue.add(new int[]{x,y});
                }
                if (graph[x][y] == 3){
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < 10; tc++){
            int t = Integer.parseInt(br.readLine());

            //1은 벽을 나타내며 0은 길, 2는 출발점, 3은 도착점을 나타낸다.
            graph = new int[100][100];
            visited  = new boolean[100][100];

            int[] start = new int[2];
            int[] fin = new int[2];

            for(int i = 0; i<100; i++){
                String str = br.readLine();
                for(int j = 0; j<100; j++){
                    graph[i][j] = str.charAt(j) - '0';

                    if (graph[i][j] == 2){
                        start = new int[]{i,j};
                    }

                }
            }
            //입력 끝 ----

            int b = bfs(start);
            sb.append("#").append(t).append(" ").append(b).append("\n");
        }
        System.out.println(sb);
    }
}
