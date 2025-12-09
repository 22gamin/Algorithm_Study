package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B1038 {
	static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 0 ~ 9 로 시작하는 모든 감소하는 수 생성
        for (int i = 0; i <= 9; i++) {
            dfs(i, i); 
        }

        // 오름차순 정렬
        Collections.sort(list);

        if (N >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }

    // num: 현재까지 만든 수
    // lastDigit: num의 마지막 자릿수
    private static void dfs(long num, int lastDigit) {
        list.add(num);
        for (int next = 0; next < lastDigit; next++) {
            long nextNum = num * 10 + next;
            dfs(nextNum, next);
        }
    }
}

