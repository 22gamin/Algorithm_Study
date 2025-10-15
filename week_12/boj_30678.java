import java.util.*;
import java.io.*;

public class boj_30678 {
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int len = (int) Math.pow(5.0, N);
        arr = new char[len][len];

        for (char[] c : arr) {
            Arrays.fill(c, ' ');
        }

        fx(N, 0, 0);

        StringBuilder sb = new StringBuilder();

        for (char[] c : arr) {
            sb.append(c).append('\n');
        }

        System.out.println(sb);
    }

    // 2차원 배열 시작점을 r, c로
    static void fx(int n, int r, int c) {
        if (n == 0) {
            arr[r][c] = '*';
            return;
        }

        int l = (int) Math.pow(5.0, n) / 5;

        fx(n - 1, r, c + 2 * l);
        fx(n - 1, r + l, c + 2 * l);
        fx(n - 1, r + 2 * l, c);
        fx(n - 1, r + 2 * l, c + l);
        fx(n - 1, r + 2 * l, c + 2 * l);
        fx(n - 1, r + 2 * l, c + 3 * l);
        fx(n - 1, r + 2 * l, c + 4 * l);
        fx(n - 1, r + 3 * l, c + l);
        fx(n - 1, r + 3 * l, c + 2 * l);
        fx(n - 1, r + 3 * l, c + 3 * l);
        fx(n - 1, r + 4 * l, c + l);
        fx(n - 1, r + 4 * l, c + 3 * l);
    }
}
