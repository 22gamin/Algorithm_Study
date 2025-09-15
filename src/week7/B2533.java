package week7;

import java.io.*;
import java.util.*;

public class B2533 {
    static int N;
    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dp = new int[N+1][2];
        visited = new boolean[N+1];

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0; // 얼리어답터 X
        dp[node][1] = 1; // 얼리어답터 O

        for (int child : graph[node]) {
            if (!visited[child]) {
                dfs(child);

                // node가 얼리어답터 O → 자식은 얼리어답터 O/X 둘 다 가능
                dp[node][1] += Math.min(dp[child][0], dp[child][1]);

                // node가 얼리어답터 X → 자식은 반드시 얼리어답터 O
                dp[node][0] += dp[child][1];
            }
        }
    }
}
