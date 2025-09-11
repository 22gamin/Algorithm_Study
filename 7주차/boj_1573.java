import java.util.*;
import java.io.*;

public class boj_1753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()) - 1;

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[] { v, w }); // u에서 v로 가는 가중치가 w인 간선
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        // {정점 번호, 거리} 거리를 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        pq.add(new int[] { K, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];
            if (dist[u] < d) // 더 짧은 경로 이미 있으면 컷
                continue;
            for (int[] next : graph.get(u)) {
                int v = next[0];
                int w = next[1];
                if (dist[v] > dist[u] + w) { // 더 짧은 경로 찾으면
                    dist[v] = dist[u] + w; // 갱신
                    pq.add(new int[] { v, dist[v] }); // 갱신 정보를 큐에 추가
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i] + "\n");
            }
        }
        System.out.print(sb);
    }
}
