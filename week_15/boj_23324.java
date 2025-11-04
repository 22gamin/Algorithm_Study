import java.util.*;
import java.io.*;

public class boj_23324 {
    static int[] parent;
    static long[] size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        size = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int uK = 0, vK = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (i == K) {
                uK = u;
                vK = v;
            } else {
                union(u, v);
            }
        }

        int uR = find(uK);
        int vR = find(vK);

        if (uR == vR) {
            System.out.println(0);
        } else {
            System.out.println(size[uR] * size[vR]);
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int rA = find(a);
        int rB = find(b);
        if (rA != rB) {
            if (size[rA] < size[rB]) {
                parent[rA] = parent[rB];
                size[rB] += size[rA];
            } else {
                parent[rB] = parent[rA];
                size[rA] += size[rB];
            }
        }
    }
}
