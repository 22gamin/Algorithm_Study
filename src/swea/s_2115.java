package swea;

import java.util.*;
import java.io.*;

public class s_2115 {
    static int N, M, C;
    static int[][] honeyMap;
    static int[][] maxProfitMap; // 1단계: 각 M칸 구역에서 얻을 수 있는 최대 이익을 저장할 배열
    static int maxHoneyProfit; // 재귀 함수에서 사용할 임시 최대 이익 변수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            honeyMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    honeyMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // --- 1단계: 각 구역의 최대 이익 계산 ---
            maxProfitMap = new int[N][N - M + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    // (i, j)에서 시작하는 M개의 벌통에서 최대 이익을 계산
                    calculateMaxProfitForBlock(i, j);
                }
            }

            // --- 2단계: 두 일꾼의 최적 조합 찾기 ---
            int totalMaxProfit = 0;
            // 일꾼 1 선택
            for (int r1 = 0; r1 < N; r1++) {
                for (int c1 = 0; c1 <= N - M; c1++) {
                    int profit1 = maxProfitMap[r1][c1];

                    // 일꾼 2 선택
                    // case 1: 일꾼 1과 같은 행에서 선택
                    for (int c2 = c1 + M; c2 <= N - M; c2++) {
                        int profit2 = maxProfitMap[r1][c2];
                        totalMaxProfit = Math.max(totalMaxProfit, profit1 + profit2);
                    }

                    // case 2: 일꾼 1보다 아래 행에서 선택
                    for (int r2 = r1 + 1; r2 < N; r2++) {
                        for (int c2 = 0; c2 <= N - M; c2++) {
                            int profit2 = maxProfitMap[r2][c2];
                            totalMaxProfit = Math.max(totalMaxProfit, profit1 + profit2);
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(totalMaxProfit).append("\n");
        }
        System.out.println(sb);
    }

    // (r, c)에서 시작하는 M개의 벌통에 대한 최대 수익을 계산하여 maxProfitMap에 저장
    private static void calculateMaxProfitForBlock(int r, int c) {
        int[] block = new int[M];
        for (int i = 0; i < M; i++) {
            block[i] = honeyMap[r][c + i];
        }
        maxHoneyProfit = 0;
        findMaxSubsetProfit(0, 0, 0, block);
        maxProfitMap[r][c] = maxHoneyProfit;
    }

    // 재귀를 통해 M개 벌통의 모든 부분집합을 탐색하여 최대 이익을 찾는 함수
    private static void findMaxSubsetProfit(int index, int currentHoneySum, int currentProfit, int[] block) {
        // C를 초과하면 더 이상 진행하지 않음
        if (currentHoneySum > C) {
            return;
        }

        // M개의 벌통을 모두 확인한 경우
        if (index == M) {
            maxHoneyProfit = Math.max(maxHoneyProfit, currentProfit);
            return;
        }

        // 현재 index의 벌통을 선택하는 경우
        int honey = block[index];
        findMaxSubsetProfit(index + 1, currentHoneySum + honey, currentProfit + (honey * honey), block);

        // 현재 index의 벌통을 선택하지 않는 경우
        findMaxSubsetProfit(index + 1, currentHoneySum, currentProfit, block);
    }
}
