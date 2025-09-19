package week7;

import java.util.Arrays;
import java.util.Scanner;

public class B2304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] pillars = new int[N][2];
		for(int i=0;i<N;i++) {
			pillars[i][0]=sc.nextInt();
			pillars[i][1]=sc.nextInt();
		}
		Arrays.sort(pillars,(a,b) ->a[0] - b[0]);
		
		int maxH=0, maxIdx=0;
		for(int i=0;i<N;i++) {
			if(maxH<pillars[i][1]) {
				maxH=pillars[i][1];
				maxIdx=i;
			}
		}
		
		int area=0;
		
		// 왼쪽 스캔
		int curH=pillars[0][1];
		int curL=pillars[0][0];
		for(int i=0;i<=maxIdx;i++) {
			if(pillars[i][1]>curH) {
				area+=(pillars[i][0]-curL)*curH;
				curH=pillars[i][1];
			} else {
				area+=(pillars[i][0]-curL)*curH;
			}
			curL=pillars[i][0];
		}
		
		// 오른쪽 스캔
		curH=pillars[N-1][1];
		curL=pillars[N-1][0];
		for(int i=N-2;i>=maxIdx;i--) {
			if(pillars[i][1] > curH) {
				area+=(curL-pillars[i][0])*curH;
				curH=pillars[i][1];
			} else {
				area+=(curL-pillars[i][0])*curH;
			}
			curL=pillars[i][0];
		}
		
		area+=maxH;
		System.out.println(area);
	}
}




