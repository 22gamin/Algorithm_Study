import java.util.*;
import java.io.*;

public class boj_2473 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long[] minarr = new long[3];

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                if (Math.abs(min) > Math.abs(sum)) {
                    min = sum;
                    minarr[0] = arr[i];
                    minarr[1] = arr[left];
                    minarr[2] = arr[right];
                }

                if (sum == 0) {
                    break;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            sb.append(minarr[i]).append(' ');
        }

        System.out.println(sb);
    }
}
