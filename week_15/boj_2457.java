import java.util.*;
import java.io.*;

public class boj_2457 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long min = Long.MAX_VALUE;
        int minL = 0;
        int minR = 0;

        int left = 0;
        int right = N - 1;
        while (left < right) {
            long sum = (long) arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                minL = arr[left];
                minR = arr[right];
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else
                break;
        }

        System.out.println(minL + " " + minR);
    }
}
