package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class S1249 {
    public static class Node implements Comparable<Node>{
        int x, y, cost;
        public Node(int x, int y, int cost){
            this.x =x ;
            this.y = y;
            this.cost = cost;
        }
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }
    static int n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test=1; test<=t; test++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dist = new int[n][n];
            for(int i=0; i<n; i++){
                // 주의
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                String s = br.readLine();
                for(int j=0; j<n; j++){
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            dikjstra();
            System.out.println("#"+test+" "+dist[n-1][n-1]);
        }
    }
    private static void dikjstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,0));
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curcost = cur.cost;
            if(curcost>dist[cur.x][cur.y]) continue;
            for(int d = 0; d<4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(dist[nx][ny] > curcost + map[nx][ny]){
                    dist[nx][ny] = curcost + map[nx][ny];
                    pq.offer(new Node(nx, ny, curcost + map[nx][ny]));
                }
            }
        }
    }
}
