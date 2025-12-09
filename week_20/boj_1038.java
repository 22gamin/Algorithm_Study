package week_20;

import java.io.*;
import java.util.*;

public class boj_1038 {
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 전체 개수 -> 1024 - 1
        if (N > 1022) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            fx(i);
        }

        Collections.sort(list);

        System.out.println(list.get(N));
    }

    public static void fx(long n) {
        list.add(n);

        long last = n % 10;

        for (int i = 0; i < last; i++) {
            fx(n * 10 + i);
        }
    }
}
