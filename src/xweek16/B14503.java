package xweek16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503 {
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		st = new StringTokenizer(br.readLine());
		int nowx = Integer.parseInt(st.nextToken());
		int nowy = Integer.parseInt(st.nextToken());
		int seedir = Integer.parseInt(st.nextToken());		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] isclean = new int[n][m];
		// 0 : 북쪽, 1 : 동쪽, 2 : 남쪽, 3 : 서쪽		
		
		int cleanCnt = 0;
		while(true) {
			// 1. 현재 칸 청소
			if(isclean[nowx][nowy] == 0) {
				isclean[nowx][nowy] = 1;
				cleanCnt++;
			}
			boolean chk = true;
			// 2. 주변 4칸 확인
			for(int d = 0; d<4; d++) {
				int nx = dx[d]+nowx;
				int ny = dy[d]+nowy;
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				
				// 벽이 아니고, 청소가 안되어있다면 
				if(isclean[nx][ny] == 0 && map[nx][ny] == 0) {					
					// 반시계 방향 회전
					if(seedir == 0) seedir = 3;
					else seedir--;
					// 바라보는 방향 앞칸이 청소되지않은 빈 칸인 경우 전진
					if(dx[seedir]+nowx<0 || dx[seedir]+nowx>=n || dy[seedir]+nowy<0 || dy[seedir]+nowy>=m) break;
					if(isclean[dx[seedir]+nowx][dy[seedir]+nowy] == 0 && map[dx[seedir]+nowx][dy[seedir]+nowy] == 0) {
						// 한 칸 전진 
						nowx = dx[seedir]+nowx;
						nowy = dy[seedir]+nowy;
					}
					// 청소되지 않은 부분 존재한다고 체크
					chk = false;
					break;
				}
			}
			// 청소 다 되어 있거나 벽일때 
			if(chk == true) {
				// 3. 다 청소되어있음 -> 후진 or 작동멈춤
				// 후진 방향 설정
				int backdir = (seedir+2)%4;				
				
				int backx = dx[backdir] + nowx;
				int backy = dy[backdir] + nowy;
				// 뒤가 끝 
				if(backx<0 || backx>=n || backy<0 || backy>=m) break;
				// 뒤가 벽이면 끝
				if(map[backx][backy] == 1) break;
				else {
					nowx = dx[backdir] + nowx;
					nowy = dy[backdir] + nowy;
				}				
			}
		}		
		System.out.println(cleanCnt);
	}
}
