import java.io.*;
import java.util.*;

public class boj_2108_김민종 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        int[] freq = new int[8001]; // -4000 ~ 4000 (입력되는 정수의 절댓값 < 4000)

        long sum = 0;
        int mn = 4001, mx = -4001;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            a[i] = x;
            sum += x;
            freq[x + 4000]++;
            if (x < mn) mn = x;
            if (x > mx) mx = x;
        }

        Arrays.sort(a);

        // 1) 평균 (반올림)
        int mean = (int) Math.round(sum / (double) N);

        // 2) 중앙값
        int median = a[N / 2];

        // 3) 최빈값 (여러 개면 두 번째로 작은 값)
        int maxFreq = 0;
        for (int f : freq) if (f > maxFreq) maxFreq = f;

        int mode = 0;
        boolean firstFound = false;
        for (int v = -4000; v <= 4000; v++) {
            if (freq[v + 4000] == maxFreq) {
                if (!firstFound) {
                    mode = v;
                    firstFound = true;      // 첫 번째 최빈값
                } else {
                    mode = v;               // 두 번째로 작은 최빈값
                    break;
                }
            }
        }

        // 4) 범위
        int range = mx - mn;

        StringBuilder sb = new StringBuilder();
        sb.append(mean).append('\n')
          .append(median).append('\n')
          .append(mode).append('\n')
          .append(range).append('\n');

        System.out.print(sb.toString());
    }
}
