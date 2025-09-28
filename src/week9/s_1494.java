package week9;

import java.util.*;
import java.io.*;

public class s_1494 {
    static int N;
    static int[][] points;
    static boolean[] selected;
    static long minVectorMagnitudeSq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            points = new int[N][2];
            selected = new boolean[N];
            minVectorMagnitudeSq = Long.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            // N마리 중 출발지 역할을 할 N/2마리를 고르는 조합 탐색 시작
            findCombinations(0, 0);

            sb.append("#").append(tc).append(" ").append(minVectorMagnitudeSq).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void findCombinations(int index, int count) {
        if (count == N / 2) {
            long totalX = 0;
            long totalY = 0;


            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    totalX -= points[i][0];
                    totalY -= points[i][1];
                } else {
                    totalX += points[i][0];
                    totalY += points[i][1];
                }
            }

            long magnitudeSq = totalX * totalX + totalY * totalY;
            minVectorMagnitudeSq = Math.min(minVectorMagnitudeSq, magnitudeSq);
            return;
        }

        if (index == N) {
            return;
        }
        selected[index] = true;
        findCombinations(index + 1, count + 1);

        selected[index] = false;
        findCombinations(index + 1, count);
    }
}

