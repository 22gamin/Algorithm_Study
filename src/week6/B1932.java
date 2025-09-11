package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1932 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] map= new int[N][N];
		int[][] result = new int[N][N];
		
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<=i;j++) {
				if(i==N-1) result[i][j]=map[i][j];
				else {
					result[i][j]=Math.max(result[i+1][j] + map[i][j],
							result[i+1][j+1] + map[i][j]);
				}
			}
		}
		
	
		    System.out.println(result[0][0]);
		
	}
}
