package xweek12;

import java.util.*;
import java.io.*;

public class b_11660 {
	static int N, M,graph[][],s[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		s = new int[N+1][N+1];
		int sum = 0;
		
		for(int n = 1; n<N+1; n++) {
			st = new StringTokenizer(br.readLine());
			for(int nn= 1; nn<N+1; nn++) {
				graph[n][nn] = Integer.parseInt(st.nextToken());
			}
		}
		
		//누적합 만들어놓기
		for(int i = 1; i <N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				s[i][j] = s[i][j-1] + s[i-1][j] - s[i-1][j-1] + graph[i][j]; 
			}
		}

		
		for(int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			if(x1==x2 && y1==y2) System.out.println(graph[x1][y1]);
			else {
				int answer = s[x2][y2] - s[x2][y1-1] - s[x1-1][y2] + s[x1-1][y1-1];
				System.out.println(answer);
			}
			
		}
		
		//입력 끝

	}

}
