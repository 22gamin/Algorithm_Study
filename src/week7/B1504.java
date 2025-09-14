package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 특정한 최단 경로
public class B1504 {
    public static class Node implements Comparable<Node>{
        int y, cost;
        public Node(int y, int cost){
            this.y=y;
            this.cost=cost;
        }
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }
    static List<Node>[] li;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        li = new ArrayList[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        for(int i=1; i<=N; i++){
            li[i] = new ArrayList<>();
        }
        int E = Integer.parseInt(st.nextToken());
        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            li[a].add(new Node(b,c));
            li[b].add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        bfs(1);
        int len1 = dist[first];
        int len2 = dist[second];
        Arrays.fill(dist, INF);

        bfs(first);
        int len11 = dist[second];
        int total1 = dist[N];
        Arrays.fill(dist, INF);

        bfs(second);
        int len22 = dist[first];
        int total2 = dist[N];

        if(len1 == INF || len2 == INF || len11 == INF || len22 == INF || total1 == INF || total2 == INF){
            System.out.println("-1");
            return;
        }
        long result = Math.min(len1+len11+total2, len2+len22+total1);
        System.out.println(result);
    }
    public static void bfs(int str){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(str,0));
        dist[str] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curnode = cur.y;
            int curcost = cur.cost;
            //if(curcost > dist[curnode]) continue;
            for(Node c : li[curnode]){
                if(dist[c.y] > c.cost + dist[curnode]){
                    dist[c.y] = c.cost + dist[curnode];
                    pq.add(new Node(c.y, dist[c.y]));
                }
            }
        }
    }
}
