package week_8;

import java.util.*;
import java.io.*;

public class boj_10026 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // {시작 시간, 끝나는 시간}을 저장할 2차원 배열
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간 기준으로 오름차순 정렬
        // 끝나는 시간이 같다면, 시작 시간 기준으로 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int lastEndTime = 0;

        for (int i = 0; i < N; i++) {
            // 현재 회의의 시작 시간이, 이전에 끝난 회의 시간보다 크거나 같으면
            if (arr[i][0] >= lastEndTime) {
                // 회의를 배정하고, 끝나는 시간을 갱신
                lastEndTime = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
