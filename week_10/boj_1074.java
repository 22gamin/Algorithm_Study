import java.util.*;
import java.io.*;

public class boj_1074 {
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        fx(N, r, c);

        System.out.println(cnt);
    }

    public static void fx(int N, int r, int c) {
        if (N == 0)
            return;

        int half = (int) Math.pow(2, N - 1);

        // 좌상
        if (r < half && c < half) {
            fx(N - 1, r, c);
        }

        // 우상
        else if (r < half && c >= half) {
            cnt += half * half;
            fx(N - 1, r, c - half);
        }

        // 좌하
        else if (r >= half && c < half) {
            cnt += 2 * half * half;
            fx(N - 1, r - half, c);
        }

        // 우하
        else if (r >= half && c >= half) {
            cnt += 3 * half * half;
            fx(N - 1, r - half, c - half);
        }
    }
}
