import java.util.*;
import java.io.*;

public class boj_9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) { // 문자가 같을 경우 길이 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 문자가 다를 경우 이전 값 중 큰 값
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[A.length()][B.length()]);
    }
}
