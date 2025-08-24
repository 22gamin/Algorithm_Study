package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1227 {
    public static class Pair{
        public int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int test = 1; test<=10; test++){
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[100][100];
            for(int i=0; i<100; i++){
                String s = br.readLine();
                for(int j=0; j<100; j++){
                    matrix[i][j] = s.charAt(j) - '0';
                }
            }
            int chk = 0;
            int[][] vis = new int[100][100];
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(1,1));
            vis[1][1] = 1;
            while(!q.isEmpty()){
                Pair cur = q.poll();
                for(int dir = 0; dir<4; dir++){
                    int nx = cur.x+dx[dir];
                    int ny = cur.y+dy[dir];
                    if(nx<0 |  nx>=100 || ny<0 || ny>=100) continue;
                    int tmp = matrix[nx][ny];
                    if(tmp == 3) {
                        chk = 1;
                        break;
                    }
                    if(tmp == 1 || vis[nx][ny] == 1) continue;
                    q.add(new Pair(nx, ny));
                    vis[nx][ny] = 1;
                }
                if(chk == 1){
                    System.out.println("#"+test+" "+1);
                    break;
                }
            }
            if(chk == 0){
                System.out.println("#"+test+" "+0);
            }
        }
    }
}
