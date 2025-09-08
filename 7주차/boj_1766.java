import java.util.*;
import java.io.*;

public class boj_1766 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> g = new ArrayList<>(); // 인접 리스트
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        int[] arr = new int[N + 1]; // 진입 차수 저장용
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            g.get(A).add(B); // A -> B
            arr[B]++; // 진입 차수 증가
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 진입 차수가 0인 노드를 오름차순 저장
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) // 진입 차수가 0인 노드를 큐에 추가
                pq.add(i);
        }

        // 위상 정렬
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll(); // 진입 차수가 0인 노드 출력
            sb.append(cur).append(" ");
            for (int next : g.get(cur)) {
                arr[next]--; // 다음 노드의 진입 차수 감소
                if (arr[next] == 0) // 진입 차수가 0이 되면 큐에 추가
                    pq.add(next);
            }
        }

        System.out.print(sb);
    }
}
