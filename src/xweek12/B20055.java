package xweek12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B20055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] hasrobot = new int[n+1];
		int[] belt = new int[2*n + 1];
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2*n; i++) {
			
			belt[i] = Integer.parseInt(st.nextToken());			
		}
		int total = 0;
		while(true) {
			total++;
			// 벨트 회전
			int lastval = belt[2*n-1];
			for(int i=2*n-1; i>0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = lastval;
			// 로봇 회전
			for(int i=n-1; i>0; i--) {
				hasrobot[i] = hasrobot[i-1];
			}
			hasrobot[0] = 0;
			if(hasrobot[n-1] == 1) hasrobot[n-1] = 0;
			
			for(int i=n-2; i>=0; i--) {
				if(hasrobot[i] == 1 && belt[i+1]>0 && hasrobot[i+1]==0) {
					hasrobot[i+1] = 1;
					hasrobot[i] = 0;
					belt[i+1]--;
				}
			}
			// 로봇 내리기
			if(hasrobot[n-1] == 1) hasrobot[n-1] = 0;
			// 로봇 올리기
			if(belt[0]>0) {
				hasrobot[0] = 1;
				belt[0]--;				
			}
			int cnt = 0;
			for(int i=0; i<2*n; i++) {
				if(belt[i] == 0)cnt++;
			}
			if(cnt >= k) {
				System.out.println(total);
				break;
			}			
		}
	}
}
