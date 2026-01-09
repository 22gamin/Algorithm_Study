package xweek21;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int cnt;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static void dfs(int startX, int startY, int k){

        for(int i = 0; i<4; i++){
            int x = startX + dx[i];
            int y = startY + dy[i];

            if(x>=0 && y>=0 && x<N && y<N && !visited[x][y] && graph[x][y] - k > 0){
                visited[x][y] = true;
                dfs(x,y,k);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(graph[i][j], max);
            }
        } //입력 끝

        int best = 1;
        for(int k = 1; k<=max; k++){
            cnt = 0;
            visited = new boolean[N][N];

            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if (!visited[i][j] && graph[i][j] - k > 0){
                        visited[i][j] = true;
                        dfs(i,j,k);
                        cnt++;
                    }
                }
            }

            best = Math.max(cnt, best);
        }
        System.out.println(best);
    }
}
