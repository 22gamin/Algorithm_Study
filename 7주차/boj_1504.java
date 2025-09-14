import java.util.*;
import java.io.*;

public class boj_1504 {
    // INF : 실제 경로의 최댓값보다 크면서, 덧셈 시 오버플로우를 일으키지 않는 값
    static final int INF = 200000000;
    static ArrayList<int[]>[] graph; // {도착점, 가중치}
    static int N, E;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수

        // 그래프 초기화(1부터 시작이니까 N + 1)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 양방향
            graph[u].add(new int[] { v, w });
            graph[v].add(new int[] { u, w });
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 다익 세번
        int[] distS = dijkstra(1); // 1에서 출발
        int[] distV1 = dijkstra(v1); // v1에서 출발
        int[] distV2 = dijkstra(v2); // v2에서 출발

        // 1 -> v1 -> v2 -> N
        long path1 = (long) distS[v1] + distV1[v2] + distV2[N];

        // 1 -> v2 -> v1 -> N
        long path2 = (long) distS[v2] + distV2[v1] + distV1[N];

        long result = Math.min(path1, path2);

        if (result >= INF) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }

    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        dist[start] = 0;
        pq.offer(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] currentNode = pq.poll();
            int currentV = currentNode[0];
            int currentW = currentNode[1];

            if (currentW > dist[currentV]) {
                continue;
            }

            for (int[] nextNode : graph[currentV]) {
                int nextV = nextNode[0];
                int nextW = nextNode[1];

                if (dist[nextV] > currentW + nextW) {
                    dist[nextV] = currentW + nextW;
                    pq.offer(new int[] { nextV, dist[nextV] });
                }
            }
        }
        return dist;
    }
}
