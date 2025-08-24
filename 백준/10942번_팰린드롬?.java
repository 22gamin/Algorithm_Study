import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] dp;
    static int[] arr;
    static int m;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];
        arr = new int[n+1];
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 1; j <= n; j++) {
                int r = j + i;
                if (r > n) {
                    break;
                }
                if (j == r) {
                    dp[j][r] = 1;
                } else {
                    if (arr[j] != arr[r]) {
                        dp[j][r] = 0;
                    } else {
                        if (i == 1) {
                            dp[j][r] = 1;
                        } else {
                            if (dp[j + 1][r - 1] == 1) {
                                dp[j][r] = 1;
                            } else {
                                dp[j][r] = 0;
                            }
                        }
                    }
                }

            }

        }
        


        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st2.nextToken());
            int e = Integer.parseInt(st2.nextToken());
            sb.append(dp[s][e]).append("\n");
        }



        System.out.print(sb.toString());

    }

}
