package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;

public class S1949 {
    public static class node implements Comparable<node>{
        int x, y, cost;
        public node(int x, int y, int cost) {
            this.x =x;
            this.y = y;
            this.cost = cost;
        }
        // 내림차순
        public int compareTo(node other) {
            return other.cost - this.cost;
        }
    }
    static int[][] map, vis;
    static int maxnum, n, k, maxlength;
    static List<node> li;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test=1; test<= t; test++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            maxnum = Integer.MIN_VALUE;
            map = new int[n][n];
            vis = new int[n][n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxnum = Math.max(map[i][j], maxnum);
                }
            }
            li = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(map[i][j] == maxnum) {
                        li.add(new node(i, j, map[i][j]));
                    }
                }
            }
            maxlength = Integer.MIN_VALUE;
            for(node cur : li) {
                vis[cur.x][cur.y] = 1;
                dfs(cur.x, cur.y, 1, false);
                vis[cur.x][cur.y] = 0;
            }
            System.out.println("#"+test+" " + maxlength);

        }
    }
    public static void dfs(int x, int y, int length, boolean chk) {
        maxlength = Math.max(maxlength, length);
        for(int d = 0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0||nx>=n||ny<0||ny>=n||vis[nx][ny] == 1) continue;
            // 이동 가능
            if(map[x][y]>map[nx][ny]) {
                vis[nx][ny] = 1;
                dfs(nx, ny, length+1, chk);
                vis[nx][ny] = 0;
            }else {
                if(!chk && (map[nx][ny] - k )<map[x][y]) {
                    int tmp = map[nx][ny];
                    map[nx][ny] = map[x][y]-1;
                    vis[nx][ny] = 1;
                    // 공사 후
                    dfs(nx, ny, length+1, true);
                    vis[nx][ny] = 0;
                    map[nx][ny] = tmp;
                }
            }
        }
        // 그냥 이동
        // 공사하고 이동
    }
}
