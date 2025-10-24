import java.util.*;
import java.io.*;

public class boj_1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        long curSum = 0;
        int min = Integer.MAX_VALUE;

        // 슬라이딩 윈도우 시작
        for (int right = 0; right < N; right++) {
            curSum += arr[right];

            // 현재 합이 최소 합 조건인 S보다 클 경우 왼쪽 포인터를 한 칸씩 줄여가며 현재 합을 감소
            while (curSum >= S) {
                int len = right - left + 1;
                // 부분합의 길이가 이전 최소 길이보다 작을 경우 값 갱신
                if (len < min) {
                    min = len;
                }

                curSum -= arr[left];
                left++;
            }
        }

        if (min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }
}
