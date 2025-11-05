package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1439 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();

        // 연속된 구간을 구하기 위한 변수
        int cnt0 = 0, cnt1 = 0;

        // 첫 번째 문자에 따라 초기값 설정
        if (S.charAt(0) == '0') {
            cnt0++;
        } else {
            cnt1++;
        }

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                if (S.charAt(i) == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
        }

        // 최소 횟수는 두 구간 중 작은 값
        System.out.println(Math.min(cnt0, cnt1));
    }
}
