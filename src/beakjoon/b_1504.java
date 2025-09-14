package beakjoon;

import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.*;

public class b_1504 {

    static int N, E;
    static List<Node>[] adjList;
    static final int INF = 200_000_000; // E(200,000) * w(1,000) 보다 큰 값

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // 양방향 그래프
            adjList[from].add(new Node(to, weight));
            adjList[to].add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // --- 알고리즘 실행 ---

        // 1. 각 시작점(1, v1, v2)에서 다른 모든 정점까지의 최단 거리를 계산
        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);

        // 경로 1: 1 -> v1 -> v2 -> N
        // long 타입으로 계산하여 오버플로우 방지
        long route1 = (long)distFrom1[v1] + distFromV1[v2] + distFromV2[N];

        // 경로 2: 1 -> v2 -> v1 -> N
        long route2 = (long)distFrom1[v2] + distFromV2[v1] + distFromV1[N];

        // 두 경로 중 최솟값 찾기
        long answer = Math.min(route1, route2);

        // 만약 최단 경로가 INF 이상이면 경로가 없는 것으로 간주
        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    // 다익스트라 알고리즘
    static int[] dijkstra(int startNode) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[startNode] = 0;
        pq.offer(new Node(startNode, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.weight > dist[current.to]) {
                continue;
            }

            for (Node neighbor : adjList[current.to]) {
                int newDist = dist[current.to] + neighbor.weight;
                if (newDist < dist[neighbor.to]) {
                    dist[neighbor.to] = newDist;
                    pq.offer(new Node(neighbor.to, newDist));
                }
            }
        }
        return dist;
    }
}