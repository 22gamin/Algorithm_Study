package week_12;

import java.util.*;
import java.io.*;

public class boj_16928 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];

        for (int i = 1; i <= 100; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x] = y;
        }

        int[] dist = new int[101];

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                System.out.println(dist[100]);
                return;
            }

            // 주사위 던지기
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;

                if (next > 100)
                    continue;

                int pos = arr[next];
                if (dist[pos] == 0) {
                    dist[pos] = dist[cur] + 1;
                    q.offer(pos);
                }
            }
        }
    }
}
