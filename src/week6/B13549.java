package 과목평가;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13549 {

    static class Vertex implements Comparable<Vertex> {
        int no, totalDistance;
        public Vertex(int no, int totalDistance) {
            this.no = no;
            this.totalDistance = totalDistance;
        }
        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.totalDistance, o.totalDistance);
        }
    }

    static final int MAX = 100000;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        int[] dist = new int[MAX + 1];
        boolean[] visited = new boolean[MAX + 1];
        Arrays.fill(dist, INF);
        dist[N] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(N, 0));

        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();
            if (visited[cur.no]) continue;
            visited[cur.no] = true;

            if (cur.no == K) break; // 목표 도달하면 종료

            // 1. 순간이동 (비용 0)
            int next = cur.no * 2;
            if (next <= MAX && dist[next] > cur.totalDistance) {
                dist[next] = cur.totalDistance;
                pq.offer(new Vertex(next, dist[next]));
            }

            // 2. 걷기 -1 (비용 1)
            next = cur.no - 1;
            if (next >= 0 && dist[next] > cur.totalDistance + 1) {
                dist[next] = cur.totalDistance + 1;
                pq.offer(new Vertex(next, dist[next]));
            }

            // 3. 걷기 +1 (비용 1)
            next = cur.no + 1;
            if (next <= MAX && dist[next] > cur.totalDistance + 1) {
                dist[next] = cur.totalDistance + 1;
                pq.offer(new Vertex(next, dist[next]));
            }
        }

        System.out.println(dist[K]);
    }
}
