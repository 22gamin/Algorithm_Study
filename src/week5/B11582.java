package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11582 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine().trim());

        int groupSize = N / k; // 현재 단계에서 각 회원이 맡는 구간 길이

        // 각 구간 내부만 정렬
        for (int start = 0; start < N; start += groupSize) {
            Arrays.sort(a, start, start + groupSize);
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(a[i]);
        }
        System.out.println(sb.toString());
    }

}
