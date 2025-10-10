import java.util.*;
import java.io.*;

public class boj_2448 {
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][2 * N - 1]; // 여기다가 별 채울거임

        for (int i = 0; i < N; i++) { // 빈칸으로 만들어주고
            Arrays.fill(arr[i], ' ');
        }

        fx(N, 0, N - 1); // 맨 위 꼭짓점 좌표

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void fx(int n, int r, int c) {
        if (n == 3) { // 제일 작은 삼각형이 한 변의 크기가 3일 때임, 이 때 별 채워주기
            arr[r][c] = '*';
            arr[r + 1][c - 1] = '*';
            arr[r + 1][c + 1] = '*';
            arr[r + 2][c - 2] = '*';
            arr[r + 2][c - 1] = '*';
            arr[r + 2][c] = '*';
            arr[r + 2][c + 1] = '*';
            arr[r + 2][c + 2] = '*';
            return;
        }

        int half = n / 2;
        fx(n / 2, r, c); // 위쪽 삼각형
        fx(n / 2, r + half, c - half); // 아래 왼쪽 삼각형
        fx(n / 2, r + half, c + half); // 아래 오른쪽 삼각형
    }
}
