import java.util.*;
import java.io.*;

public class boj_11444 {
    static int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        //피보나치 F1, F0
        long[][] start = { { 1, 1 }, { 1, 0 } };
        long[][] ans = power(start, n);

        System.out.println(ans[0][1] % MOD);
    }

    //분할 정복
    public static long[][] power(long[][] mat, long n) {
        if (n == 1) {
            return mat;
        }

        long[][] half = power(mat, n / 2);

        long[][] result = multiply(half, half);

        if (n % 2 == 1) {
            result = multiply(result, mat);
        }

        return result;
    }

    //행렬 곱셈
    public static long[][] multiply(long[][] mat1, long[][] mat2) {
        long[][] result = new long[2][2];

        result[0][0] = (mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0]) % MOD;
        result[0][1] = (mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1]) % MOD;
        result[1][0] = (mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0]) % MOD;
        result[1][1] = (mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1]) % MOD;

        return result;
    }
}
