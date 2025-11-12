package xweek16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3109 {
	static char[][] map;
	static int r, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int cnt = 0;
		for(int i=0; i<r; i++) {
			if(func(i, 0) == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	public static int func(int nowx, int nowy) {
		// 파이프 설치 
		map[nowx][nowy] = 'O';
		// 끝에 도달
		if(nowy == c-1) {			
			return 1;
		}
		
		// 대각선 위
		if(nowx-1>=0 && map[nowx-1][nowy + 1] == '.') {
			
			if(func(nowx-1, nowy+1)==1) {
				return 1;
			}
		}
		
		// 오른쪽
		if(map[nowx][nowy + 1] == '.') {
			if(func(nowx, nowy+1)==1) {				
				return 1;
			}
		}
		
		// 대각선 밑
		if(nowx+1 <r && map[nowx+1][nowy + 1] == '.' ) {
			
			if(func(nowx+1, nowy+1)==1) {
				return 1;
			}
		}
		return 0;
		
	}
}
