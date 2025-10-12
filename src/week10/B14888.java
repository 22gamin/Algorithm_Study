package week10;

import java.io.*;
import java.util.*;

public class B14888 {
    static int N;
    static int[] A;
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mult = Integer.parseInt(st.nextToken());
        int div  = Integer.parseInt(st.nextToken());

        dfs(1, A[0], plus, minus, mult, div);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    static void dfs(int idx, int cur, int plus, int minus, int mult, int div) {
        if (idx == N) {
            maxVal = Math.max(maxVal, cur);
            minVal = Math.min(minVal, cur);
            return;
        }

        int next = A[idx];

        if (plus > 0)  dfs(idx + 1, cur + next, plus - 1, minus, mult, div);
        if (minus > 0) dfs(idx + 1, cur - next, plus, minus - 1, mult, div);
        if (mult > 0)  dfs(idx + 1, cur * next, plus, minus, mult - 1, div);
        if (div > 0) {
            dfs(idx + 1, cur / next, plus, minus, mult, div - 1);
        }
    }
}
