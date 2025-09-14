import java.util.*;
import java.io.*;

public class boj_13549 {
    static int max = 100001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[max];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        dist[N] = 0;
        pq.offer(new int[] { N, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pos = cur[0];
            int time = cur[1];

            if (pos == K) {
                System.out.println(time);
                return;
            }

            if (time > dist[pos]) {
                continue;
            }

            // 순간이동
            int nextPos = pos * 2;
            if (nextPos < max && dist[nextPos] > time) {
                dist[nextPos] = time;
                pq.offer(new int[] { nextPos, time });
            }

            // X + 1로 이동
            nextPos = pos + 1;
            if (nextPos < max && dist[nextPos] > time + 1) {
                dist[nextPos] = time + 1;
                pq.offer(new int[] { nextPos, time + 1 });
            }

            // X - 1로 이동
            nextPos = pos - 1;
            if (nextPos >= 0 && dist[nextPos] > time + 1) {
                dist[nextPos] = time + 1;
                pq.offer(new int[] { nextPos, time + 1 });
            }
        }
    }
}
