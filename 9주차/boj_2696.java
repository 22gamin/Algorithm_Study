package week_9;

import java.util.*;
import java.io.*;

public class boj_2696 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            List<Integer> mid = new ArrayList<>();

            StringTokenizer st = null;
            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                int num = Integer.parseInt(st.nextToken());

                // maxHeap의 크기가 minHeap의 크기보다 크거나 같아야 함
                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }
                // maxHeap.peek()의 값이 minHeap의 값보다 작아야 함
                if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    int v1 = maxHeap.poll();
                    int v2 = minHeap.poll();
                    maxHeap.offer(v2);
                    minHeap.offer(v1);
                }

                // 홀수마다 중앙값 저장
                if ((i + 1) % 2 != 0) {
                    mid.add(maxHeap.peek());
                }
            }

            sb.append(mid.size()).append('\n');
            for (int i = 0; i < mid.size(); i++) {
                sb.append(mid.get(i)).append(" ");
                if ((i + 1) % 10 == 0 || i == mid.size() - 1) {
                    sb.append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
