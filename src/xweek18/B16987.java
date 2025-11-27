package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16987 {
	static int[] s, w;
	static int n, maxnum = 0, total = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());		
		s = new int[n];
		w = new int[n];
		for(int i=0; i<n; i++) {
			// 내구도, 무게
			// 계란 쳤을때 내 내구도 - 상대 무게
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());			
			
		}		
		dfs(0);
		System.out.print(maxnum);
		
	}
	public static void dfs(int cnt) {
		if(cnt == n) {
			for(int i=0; i<n; i++) {
				if(s[i] <=0) total++;
			}
			maxnum = Math.max(total, maxnum);
			total = 0;
			return;
		}
		// 칠 계란 깨져 있으면
		if(s[cnt] <=0) {
			dfs(cnt+1);
			return;
		}
		boolean isHit = false;
		for(int i=0; i<n; i++) {
			// 자기 계란이거나 이번 계란이 깨져있는 경우
			if(i == cnt || s[i]<=0) continue;
			
			isHit = true;
			
			// 계란 치기			
			s[cnt] -= w[i];
			s[i] -= w[cnt];
			dfs(cnt+1);
			// 계란 복구
			s[cnt] += w[i];
			s[i] += w[cnt];
		}
		if(!isHit) dfs(cnt+1);
	}
}
