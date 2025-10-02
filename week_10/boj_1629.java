import java.util.*;
import java.io.*;

public class boj_1629 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(fx(A, B, C));
    }

    // 거듭제곱 재귀
    public static long fx(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long x = fx(A, B / 2, C);

        // B가 짝수일 때
        if (B % 2 == 0) {
            return (x * x) % C;
        }

        // B가 홀수일 때
        else {
            return (((x * x) % C) * A) % C;
        }

    }
}
