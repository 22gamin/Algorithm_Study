package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B3190 {
	// 방향: 0=오른쪽, 1=아래, 2=왼쪽, 3=위
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int dir = 0; // 초기 오른쪽
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 사과 1로 표시
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1]=1;
		}
		
		// 방향 전환 정보 저장
		int L = Integer.parseInt(br.readLine());
		Map<Integer, Character> turn = new HashMap<>();
		for(int i=0;i<L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char ch = st.nextToken().charAt(0);
			turn.put(time,ch);
		}
		
		Deque<int[]> snake = new ArrayDeque<>(); // 머리 : addFirst 꼬리 : removeLast
		boolean[][] occ = new boolean[N][N]; // 뱀 몸이 점유한 칸
		int r=0, c=0;
		snake.addFirst(new int[] {r,c});
		occ[r][c] = true;
		
		int time = 0;
		while(true) {
			time++;
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			
			// 벽 충돌 -> 종료
			if(nr<0 || nr>=N || nc<0 || nc>=N) {
				System.out.println(time);
				return;
			}
			
			// 자기 몸 충돌
			if(occ[nr][nc]) {
				System.out.println(time);
				return;
			}
			
			// 머리 이동
			snake.addFirst(new int[] {nr,nc});
			occ[nr][nc]=true;
			
			if(map[nr][nc]==1) {
				// 사과 먹으면 꼬리 그대로, 사과 제거
				map[nr][nc]=0;
			} else {
				// 사과 없으면 꼬리 줄이기
				int[] tail = snake.removeLast();
				occ[tail[0]][tail[1]]=false;
			}
			
			// 초가 끝난 뒤 회전
			if(turn.containsKey(time)) {
				char t = turn.get(time);
				if(t=='D') {
					dir=(dir+1)%4;
				} else if(t=='L') {
					dir =(dir+3)%4;
				}
			}
			
			r=nr;c=nc;
		}
		
	}

}
