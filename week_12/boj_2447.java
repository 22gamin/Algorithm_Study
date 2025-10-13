import java.util.*;
import java.io.*;

public class boj_2447 {
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 별을 문자열 배열에 박을거임
        arr = new char[N][N];

        // 공백으로 채우기
        for (char[] i : arr) {
            Arrays.fill(i, ' ');
        }

        fx(N, 0, 0);

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append('\n');

        }
        System.out.println(sb);
    }

    // 분할 정복
    // r, c을 ㅁ 모양의 좌상단 시작점 좌표로 정했음
    public static void fx(int n, int r, int c) {
        if (n == 3) {
            arr[r][c] = '*';
            arr[r][c + 1] = '*';
            arr[r][c + 2] = '*';
            arr[r + 1][c] = '*';
            arr[r + 1][c + 2] = '*';
            arr[r + 2][c] = '*';
            arr[r + 2][c + 1] = '*';
            arr[r + 2][c + 2] = '*';
            return;
        }
        int len = n / 3;
        fx(len, r, c);
        fx(len, r, c + len);
        fx(len, r, c + len * 2);
        fx(len, r + len, c);
        fx(len, r + len, c + len * 2);
        fx(len, r + len * 2, c);
        fx(len, r + len * 2, c + len);
        fx(len, r + len * 2, c + len * 2);
    }
}
