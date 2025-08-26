package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S3124 {
    static class Node implements Comparable<Node>{
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
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test<=t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            List<Node> edges = new ArrayList<>();
            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cos = Integer.parseInt(st.nextToken());
                edges.add(new Node(a, b, cos));
            }
            Collections.sort(edges);

            // 초기화
            parent = new int[v + 1];
            for (int i = 1; i <= v; i++) {
                parent[i] = i;
            }
            long totalCost = 0;
            int count = 0;

            // mst
            for (Node edge : edges) {
                // 두 정점의 루트가 다를 경우
                if (fin(edge.x) != fin(edge.y)) {
                    uni(edge.x, edge.y);
                    totalCost += edge.cost;
                    count++;
                }
                // 간선 모두 선택
                if (count == v-1) {
                    break;
                }
            }
            System.out.println("#"+test+" "+totalCost);
        }
    }
    public static int uni(int a, int b){
        int fir = fin(a);
        int sec = fin(b);
        if(fir == sec) return 0;
        parent[sec] = fir;
        return 1;
    }
    public static int fin(int c){
        if(parent[c] == c) return c;
        return parent[c] = fin(parent[c]);
    }
}
