package week_8;

import java.util.*;
import java.io.*;

public class boj_2533 {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 1번 노드를 루트로 하여 DFS 시작
        dfs(1);

        // 루트가 얼리 어답터인 경우와 아닌 경우 중 최솟값 출력
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void dfs(int u) {
        visited[u] = true;

        dp[u][0] = 0; // u가 얼리 어답터가 아닐 때
        dp[u][1] = 1; // u가 얼리 어답터일 때 (자기 자신 포함)

        for (int v : graph[u]) {
            if (!visited[v]) {
                dfs(v); // 자식 노드로 DFS 재귀 호출

                // 점화식 적용
                // u가 얼리 어답터가 아니면, 자식 v는 반드시 얼리 어답터여야 함
                dp[u][0] += dp[v][1];

                // u가 얼리 어답터이면, 자식 v는 얼리 어답터이거나 아니거나 상관 없음 (더 작은 값 선택)
                dp[u][1] += Math.min(dp[v][0], dp[v][1]);
            }
        }
    }
}
