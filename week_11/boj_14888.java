package week_11;

import java.util.*;
import java.io.*;

public class boj_14888 {
    static int N;
    static int[] numbers;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int idx) {
        // 연산자 다 쓰면
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        // 연산자 4개 돌리기
        for (int i = 0; i < 4; i++) {
            // 해당 연산자가 1개 이상 있으면
            if (operator[i] > 0) {

                // 연산자 하나 씀
                operator[i]--;

                // 연산자
                switch (i) {
                    case 0: // +
                        dfs(num + numbers[idx], idx + 1);
                        break;
                    case 1: // -
                        dfs(num - numbers[idx], idx + 1);
                        break;
                    case 2: // *
                        dfs(num * numbers[idx], idx + 1);
                        break;
                    case 3: // /
                        dfs(num / numbers[idx], idx + 1);
                        break;
                }

                // 백트래킹
                operator[i]++;
            }
        }
    }
}
