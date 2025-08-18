package beakjoon;

import java.io.*;
import java.util.*;

public class b_15686 {

    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 도시 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) houses.add(new int[]{i, j});
                else if (val == 2) chickens.add(new int[]{i, j});
            }
        }

        // 치킨집 조합 고르기
        combination(new ArrayList<>(), 0);

        System.out.println(answer);
    }

    // 조합으로 치킨집 선택
    static void combination(List<int[]> selected, int start) {
        if (selected.size() == M) {
            // 도시 치킨 거리 계산
            int totalDist = 0;
            for (int[] house : houses) {
                int dist = Integer.MAX_VALUE;
                for (int[] chicken : selected) {
                    dist = Math.min(dist, Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]));
                }
                totalDist += dist;
            }
            answer = Math.min(answer, totalDist);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            combination(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

}
