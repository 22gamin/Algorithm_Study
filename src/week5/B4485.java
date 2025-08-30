package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B4485 {
    private static class Node implements Comparable<Node>{
        int x, y, cost;
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }
    static  int n;
    static int[][] map, dist;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        while(true){
            idx++;
            n = Integer.parseInt(br.readLine());
            // 종료 조건
            if(n == 0) break;
            dist = new int[n][n];
            map = new int[n][n];
            for(int i=0; i<n; i++){
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra();
            System.out.println("Problem "+idx+": "+ dist[n-1][n-1]);
        }

    }
    private static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(0,0,map[0][0]));
        dist[0][0] = map[0][0];
        //int[][] link = new int[n][n];
        //link[0][0] = 1;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curcost = cur.cost;
            if(curcost>dist[cur.x][cur.y]) continue;
            for(int d=0; d<4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                //if(link[nx][ny] == 1) continue;
                int nowdist = curcost+map[nx][ny];
                if(nowdist<dist[nx][ny]){
                    dist[nx][ny] = nowdist;
                    pq.add(new Node(nx, ny, nowdist));
                    //link[nx][ny] = 1;
                }
            }
        }
    }
}
