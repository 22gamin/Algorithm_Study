package trash;

import java.util.*;
import java.io.*;

public class boj_11054 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // i에서 끝나는 LIS의 길이
        int[] lis = new int[N];
        // i에서 시작하는 LDS의 길이
        int[] lds = new int[N];

        // 1. LIS 구하기 (왼쪽 -> 오른쪽)
        for (int i = 0; i < N; i++) {
            lis[i] = 1; // 자기 자신 길이 1
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // LDS 구하기 (오른쪽 -> 왼쪽)
        for (int i = N - 1; i >= 0; i--) {
            lds[i] = 1; // 자기 자신 길이 1
            for (int j = N - 1; j > i; j--) {
                if (A[i] > A[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // 3. 두 DP 배열을 합쳐 최댓값 찾기
        int max = 0;
        for (int i = 0; i < N; i++) {
            // LIS 길이 + LDS 길이 - 1 (i가 중복 -> 1 빼기)
            int sum = lis[i] + lds[i] - 1;
            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}
