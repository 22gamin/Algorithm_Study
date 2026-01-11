package yweek2_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dx = {1,1,-1,-1,2,2,-2,-2};
        int[] dy = {2,-2,2,-2,1,-1,1,-1};

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];

            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startx = Integer.parseInt(st.nextToken());
            int starty = Integer.parseInt(st.nextToken());
            map[startx][starty] = 1;
            st = new StringTokenizer(br.readLine());
            int targetx = Integer.parseInt(st.nextToken());
            int targety = Integer.parseInt(st.nextToken());
            map[targetx][targety] = 2;

            if(startx == targetx && starty == targety){
                System.out.println(0);
                continue;
            }
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{startx, starty});
            int[][] vis = new int[n][n];
            vis[startx][starty] = 0;
            boolean total = false;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                for(int d = 0; d<8; d++){
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                    if(vis[nx][ny] > 0)continue;
                    if(map[nx][ny] == 2) {
                        System.out.println(vis[cur[0]][cur[1]]+1);
                        total = true;
                        break;
                    }
                    vis[nx][ny] = vis[cur[0]][cur[1]]+1;
                    q.add(new int[]{nx,ny});
                }
                if(total) break;
            }
        }
    }
}
