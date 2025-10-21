import java.io.*;
import java.util.*;

public class Main {
	static int[] visit1;
	static int[][] visit2;
	static int[][] visit3;
	static int[][] map;
	static int n;
	static boolean isFind;
	static int[] result;
	static int already;
	static int Max = 0;
	public static void main(String[] args)throws IOException {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		isFind =false; 
		n = Integer.parseInt(br.readLine());
		visit1 = new int[n+1];  //열
		visit2 = new int[n+1][n+1]; // \방향
		visit3 = new int[n+1][n+1]; // /방향
		result  = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int x =1; x<=n; x++) {
			int y = Integer.parseInt(st.nextToken());
			
		
			
			if(y!=0) {
				visit1[y] =1;
				result[x] =y;
				
				if(x>y) {
					int nx = x-y;
					int ny=0;
					visit2[nx][ny] = 1;			
				}else if(x<y){
					int ny = y-x;
					int nx = 0;
					visit2[nx][ny] = 1;
				}else if(y==x){
					visit2[0][0] = 1;
				}
				
				
				int gap  =  n-x;
				
				if(gap > y) {
					int ny = 0;
					int nx = x+y;
					visit3[nx][ny] =1 ;
				}else {
					int ny = y-gap;
					int nx = n;
					visit3[nx][ny] =1;
				}
				
			}
		}
		
		
	
		back(1);
		
		
		if(isFind) {
			for(int i = 1; i<=n; i++) {
				System.out.print(result[i]+" ");
			}
		
		}else {
			System.out.print(-1);
		}
		
	}
	
	
	public static void back(int x) {
		if(isFind) return;
		if(x==n+1) {
			isFind=true;
			return;
		}
		
		if(result[x]!=0) {
			back(x+1);
			return;
		}

		
		
		int nx1=0;
		int nx2=0;
		
		int ny1=0;
		int ny2=0;
		
	
			
		for(int j = 1; j<=n; j++) {
				if(visit1[j]==1) continue;
				
				if(x>j) {
					nx1 = x-j;
					ny1 =0;			
				}else if(x<j){
					ny1 = j-x;
					nx1 = 0;				
				}else if(x==j){
					nx1 = 0;
					ny1 = 0;
				}
				if (visit2[nx1][ny1]==1) continue;
				
				
				int gap  =  n-x;		
				if(gap > j) {
					ny2 = 0;
					nx2 = x+j;					
				}else {
					ny2 = j-gap;
					nx2 = n;
				}
				if(visit3[nx2][ny2]==1) continue;
				
				
				
				
				visit1[j]=1;
				visit2[nx1][ny1]=1;
				visit3[nx2][ny2]=1;
				result[x] = j;
				back(x+1);
				
				if (isFind) return;
				visit1[j]=0;
				visit2[nx1][ny1]=0;
				visit3[nx2][ny2]=0;
				result[x] = 0;
				
			}
		
		
		
		
	}

	
}
