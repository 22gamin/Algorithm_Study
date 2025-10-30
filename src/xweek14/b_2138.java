package xweek14;

import java.util.*;
import java.io.*;

public class b_2138 {
	static int N;
	static int[] curr, must, temp;
    static final int INF = 987654321; // 불가능함을 나타내는 큰 값

    // 전구 상태 뒤집기 (1-based index)
	static void flip(int[] arr, int idx) {
		if (idx < 1 || idx > N) return; 
		arr[idx] = 1 - arr[idx]; // 0 -> 1, 1 -> 0
	}

    // i번 스위치를 누름
	static void push(int[] temp, int i) {
		if (i == 1) {
			flip(temp, 1);
			flip(temp, 2);
		} else if (i == N) {
			flip(temp, N - 1);
			flip(temp, N);
		} else {
			flip(temp, i - 1);
			flip(temp, i);
			flip(temp, i + 1);
		}
	}
	// 그리디 시뮬레이션
    // startSwitch: 1번 스위치를 누르고(true) 시작할지, 안 누르고(false) 시작할지
    static int solve(boolean startSwitch) {
        temp = curr.clone(); // ❗️ 1. 깊은 복사
        int cnt = 0;
        
        if (startSwitch) { // 1번 스위치를 누르는 경우
            push(temp, 1);
            cnt = 1;
        }
        
        // 2. 2번 스위치부터 N번 스위치까지 그리디 진행
        for (int i = 2; i <= N; i++) {
            // i-1번 전구가 다르면 i번 스위치를 누른다
            if (temp[i - 1] != must[i - 1]) {
                push(temp, i);
                cnt++;
            }
        }
        
        // 3. ❗️ N번 전구가 목표와 같은지 최종 확인
        if (temp[N] == must[N]) {
            return cnt;
        } else {
            return INF; // 실패
        }
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		curr = new int[N + 1];
		must = new int[N + 1];

		String str = br.readLine();
		String str2 = br.readLine();

		for (int n = 1; n < N + 1; n++) {
			curr[n] = str.charAt(n-1) - '0';
			must[n] = str2.charAt(n-1) - '0';
		} // 입력 끝

		// 시나리오 1: 1번 스위치를 누르지 않음
        int ans1 = solve(false);
        
        // 시나리오 2: 1번 스위치를 누름
        int ans2 = solve(true);

		int answer = Math.min(ans1, ans2);
		
		if (answer == INF) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

}
