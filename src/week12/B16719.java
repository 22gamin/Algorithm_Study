package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16719 {

	static char[] s;
	static boolean[] shown; // 표시된 자리
	static StringBuilder out = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine().toCharArray();
		shown = new boolean[s.length];
		
		solve(0, s.length -1);
		System.out.println(out.toString());
	}
	
	static void solve(int l, int r) {
		if(l>r) return;
		
		// l...r 에서 가잦ㅇ 작은 문자 위치 k
		int k=l;
		for(int i=l+1;i<=r;i++) {
			if(s[i]<s[k]) {
				k=i;
			}
		}
		
		// k를 표시하고 현재 문자열 출력
		shown[k]=true;
		printCurrent();
		
		// 오른쪽 -> 왼쪽 순서로 재귀
		solve(k+1,r);
		solve(l,k-1);
	}

	static void printCurrent() {
		for(int i=0;i<s.length;i++) {
			if(shown[i]) {
				out.append(s[i]);
			}
		}
		out.append("\n");
	}
}
