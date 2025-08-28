import java.util.*;
import java.io.*;

public class boj_13023 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);        //양방향
            graph.get(b).add(a);        //양방향
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N]; //시작점마다 visited 초기화
            dfs(i, 0);
            if (found) {
                break;              // 찾았으면 컷
            }
        }

        if (found) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int node, int depth) {
        if (found) {              //찾으면 끝
            return;
        }

        if (depth == 4) {           //길이가 4면 끝
            found = true;
            return;
        }

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, depth + 1);
            }
        }

        visited[node] = false;      //백트래킹
    }
}
