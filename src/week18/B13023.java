package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class B13023 {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean found = false; // 조건 만족하면 true로 바꾸고 종료

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 무방향 그래프
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        visited = new boolean[N];

        // 각 정점을 시작점으로 DFS
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 1);      // i에서 시작, 깊이 1 (자기 자신만 있는 상태)
            visited[i] = false;

            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }

    static void dfs(int cur, int depth) {
        if (found) return;       // 이미 찾았으면 더 안 탐색해도 됨

        if (depth == 5) {        // A-B-C-D-E → 5명
            found = true;
            return;
        }

        for (int next : adj[cur]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;  // 백트래킹
            }
        }
    }
}
