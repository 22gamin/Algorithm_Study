package swea;

import java.util.*;
import java.io.*;

public class s_linkProcesser {

    static int N,graph[][],minLen,maxCore;
    static List<int[]> point;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static void dfs(int pointDepths,int len,int connectedCore){

        if (connectedCore + (point.size() - pointDepths) < maxCore){
            return ;
        }

        if (pointDepths == point.size()){

            if (connectedCore > maxCore){
                maxCore = connectedCore;
                minLen = len;
            }
            else if (connectedCore == maxCore){
                minLen = Math.min(len,minLen);
            }
            return ;
        }

        int x = point.get(pointDepths)[0];
        int y = point.get(pointDepths)[1];

        for(int di = 0; di<4; di++){

            if (x >= 0 && y >= 0 && x<N && y<N) {
                if (check(x,y,di)) {
                    len +=  change(x,y,di,2);
                    dfs(pointDepths+1,len,connectedCore+1);

                    len -= change(x,y,di,0); //다시 원래대로
                }
            }

            //코어를 연결하지 않은 경우
            dfs(pointDepths+1,len,connectedCore);
        }
    }

    static boolean check(int x, int y,int dir){

        while(true){
            x += dx[dir];
            y += dy[dir];
            if (x < 0 || y<0|| x>=N || y>= N) return true;
            if (graph[x][y] == 1 || graph[x][y] == 2) return false;
        }
    }

    static int change(int x, int y, int dir, int status){
        int len = 0;

        while (true){
            x += dx[dir];
            y += dy[dir];

            if (x < 0 || y<0|| x>=N || y>= N) break;

            graph[x][y] = status;
            len++;
        }
        return len;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<T+1; tc++){
            N = Integer.parseInt(br.readLine().trim());
            graph = new int[N][N];
            point = new ArrayList<>();
            minLen = Integer.MAX_VALUE;
            maxCore = 0;

            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j = 0; j<N; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if ( graph[i][j] == 1 && i>0 && j >0 && i <N && j<N ){
                        point.add(new int[]{i,j}); //가장자리를 제외한곳에 위치한 코어
                    }
                }

                //입력 끝 ---

                //dfs로 가능한 방향 찾기 (코어나 다른 전선이 있는지 확인)
                //가장자리까지 쭉 해보는 메서드
                dfs(0,0,0);
            }
            System.out.println("#"+tc + " "+ minLen);
        }
    }
}
