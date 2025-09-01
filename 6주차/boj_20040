import java.util.*;
import java.io.*;

public class boj_20040 {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int ans = 0;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!union(a, b)) { // false --> 사이클이 발생했다는거
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }

    public static int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    public static boolean union(int a, int b) {// a, b 연결
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) // 이미 연결되어 있으면 false
            return false;

        parent[bRoot] = aRoot;
        return true;
    }
}
