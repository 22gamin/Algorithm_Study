package week_19;

import java.util.*;
import java.io.*;

public class boj_11729 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, N) - 1).append('\n');

        fx(N, 1, 2, 3);

        System.out.println(sb);
    }

    public static void fx(int n, int one, int two, int three) {
        if (n == 1) {
            sb.append(one).append(" ").append(three).append('\n');
            return;
        }
        // 1번에서 2번으로 옮기기
        fx(n - 1, one, three, two);

        sb.append(one).append(" ").append(three).append('\n');

        // 2번에서 3번으로 옮기기
        fx(n - 1, two, one, three);
    }
}
