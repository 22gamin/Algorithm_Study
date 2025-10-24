package xweek13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2096 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] scoremMin = new int[n][3];
		int[][] scoremMax = new int[n][3];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				scoremMin[i][j] = Integer.parseInt(st.nextToken());
				scoremMax[i][j] = scoremMin[i][j];
				if(i == 0) continue;
				
				if(j == 1) {
					int t1 = scoremMin[i-1][j-1];
					int t2 = scoremMin[i-1][j];
					int t3 = scoremMin[i-1][j+1];
					int minnum = Math.min(t1, t2);
					minnum = Math.min(t3, minnum);
					scoremMin[i][j] = scoremMin[i][j] + minnum;
					
					t1 = scoremMax[i-1][j-1];
					t2 = scoremMax[i-1][j];
					t3 = scoremMax[i-1][j+1];
					int maxnum = Math.max(t1, t2);
					maxnum = Math.max(t3, maxnum);
					scoremMax[i][j] = scoremMax[i][j] + maxnum;
					
				}else if(j == 2){
					
					int t1 = scoremMin[i-1][j-1];
					int t2 = scoremMin[i-1][j];
					int minnum = Math.min(t1, t2);
					scoremMin[i][j] = scoremMin[i][j] + minnum;
					
					t1 = scoremMax[i-1][j-1];
					t2 = scoremMax[i-1][j];
					int maxnum = Math.max(t1, t2);
					scoremMax[i][j] = scoremMax[i][j] + maxnum;
					
				}else if(j == 0){
					int t1 = scoremMin[i-1][j+1];
					int t2 = scoremMin[i-1][j];
					int minnum = Math.min(t1, t2);
					scoremMin[i][j] = scoremMin[i][j] + minnum;
					
					t1 = scoremMax[i-1][j+1];
					t2 = scoremMax[i-1][j];
					int maxnum = Math.max(t1, t2);
					scoremMax[i][j] = scoremMax[i][j] + maxnum;
				}
			}
		}
		// max
		int scoremax = Math.max(scoremMax[n-1][0], scoremMax[n-1][1]);
		scoremax = Math.max(scoremax, scoremMax[n-1][2]);
		System.out.print(scoremax+" ");
		
		// min
		if(scoremMin[n-1][0]<scoremMin[n-1][1]) {
			if(scoremMin[n-1][2]>scoremMin[n-1][0]) {
				System.out.println(scoremMin[n-1][0]);
			}else {
				System.out.println(scoremMin[n-1][2]);
			}
		}else {
			if(scoremMin[n-1][2]>scoremMin[n-1][1]) {
				System.out.println(scoremMin[n-1][1]);
			}else {
				System.out.println(scoremMin[n-1][2]);
			}
		}
	}
}
