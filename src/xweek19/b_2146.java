package xweek19;

import java.util.*;
import java.io.*;

public class b_2146 {

    static int N, graph[][],mark;
    static boolean visited[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int min = Integer.MAX_VALUE;

    static void separate(int startX, int startY, int mark){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY});
        visited[startX][startY] = true;
        graph[startX][startY] = mark;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int i = 0; i<4; i++){
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if(x>=0 && y>=0 && x<N && y<N && !visited[x][y] && graph[x][y] == 1){
                    visited[x][y]= true;
                    graph[x][y] = mark;
                    queue.add(new int[]{x,y});
                }
            }
        }

    }

    static void bridge(int startX, int startY, int num){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY,0});
        visited = new boolean[N][N];
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            if(curr[2] >= min) continue;

            for(int i = 0; i<4; i++){
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if(x>=0 && y>=0 && x<N && y<N && !visited[x][y]){

                    if(graph[x][y]==0){
                        visited[x][y] = true;
                        queue.add(new int[]{x,y,curr[2]+1});

                    }
                    else if(graph[x][y] !=0 && num != graph[x][y]){
                        min = Math.min(min, curr[2]);
                        return;
                    }
                }
            }
        }
    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        } //입력 끝

        mark= 2;
        for(int i = 0; i<N; i++){
            for(int j= 0; j<N; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    separate(i, j, mark++);
                }
            }
        }

        for(int i = 0; i<N; i++){
            for(int j= 0; j<N; j++){
                if(graph[i][j] >= 2){
                    bridge(i,j,graph[i][j]);
                }
            }

        }

        System.out.println(min);
    }
}
//1. visteid 없이
//2. graph에 바로 갱신
//3. while문 밑에 왜 안 읽히는지
