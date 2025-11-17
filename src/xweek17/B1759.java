package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1759 {
	static int n, m, moeumCnt, jaeumCnt;
	static int[] vis;
	static char[] arr, result;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[m];
		result = new char[n];
		
		String str = br.readLine();
		String[] s = str.split(" ");
		for(int i=0; i<m; i++) {
			arr[i] = s[i].charAt(0);
			
		}
		Arrays.sort(arr);
		dfs(0,0);
	}
	public static void dfs(int start, int cnt) {
		if(cnt == n) {
			if(func()) {
				for(int i=0; i<n; i++) {
					System.out.print(result[i]);
				}
				System.out.println();
			}
			return;
		}
		for(int i=start; i<m; i++) {
			result[cnt] = arr[i];
			dfs(i+1, cnt+1);
		}
	}
	public static boolean func() {
		int moeum =0;
		int jaeum = 0;
		
		for(char t : result) {
			if(t == 'a'||t == 'e'||t == 'i'||t == 'o'||t == 'u') {
				moeum++;
			}
			else jaeum++;
		}
		if(moeum>0 && jaeum>1) return true;
		else return false;
	}
	
}
