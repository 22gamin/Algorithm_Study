package xweek10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B3584 {
    static List<Integer>[] li, child;
    static int[] arr, parents;
    static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int test = 1; test<=t; test++) {
            n = Integer.parseInt(br.readLine().trim());
            li = new ArrayList[n+1];
            child = new ArrayList[n+1];
            arr = new int[n+1];
            parents = new int[n+1];
            for(int i=1; i<=n; i++) {
                li[i] = new ArrayList<>();
                child[i] = new ArrayList<>();
            }
            for(int i=1; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // a가 b의 부모
                li[a].add(b);

                // 루트 찾기
                uni(a, b);
            }
            int root = 0;
            for(int i=1; i<=n; i++) {
                if(arr[i] == 0) root = i;
            }
            maketree(root, root);
            // parents배열 만들기

            StringTokenizer st = new StringTokenizer(br.readLine());
            int finA = Integer.parseInt(st.nextToken());
            int finB = Integer.parseInt(st.nextToken());
            int total = findparent(finA, finB);

            System.out.println(total);
        }
    }

    public static void maketree(int currentnode, int r) {
        for(int node : li[currentnode]) {
            if(node != r) {
                child[currentnode].add(node);
                parents[node] = currentnode;
                maketree(node, currentnode);
            }
        }
    }

    public static int findparent(int a, int b) {

        boolean[] visited = new boolean[n + 1];

        int current = a;
        while (current != 0) {
            visited[current] = true;
            current = parents[current];
        }

        current = b;
        while (current != 0) {
            if (visited[current]) {
                return current;
            }
            current = parents[current];
        }
        return 0;
    }

    public static void uni(int a, int b) {
        int fir = fin(a);
        int sec = fin(b);
        if(fir == sec) return;
        arr[sec] = fir;
        return;
    }

    public static int fin(int c) {
        if(0 == arr[c]) return c;
        return arr[c] = fin(arr[c]);
    }
}
