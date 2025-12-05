package week_19;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class boj_1914 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger num = new BigInteger("2").pow(N).subtract(BigInteger.ONE);
        System.out.println(num);

        if (N <= 20) {
            fx(N, 1, 2, 3);
            System.out.println(sb);
        }
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
