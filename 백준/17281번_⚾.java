package test;
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int [][] arr; //이닝당 기록.
	static int [] order;
	static int [] bMap; //야구 주자 관리 배열
	static int [] visit;
	static int max;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n  = Integer.parseInt(br.readLine());
		order = new int[10];
		order[4] = 1; // 1번은 4순으로 고정
		arr = new int[n][10];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;
		visit = new int [10];
		back(1);
		System.out.println(max);
	}
	
	static void back(int d) {
		if (d==4) {
			back(d+1);
			return;
		}
		if (d==10) {
			baseball();//타순 정해졌으니 야구 게임시작
			return;
		}
		
		
		
		for(int i =2; i<10; i++) {
			
			if(visit[i]==0) {
				order[d] = i;
				visit[i] =1;
				back(d+1);
				visit[i] = 0;
			}
		}
	}
    
	static void baseball() {
	    int score = 0; // 총 점수
	    int idx = 1;   // 타순 인덱스 (1~9)
	    
	    for (int inning = 0; inning < n; inning++) {
	        int out = 0;
	        boolean[] base = new boolean[4]; // 1루, 2루, 3루

	        while (out < 3) {
	            if (idx == 10) idx = 1; // 타순이 9번까지 끝나면 다시 1번 타자로

	            int result = arr[inning][order[idx]];

	            if (result == 0) {
	                out++;
	            } else if (result == 1) {
	                // 3루 주자 득점, 2루 → 3루, 1루 → 2루
	                if (base[3]) score++;
	                base[3] = base[2];
	                base[2] = base[1];
	                base[1] = true;
	            } else if (result == 2) {
	                if (base[3]) score++;
	                if (base[2]) score++;
	                base[3] = base[1];
	                base[2] = true;
	                base[1] = false;
	            } else if (result == 3) {
	                if (base[3]) score++;
	                if (base[2]) score++;
	                if (base[1]) score++;
	                base[3] = true;
	                base[2] = false;
	                base[1] = false;
	            } else if (result == 4) {
	                // 홈런: 모든 주자 + 타자 득점
	                if (base[3]) score++;
	                if (base[2]) score++;
	                if (base[1]) score++;
	                score++;
	                base[3] = base[2] = base[1] = false;
	            }

	            idx++;
	        }
	    }

	    max = Math.max(max, score);
	}

    
}
