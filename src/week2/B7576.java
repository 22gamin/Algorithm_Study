package week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576 {
    static class Pair{
        public int x, y;
        public Pair(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        int[][] arr = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
                // 1 익은 토마토 넣기
                if(arr[i][j] == 1) q.add(new Pair(i,j));
                // 0
                else if(arr[i][j] == 0) vis[i][j] = -1;
            }
        }
        // 익은 토마토부터 출발
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int a=0; a<4; a++) {
                int nx = dx[a] + cur.x;
                int ny = dy[a] + cur.y;
                if(nx<0 || nx>=n ||ny<0 || ny>=m) continue;
                if(vis[nx][ny]>=0 || arr[nx][ny] == -1) continue;
                // 거리 계산
                vis[nx][ny] = vis[cur.x][cur.y] +1;
                q.add(new Pair(nx,ny));
            }
        }
        int cnt=0;
        boolean chk=false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // vis가 하나라도 -1이면 다 안익은것
                if(vis[i][j] == -1){
                    System.out.println(-1);
                    chk = true;
                    break;
                }
                if(cnt<vis[i][j]){
                    cnt = vis[i][j];
                }
            }
            if(chk) break;
        }
        if(!chk) System.out.println(cnt);
    }
}
