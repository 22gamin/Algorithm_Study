package week3;

import java.io.*;
import java.util.*;

public class S2112 {
	
	static int D,W,K; // 두께, 가로크기, 합격기준
	static int[][] film;
	static int answer;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            film=new int[D][W];
            for(int i=0;i<D;i++) {
            	st=new StringTokenizer(br.readLine());
            	for(int j=0;j<W;j++) {
            		film[i][j]=Integer.parseInt(st.nextToken());
            	}
            }
            
            answer = Integer.MAX_VALUE;
            
            // 초기 상태 검사
            if(check()) {
            	answer = 0;
            }
            else {
            	dfs(0,0);
            }
            
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
	}
	
	// row : 현재 약품 처리 여부를 결정할 행(막) 인덱스
	// cnt : 지금까지 약품을 투입한 횟수
	static void dfs(int row, int cnt) {
		// 이미 최소값(answer) 이상 약품을 사용했다면 더 볼 필요 없음 (가지치기)
		if(cnt>=answer) 
			return;
		
		// 모든 행에 대해 처리 여부를 결정한 경우
		if(row==D) {
			// 현재 필름 상태가 성능검사를 통과하면 최소값 갱신
			if(check()) answer = Math.min(answer,cnt);
			return;
		}
		
		// 현재 행의 원본 상태를 저장 (복원용)
		int[] original = film[row].clone();
		
		// 1. 현재 행에 약품 투입 안 함
		dfs(row+1,cnt);
		
		// 2. 현재 행 전체를 A로 변경
		Arrays.fill(film[row], 0);
		dfs(row+1,cnt+1);
		
		// 3. 현재 행 전체를 B로 변경
		Arrays.fill(film[row], 1);
		dfs(row+1,cnt+1);
		
		// 변경했던 현재 행을 원래 상태로 복원
		film[row]=original;
	} 
	
	// 현재 성능검사 기준(k)을 만족하는지 여부 반환
	static boolean check() {
		// 각 열(col)별로 검사
		for(int col=0;col<W;col++) {
			int maxStreak = 1; // 해당 열에서 발견한 최대 연속 동일 특성 개수
			int streak = 1; // 현재 연속 동일 특성 개수
			
			// 2번째 행(row=1)부터 마지막 행까지 검사
			for(int row=1;row<D;row++) {
				if(film[row][col]==film[row-1][col]) {
					streak++;
				} else {
					streak=1; // 다르면 1로 초기화
				}
				
				maxStreak=Math.max(maxStreak, streak);
				
				// 이미 k이상이면 이 열은 합격 -> 더 볼 필요 없이 탈출
				if(maxStreak>=K) break;
			}
			
			// K 미만이면 불합격
			if(maxStreak < K) return false;
		}
		
		// 모든 열이 K 이상이면 합격
		return true;
	}
}
