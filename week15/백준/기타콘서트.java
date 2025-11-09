import java.io.*;
import java.util.*;

public class Main {
	static int [][] guitar;
	static int n;
	static int m;
	static int []visit;
	static int [] result;
	static int min;
	static int canPlay;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n  = Integer.parseInt(st.nextToken());
		m =  Integer.parseInt(st.nextToken());
		canPlay= 0;
		guitar = new int[n][m];
		visit = new int[n];
		result = new int[m];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			st2.nextToken();
			String a = st2.nextToken();
			
			for(int j=0; j<m; j++) {
				 if(a.charAt(j)=='Y') {
					guitar[i][j] = 1; 
				 }else {
					 guitar[i][j] = 0;
				 }
			}
		}
		
		for(int i = 0; i<n; i++) {
			comb(i,1);
		}
		
		
		if(canPlay==0) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
		
		
		
	}
	
	
	static void comb(int start, int count) {
		visit[start]=1;
		

		
		result = new int[m];
		
		for(int i =0; i<n; i++) {
			if(visit[i]==1) {
				for(int j=0;j<m;j++) {
					if(guitar[i][j] == 1) {
						result[j] = 1;
					}
				}
			}
		}
	
		int play = 0;
		for(int i =0; i<m; i++) {
			if(result[i]!=0) {
				play++;
			}
		}
		if(canPlay<play) {
			canPlay=play;
			min = count;
		}else if(canPlay == play) {
			min = Math.min(min, count);
		}
		
		
		
		
		
		for(int i = start+1; i<n; i++) {
			comb(i,count+1);
			visit[i]= 0;
		}
		
		
		
		
		
			
			
			
		
		
		
		
		
		
		
		visit[start]=0;
		
		
	}
}
