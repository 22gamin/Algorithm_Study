import java.io.*;
import java.util.*;

public class S1238 {
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) { // 10개의 테스트케이스
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 데이터 길이
            int start = Integer.parseInt(st.nextToken()); // 시작점

            adj = new ArrayList[101];
            for (int i = 0; i <= 100; i++) {
                adj[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < L / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
            }

            int answer = bfs(start);
            System.out.println("#" + t + " " + answer);
        }
    }

    static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[101];

        q.offer(new int[]{start, 0});
        visited[start] = true;

        int maxDepth = 0;
        int maxNum = start;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int depth = cur[1];

            // 마지막 레벨 갱신
            if (depth > maxDepth) {
                maxDepth = depth;
                maxNum = node;
            } else if (depth == maxDepth) {
                maxNum = Math.max(maxNum, node);
            }

            for (int next : adj[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, depth + 1});
                }
            }
        }

        return maxNum;
    }
}
