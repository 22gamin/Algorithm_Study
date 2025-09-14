package beakjoon;

import java.util.*;
import java.io.*;

public class b_1753 {

    static int V, E, K,min;
    static List<Node>[] adjList;
    static int[] dist;

    static class Node implements Comparable<Node> {

        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }

        public String toString() {
            String str = "[" + this.node + "," + this.distance + "]";
            return str;
        }
    }

    static void find(int start) {

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;

        pq.add(new Node(start, 0));


        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            int node = curr.node;
            int distance = curr.distance;

            if (distance > dist[node]) continue;

            for (Node test : adjList[node]) {
                int newDist = dist[node] + test.distance;

                if (newDist < dist[test.node]) {
                    dist[test.node] = newDist;
                    pq.add(new Node(test.node, newDist));
                }
            }

        }


    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        adjList = new ArrayList[V + 1];

        for (int i = 0; i < V + 1; i++) {
            adjList[i] = new ArrayList<>();
        }


        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Node(v, w));
        }

        // 입력 끝

        find(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF \n");
            }
            else {
                sb.append(dist[i]).append("\n");
            }

        }
        System.out.println(sb);

    }

}

