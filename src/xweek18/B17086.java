package xweek18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = {1,0,-1,0,1,1,-1,-1};
        int[] dy = {0,1,0,-1,1,-1,1,-1};

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        Queue<int[]> shark = new LinkedList<>();
        int[][] vis = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) shark.add(new int[]{i, j});
                else vis[i][j] = -1;
            }
        }

        int maxnum = 0;
        while(!shark.isEmpty()){
            int[] cur = shark.poll();
            for(int d=0; d<8; d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];
                if(nx<0 || nx>=n || ny<0 || ny>=m ||
                        map[nx][ny] == 1) continue;

                if(vis[nx][ny] == -1) {
                    vis[nx][ny] = vis[cur[0]][cur[1]] + 1;
                    shark.add(new int[]{nx,ny});
                    maxnum = Math.max(vis[nx][ny], maxnum);
                }
            }
        }
        System.out.println(maxnum);
    }
}
