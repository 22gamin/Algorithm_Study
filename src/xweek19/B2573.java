package xweek19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2573 {
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1년씩 흐르기
        int year = 0;
        int num;

        while(true){

            // 섬 번호매기기처럼
            num = 0;
            int[][] vis = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] == 0 || vis[i][j] > 0) continue;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    num++;
                    vis[i][j] = num;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int d = 0; d<4; d++) {
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny]!=0) continue;
                            if(map[nx][ny] == 0) continue;
                            vis[nx][ny] = num;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            if(num>1) break;
            if(num == 0){
                System.out.println(0);
                return;
            }

            int[][] meltingmap = new int[n][m];
            for(int i = 0; i < n; i++) {
                meltingmap[i] = map[i].clone(); // 한 줄씩 복사
            }

            // 빙하 녹이기
            for(int i=0; i<n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] == 0) continue;
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                            continue;
                        if (map[nx][ny] == 0) count++;
                    }
                    meltingmap[i][j] = Math.max(map[i][j] - count, 0);
                }
            }
            map = meltingmap;
            year++;
        }
        System.out.println(year);
    }
}
