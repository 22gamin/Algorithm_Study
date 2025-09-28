package week9;

import java.util.*;
import java.io.*;

public class s_5607 {
    static final long P = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        long[] fact = new long[1000001];
        fact[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            fact[i] = (fact[i - 1] * i) % P;
        }

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long numerator = fact[N];
            long denominator = (fact[R] * fact[N - R]) % P;

            // 모듈러 역원 계산 (denominator^(P-2))
            long denominatorInverse = power(denominator, P - 2);

            long answer = (numerator * denominatorInverse) % P;

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    // 2. 거듭제곱 함수 (분할 정복)
    // base^exp % P
    static long power(long base, long exp) {
        long result = 1L;
        while (exp > 0) {
            // 지수가 홀수이면, result에 base를 곱함
            if (exp % 2 == 1) {
                result = (result * base) % P;
            }
            // base를 제곱하고, 지수는 절반으로 나눔
            base = (base * base) % P;
            exp /= 2;
        }
        return result;
    }
}