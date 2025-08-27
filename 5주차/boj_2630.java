import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj_2630 {
    static int[][] paper;
    static int whiteCount = 0;
    static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    public static void solve(int row, int col, int size) {
        if (isSameColor(row, col, size)) {           // 현재 구역의 색이 모두 같은지 확인
            if (paper[row][col] == 0) {              // 색깔에 따라 카운트 증가
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }

        int newSize = size / 2;                             // 색이 섞여있으면 4분할

        solve(row, col, newSize);                           // 1사분면
        solve(row, col + newSize, newSize);                 // 2사분면
        solve(row + newSize, col, newSize);                 // 3사분면
        solve(row + newSize, col + newSize, newSize);       // 4사분면
    }

    public static boolean isSameColor(int row, int col, int size) {     //해당 구역이 모두 같은 색인지 확인
        int color = paper[row][col];            // 첫 번째 칸을 기준으로 색 비교

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != color) {
                    return false;               // 다른 색이 발견되면 컷
                }
            }
        }
        return true;
    }
}