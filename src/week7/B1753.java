package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
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
    static int[]dist;
    static int K,V,E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        li = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i=1; i<=V; i++) {
            li[i] = new ArrayList<>();
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            li[u].add(new Node(v,w));
        }
        bfs();
        for(int i=1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }
    public static void bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));
        dist[K] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curnode = cur.y;
            int curcost = cur.cost;
            // 안하면 시간초과
            // 같은 노드로 향하는 여러 리스트가 있을때 우선순위큐로 인해 작은게 먼저 처리된다
            // 이후 같은 노드로 가는 더 큰 가중치를 가진 리스트가 들어왔을때 불필요한 탐색을 줄여야한다
            if(curcost>dist[curnode]) continue;
            for(Node c : li[curnode]){
                if(dist[c.y] > c.cost + dist[curnode]){
                    dist[c.y] = c.cost + dist[curnode];
                    pq.offer(new Node(c.y, dist[c.y]));
                }
            }
        }
    }
}
