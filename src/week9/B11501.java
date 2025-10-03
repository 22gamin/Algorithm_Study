package week9; // 백준 제출 시 이 줄은 삭제하거나 주석 처리해야 합니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        for (int test = 0; test < t; test++) {
            int n= Integer.parseInt(br.readLine().trim());
            int[] prices = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }
            // long 필요
            long totalProfit = 0;
            int maxnum = prices[n - 1];

            // 마지막 전부어 거꾸로 탐색
            for (int i = n-2; i >=0; i--) {
                if (prices[i] > maxnum) {
                    maxnum = prices[i];
                }
                else {
                    totalProfit += (maxnum-prices[i]);
                }
            }
            System.out.println(totalProfit);
        }

    }
}
