package xweek14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1043 {
	static List<Integer> knownlist;
	static int[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		knownlist = new ArrayList<>();
		list = new int[n+1];
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		if(num == 0) {
			System.out.println(m);
			return;
		}
		// 알고있는 사람들의 list
		for(int i=0; i<num; i++) {
			int a = Integer.parseInt(st.nextToken());
			knownlist.add(a);
		}
		
		// 파티 정보
		List<Integer>[] partylist = new ArrayList[m+1];
		for(int i=0; i<m; i++) partylist[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int bef = 0;
			for(int j=0; j<t; j++) {
				int cur = Integer.parseInt(st.nextToken());
				partylist[i].add(cur);
				if(j == 0) {
					bef = cur;
					continue;					
				}
				uni(bef, cur);
				bef = cur;
				
			}
		}
		
		// 확인
		int[] chk = new int[n+1];
		for(int c : knownlist) {
			int target = fin(c);
			chk[target] = 1;
		}
		
		int count = 0;
		for(int i = 0; i<m; i++) {
			int check = 0;
			for(int c : partylist[i]) {
				int tmp = fin(c);
				if(chk[tmp] == 1) {
					check = 1;
					break;
				}
			}
			
			if(check == 0) count++;
		}
//		for(int i=1; i<=n; i++) {
//			int tmp = fin(i);
//			if(chk[tmp] == 0)count++;
//		}
		System.out.println(count);
	}
	
	public static void uni(int a, int b) {
		int fir = fin(a);
		int sec = fin(b);
		if(fir == sec) return;
		list[fir] = sec;
		return;
	}
	
	public static int fin(int c) {
		if(list[c] == 0) return c;
		return list[c] = fin(list[c]);
	}
}
