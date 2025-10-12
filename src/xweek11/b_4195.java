package xweek11;

import java.util.*;
import java.io.*;

public class b_4195 {


    static int[] parent;
    static int[] size;

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static int union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return size[rootX];
        }

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
            return size[rootY];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            return size[rootX];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());

            parent = new int[F * 2 + 1];
            size = new int[F * 2 + 1];

            Map<String, Integer> nameToId = new HashMap<>();
            int id = 1;

            for (int f = 0; f < F; f++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!nameToId.containsKey(name1)) {
                    parent[id] = id;
                    size[id] = 1;
                    nameToId.put(name1, id++);
                }
                if (!nameToId.containsKey(name2)) {
                    parent[id] = id;
                    size[id] = 1;
                    nameToId.put(name2, id++);
                }

                int networkSize = union(nameToId.get(name1), nameToId.get(name2));
                sb.append(networkSize).append('\n');
            }
        }
        System.out.print(sb);
    }
}
