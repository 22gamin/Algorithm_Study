import java.io.*;
import java.util.*;

public class boj_15681 {
    static ArrayList<Integer>[] tree;
    static int[] size;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        size = new int[N + 1];
        visited = new boolean[N + 1];

        fx(R);

        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(size[q]).append('\n');
        }

        System.out.println(sb);
    }

    public static void fx(int cur) {
        visited[cur] = true;
        size[cur] = 1;

        for (int next : tree[cur]) {
            if (!visited[next]) {
                fx(next);
                size[cur] += size[next];
            }
        }
    }
}
