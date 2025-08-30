package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S25052 {
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
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test<=t; test++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int total = 0;
            // 우선순위큐 이용
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    pq.offer(new Node(i,j, map[i][j]));
                    int cnt = 0;
                    while(!pq.isEmpty()){
                        Node cur = pq.poll();
                        int curcost = cur.cost;
                        int mincost = Integer.MAX_VALUE;
                        int endx = 0;
                        int endy = 0;
                        for(int d = 0; d<4; d++){
                            int nx = cur.x + dx[d];
                            int ny = cur.y + dy[d];
                            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                            if(curcost<=map[nx][ny]) continue;
                            if(mincost>map[nx][ny]){
                                mincost = map[nx][ny];
                                endx = nx;
                                endy = ny;
                            }
                        }
                        cnt++;
                        if(mincost == Integer.MAX_VALUE) break;
                        pq.add(new Node(endx, endy, mincost));
                    }
                    total = Math.max(total, cnt);
                }
            }
            System.out.println("#"+test+" "+total);
        }
    }
}
