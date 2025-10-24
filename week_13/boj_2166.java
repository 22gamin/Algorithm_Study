import java.util.*;
import java.io.*;

public class boj_2166 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[N + 1][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }
        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < N; i++) {
            sum1 += arr[i][0] * arr[i + 1][1];
            sum2 += arr[i][1] * arr[i + 1][0];
        }

        double ans = Math.abs(sum1 - sum2) / 2.0;

        System.out.println(String.format("%.1f", ans));

    }
}
