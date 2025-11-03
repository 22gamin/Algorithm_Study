import java.util.*; 
import java.io.*;

public class boj_1238 {
    static final int MAX = 1000 * 10000 + 1;
    static int N, M, X;
    static ArrayList<int[]>[] road; // 가는 길 계산
    static ArrayList<int[]>[] reverse; // 오는 길 계산

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        road = new ArrayList[N + 1];
        reverse = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            road[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            road[u].add(new int[] { v, w });
            reverse[v].add(new int[] { u, w });
        }

        int[] go = dijkstra(road, X);
        int[] back = dijkstra(reverse, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int time = go[i] + back[i];
            max = Math.max(max, time);
        }

        System.out.println(max);
    }

    public static int[] dijkstra(ArrayList<int[]>[] graph, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, MAX);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        dist[start] = 0;
        pq.offer(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int v = cur[0];
            int w = cur[1];

            if (w > dist[v]) {
                continue;
            }

            for (int[] next : graph[v]) {
                int nv = next[0];
                int nw = next[1];

                if (dist[nv] > w + nw) {
                    dist[nv] = w + nw;
                    pq.offer(new int[] { nv, dist[nv] });
                }
            }
        }
        return dist;
    }
}
