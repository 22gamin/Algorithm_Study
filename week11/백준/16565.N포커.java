import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 10007;

        long[][] comb = new long[53][53];

        for (int i = 0; i <= 52; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % mod;
            }
        }

        long result = 0;
        int sign = 1;

        for (int i = 1; i <= 13; i++) {
            if (n < 4 * i) {
                break;
            }

            long term = (comb[13][i] * comb[52 - 4 * i][n - 4 * i]) % mod;

            if (sign == 1) {
                result = (result + term) % mod;
            } else {
                result = (result - term + mod) % mod;
            }
            
            sign *= -1;
        }

        System.out.println(result);
    }
}
