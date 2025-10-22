import java.util.*;
import java.io.*;

public class boj_1167 {
    static ArrayList<int[]>[] arr;
    static int dist = 0;
    static boolean[] visited;
    static int max = 0; // 거리 값 저장용
    static int end = 0; // 정점에서 제일 먼 노드 저장용

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        arr = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }

        visited = new boolean[V + 1];

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int v2 = Integer.parseInt(st.nextToken());
                if (v2 == -1)
                    break;
                int w = Integer.parseInt(st.nextToken());
                arr[v1].add(new int[] { v2, w });
                arr[v2].add(new int[] { v1, w });
            }
        }

        // 시작점을 문제에서 알려주지 않았으나 어디에서 돌려도 ㄱㅊ
        dfs(1, 0);

        // dfs 또 하게 값 초기화해줌
        max = 0;
        visited = new boolean[V + 1];

        dfs(end, 0);

        System.out.println(max);
    }

    public static void dfs(int node, int dist) {
        visited[node] = true;

        if (dist > max) {
            max = dist;
            end = node;
        }

        for (int[] i : arr[node]) {
            if (!visited[i[0]]) {
                dfs(i[0], dist + i[1]);
            }
        }
    }
}
