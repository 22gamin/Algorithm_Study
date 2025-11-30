package xweek18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2146 {
    static int n;
    static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    static int[][] map, country;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        country = new int[n][n];

        // 번호 매기기
        Queue<int[]> q = new LinkedList<>();
        int groundN = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0 || country[i][j] > 0) continue;
                q.offer(new int[]{i, j});
                groundN++;
                country[i][j] = groundN;
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    for(int d = 0; d<4; d++){
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];
                        if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                        if(country[nx][ny] > 0 || map[nx][ny] == 0) continue;
                        country[nx][ny] = groundN;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        int minnum = Integer.MAX_VALUE;

        for(int t=1; t<=groundN; t++){
            q = new LinkedList<>();
            int[][] dist = new int[n][n];
            int[][] vis = new int[n][n];
            // q에 넣기
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(country[i][j] == t) {
                        q.offer(new int[]{i, j});
                        vis[i][j] = 1;
                        dist[i][j] = 0;
                    }
                }
            }
            while(!q.isEmpty()){
                int[] cur = q.poll();

                if(dist[cur[0]][cur[1]] >= minnum) continue;
                for(int d = 0; d<4; d++){
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if(nx<0 || nx>=n || ny<0 || ny>=n) continue;

                    // 같은 땅이면 패스
                    if(country[nx][ny] == t){
                        continue;
                    }
                    // 다른 땅 만나면
                    if(country[nx][ny]!=t && map[nx][ny]>0){
                        minnum = Math.min(minnum, dist[cur[0]][cur[1]]);
                        continue;
                    }
                    if(map[nx][ny] == 0 && vis[nx][ny] == 0){
                        vis[nx][ny] = 1;
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        q.add(new int[]{nx,ny});
                    }

                }
            }
        }

        System.out.println(minnum);
    }
}
