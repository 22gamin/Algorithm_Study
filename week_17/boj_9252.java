import java.io.*;
import java.util.*;

public class boj_9252 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[A.length()][B.length()]);

        if (dp[A.length()][B.length()] == 0) {
            return;
        }

        int a = A.length();
        int b = B.length();
        while (a > 0 && b > 0) {
            if (dp[a][b] != dp[a - 1][b - 1]) {
                if (dp[a][b] == dp[a - 1][b]) {
                    a--;
                } else if (dp[a][b] == dp[a][b - 1]) {
                    b--;
                } else {
                    sb.append(A.charAt(a - 1));
                    a--;
                    b--;
                }
            } else {
                a--;
                b--;
            }
        }

        System.out.println(sb.reverse());
    }
}
