package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5427 {
    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        for(int test = 1; test<=t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            char[][] map = new char[n][m];
            Queue<Pair> fire = new LinkedList<>();
            Queue<Pair> sangoun = new LinkedList<>();
            for(int i=0; i<n; i++) {
                String s = br.readLine();
                for(int j=0; j<m; j++) {
                    char a = s.charAt(j);
                    if(a == '*') fire.offer(new Pair(i,j));
                    else if(a == '@') sangoun.offer(new Pair(i,j));

                    map[i][j] = a;
                }
            }
            // bfs
            int time = 0;
            int[][] vis = new int[n][m];
            vis[sangoun.peek().x][sangoun.peek().y] = 1;
            boolean chk=true;
            while(!sangoun.isEmpty()){
                time++;
                // 불 이동
                int firelen= fire.size();
                for(int i=0; i<firelen; i++){
                    Pair firecur= fire.poll();
                    for(int d = 0; d<4; d++){
                        int nx = firecur.x + dx[d];
                        int ny = firecur.y + dy[d];
                        if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                        if(map[nx][ny] == '#'|| map[nx][ny] == '*') continue;
                        map[nx][ny] = '*';
                        fire.offer(new Pair(nx,ny));
                    }
                }

                // 상근 이동
                int len = sangoun.size();
                for(int i=0; i<len; i++){
                    Pair cur = sangoun.poll();
                    for(int d = 0; d<4; d++){
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                        if(nx<0 || nx>=n || ny<0 || ny>=m) {
                            chk = false;
                            break;
                        }
                        if(map[nx][ny] == '#'||vis[nx][ny] == 1||map[nx][ny] == '*') continue;

                        vis[nx][ny] = 1;
                        sangoun.offer(new Pair(nx,ny));
                    }
                    if(!chk) break;
                }
                if(!chk) break;
            }
            if(!chk) System.out.println(time);
            else System.out.println("IMPOSSIBLE");
        }
    }
}