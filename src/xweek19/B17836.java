package xweek19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17836 {
    static int gumx, gumy;
    static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        // 입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    gumx = i;
                    gumy = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int[][] vis = new int[n][m];
        vis[0][0] = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d=0; d<4; d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];
                if(nx<0 || nx>=n || ny<0 || ny>=m || vis[nx][ny] > 0) continue;
                if(map[nx][ny] == 1)continue;
                // 0 이거나 2일때 모두 이동
                vis[nx][ny] =  vis[cur[0]][cur[1]] + 1;
                q.add(new int[]{nx,ny});
            }
        }
        int notgum;
        if(vis[n-1][m-1] == 0){
            notgum = Integer.MAX_VALUE;
        }else{
            notgum = vis[n-1][m-1]-1;
        }

        int gum;
        if(vis[gumx][gumy] == 0){
            gum = Integer.MAX_VALUE;
        }else{
            gum = vis[gumx][gumy]-1 + (n-1-gumx + m-1-gumy);
        }

        if(Math.min(gum, notgum)>T) System.out.println("Fail");
        else System.out.println(Math.min(gum, notgum));
    }
}
