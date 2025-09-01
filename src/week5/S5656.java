package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S5656 {
    static class Point{
        int x,y, power;
        public Point(int x, int y, int power){
            this.x=x;
            this.y=y;
            this.power=power;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int minRemain, n, w, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test<=t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int[][] map = new int[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            minRemain = Integer.MAX_VALUE;
            dropMarble(0,map);
            System.out.println("#"+test+" "+minRemain);
        }
    }
    private static void dropMarble(int count, int[][] map){
        // 다 던지면
        if(count == n){
            int len = countBrick(map);
            minRemain = Math.min(minRemain, len);
            return;
        }
        if(countBrick(map) == 0){
            minRemain = 0;
            return;
        }

        // 중복순열
        for(int i=0; i<w; i++){
            int[][] newmap = copymap(map);
            int r = 0;
            while(r<h && newmap[r][i]==0){
                r++;
            }
            if(r<h){
                breakBrick(r,i,newmap);
                // 벽돌 내리기
                gravityBrick(newmap);
            }
            dropMarble(count+1,newmap);
        }
    }
    private static void breakBrick(int r, int c, int[][] map){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c,map[r][c]));
        // 첫번째꺼 맞음
        map[r][c] = 0;
        while(!q.isEmpty()){
            Point cur = q.poll();
            // 파워만큼
            for(int p = 1; p<cur.power; p++){
                for(int d = 0; d<4; d++){
                    int nr = cur.x + dr[d]*p;
                    int nc = cur.y + dc[d]*p;
                    if(nr<0 || nr>=h || nc<0 || nc>=w ||map[nr][nc]==0) continue;
                    q.add(new Point(nr,nc,map[nr][nc]));
                    map[nr][nc] = 0;
                }
            }
        }
    }
    private static void gravityBrick(int[][] map){
        for(int c = 0; c<w; c++){
            int emptyrow = h-1;
            for(int r = h-1; r>=0; r--){
                if(map[r][c] !=0){
                    int tmp = map[r][c];
                    map[r][c] = 0;
                    map[emptyrow][c] = tmp;
                    emptyrow--;
                }
            }
        }
    }
    private static int countBrick(int[][] map){
        int count = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j]>0) count++;
            }
        }
        return count;
    }

    private static int[][] copymap(int[][] map){
        int[][] tmpmap = new int[h][w];
        for(int i=0; i<h; i++){
            //System.arraycopy(map[i], 0, tmpmap[i], 0, w);
            tmpmap[i]=map[i].clone();
        }
        return tmpmap;
    }
}
