package week_8;

import java.util.*;
import java.io.*;

public class boj_1916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] { v, w }); // new int[] {도착 도시, 비용}
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1]; // dist 배열 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // (o1, o2) -> o1[1] - o2[1] : 배열의 1번 인덱스(비용)를 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        dist[start] = 0;

        pq.offer(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curV = cur[0];
            int curW = cur[1];

            if (curW > dist[curV]) {
                continue;
            }

            for (int[] next : graph[curV]) {
                int nextV = next[0];
                int nextW = next[1];

                if (dist[nextV] > curW + nextW) {
                    dist[nextV] = curW + nextW;
                    pq.offer(new int[] { nextV, dist[nextV] });
                }
            }
        }

        System.out.println(dist[end]);
    }
}
