import java.io.*;
import java.util.*;

public class Main {
	static int n,l;
	static int [][] arr;
	static int result = 0;
	static boolean isFind;
	public static void main(String[] args)throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		n = Integer.parseInt(st.nextToken());
 		l = Integer.parseInt(st.nextToken());
 		arr = new int [n][n];
 		for(int i = 0; i < n; i ++) {
 			StringTokenizer st2 = new StringTokenizer(br.readLine());
 			for(int j = 0 ; j < n ; j++) {
 				arr[i][j] = Integer.parseInt(st2.nextToken());
 			}
 		}
 		for(int i =  0 ; i < n ; i ++) {
 			
 			find1(i,1,0,new int[n]);
 			
 			find2(1,i,0,new int[n]);
 			
 			
 		}
 		
 		System.out.println(result);
 	
 	}
	
	
	public static void find1(int x, int y, int py, int[] stair) {
		
		if(y>=n) {
			result ++;
			return;
		}
		
		
		
		
		if(arr[x][py] == arr[x][y]) {
			find1(x,y+1,y,stair);
		}else if(arr[x][py]-arr[x][y]==1) {
			
			if(y+l-1 <n) {
				stair[y]=1;
				for(int i =y+1; i<y+l; i++) {
					if(arr[x][y]!=arr[x][i]) {
						return;
					}
					stair[i]=1;
				}
				find1(x,y+l,y+l-1,stair);
			}else {
				return;
			}
			
			
		}else if(arr[x][py]-arr[x][y]==-1) {
			if(y-l>=0) {
				for(int i = py; i>=y-l; i--) {
					if(stair[i]==1) {
						return;
					}else {
						stair[i]=1;
					}
				}
				find1(x,y+1,y,stair);
			}else {
				return;
			}
		}else {
			return;
		}
	}
	
	public static void find2(int x, int y, int px, int[] stair) {
		
		if(x>=n) {
			result ++;
			return;
		}
		
		
		
		
		if(arr[px][y] == arr[x][y]) {
			find2(x+1,y,x,stair);
		}else if(arr[px][y]-arr[x][y]==1) {
			
			if(x+l-1 <n) {
				stair[x]=1;
				for(int i =x+1; i<x+l; i++) {
					if(arr[x][y]!=arr[i][y]) {
						return;
					}
					stair[i]=1;
				}
				find2(x+l,y,x+l-1,stair);
			}else {
				return;
			}
			
			
		}else if(arr[px][y]-arr[x][y]==-1) {
			if(x-l>=0) {
				for(int i = px; i>=x-l; i--) {
					if(stair[i]==1) {
						return;
					}else {
						stair[i]=1;
					}
				}
				find2(x+1,y,x,stair);
			}else {
				return;
			}
		}else {
			return;
		}
	}
	
}
