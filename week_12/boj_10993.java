import java.util.*;
import java.io.*;

public class boj_10993 {
    static char[][] arr;
    static int[] h;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        h = new int[N + 1];
        h[1] = 1;
        for (int i = 2; i <= N; i++) {
            h[i] = h[i - 1] * 2 + 1;
        }

        arr = new char[h[N]][2 * h[N] - 1];

        for (char[] i : arr) {
            Arrays.fill(i, ' ');
        }

        // 홀수랑 짝수 시작점 다름
        if (N % 2 == 0) {
            fx(N, 0, h[N] - 1);
        } else {
            fx(N, h[N] - 1, h[N] - 1);
        }

        // 오른쪽 공백 지워야됨
        for (int i = 0; i < h[N]; i++) {
            int last = arr[i].length - 1;
            while (last >= 0 && arr[i][last] == ' ')
                last--;
            for (int j = 0; j <= last; j++)
                sb.append(arr[i][j]);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void fx(int n, int r, int c) {
        if (n == 1) {
            arr[r][c] = '*';
            return;
        }
        if (n % 2 == 0) {

            int left = c;
            int right = c;
            // 한줄 채우기
            for (int i = 0; i <= (h[n] * 2 - 1) / 2; i++) {
                arr[r][left - i] = '*';
                arr[r][right + i] = '*';
            }

            left = c;
            right = c;
            // 삼각형 옆면
            for (int i = r + h[n] - 1; i >= r + 1; i--) {
                arr[i][left] = '*';
                arr[i][right] = '*';
                left--;
                right++;
            }

        }

        if (n % 2 != 0) {
            int left = c;
            int right = c;
            // 한줄 채우기
            for (int i = 0; i <= (h[n] * 2 - 1) / 2; i++) {
                arr[r][left - i] = '*';
                arr[r][right + i] = '*';
            }

            // 삼각형 옆면
            for (int i = r - (h[n] - 1); i <= r; i++) {
                arr[i][left] = '*';
                arr[i][right] = '*';
                left--;
                right++;
            }
        }

        int half = h[n] / 2;
        if (n % 2 == 0) {
            fx(n - 1, r + half, c);
        } else {
            fx(n - 1, r - half, c);
        }
    }
}
