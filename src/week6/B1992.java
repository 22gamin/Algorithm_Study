package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1992 {
	
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
		map=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine().trim();
			for(int j=0;j<N;j++) {
				 map[i][j] = line.charAt(j) - '0';
			}
		}
		
		quad(0,0,N);
		System.out.println(sb.toString());
	}

	static void quad(int r, int c, int size) {
		if(isUniform(r,c,size)) {
			sb.append(map[r][c]);  // 모두 같다면 그 값(0/1)만 출력
			return;
		}
		int h=size/2;
		sb.append('(');
        quad(r, c, h);           // 좌상
        quad(r, c + h, h);       // 우상
        quad(r + h, c, h);       // 좌하
        quad(r + h, c + h, h);   // 우하
        sb.append(')');
	}
	
	// 영역이 모두 같은 값인지 검사
	static boolean isUniform(int r, int c, int size) {
		int first=map[r][c];
		for(int i=r; i<r+size;i++) {
			for(int j=c; j<c+size;j++) {
				if(map[i][j]!=first) return false;
			}
		}
		return true;
	}
}
