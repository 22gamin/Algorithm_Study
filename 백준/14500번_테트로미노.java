import java.io.*;
import java.util.*;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int n , m;
	static int [][] arr;
	static int [][] visit;
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {1,-1,0,0};
	public static void main(String[] args)throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		n  = Integer.parseInt(st.nextToken());
 		m = Integer.parseInt(st.nextToken());
 		visit = new int[n][m];
 		arr = new int[n][m];
 		
 		for(int i =0; i<n; i++) {
 			StringTokenizer st2 = new StringTokenizer(br.readLine());
 			for(int j = 0 ; j<m; j++) {
 				arr [i][j] = Integer.parseInt(st2.nextToken());
 			}
 		}
 		
 		
 		
 		for(int i =0; i<n; i++) {
 			for(int j =0; j<m; j++) {
 				dfs(i,j,1,0);
 			}
 		}
 		
 		
 		
  		for(int i = 0; i<n; i++) {
  			int sum = arr[i][0] +arr [i][1];
 			for(int j = 2; j<m;j++) {
 				sum += arr[i][j];
 				if(i==0) {
 					max = Math.max(max, sum+arr[i+1][j-1]);
 				}else if(i==n-1) {
 					max = Math.max(max, sum+arr[i-1][j-1]);
 				}else {
 					max = Math.max(max, sum+arr[i-1][j-1]);
 					max = Math.max(max, sum+arr[i+1][j-1]);
 				}
 				sum -= arr[i][j-2];
 			}
 		}
  		
		for(int i = 0; i<m; i++) {
  			int sum = arr[0][i] +arr [1][i];
 			for(int j = 2; j<n;j++) {
 				sum += arr[j][i];
 				if(i==0) {
 					max = Math.max(max, sum+arr[j-1][i+1]);
 				}else if(i==m-1) {
 					max = Math.max(max, sum+arr[j-1][i-1]);
 				}else {
 					max = Math.max(max, sum+arr[j-1][i+1]);

 					max = Math.max(max, sum+arr[j-1][i-1]);
 				}
 				sum -= arr[j-2][i];
 			}
 		}
		
 		System.out.println(max);
 		
 		
 		
 	}
	
	
	
	
	
	
	
	
	
	static void dfs(int x ,int y, int d,int sum) {
		visit[x][y] =1;
        sum += arr[x][y];
		if(d==4) {
			max = Math.max(sum, max);
			visit[x][y] =0;
			return;
		}
		
		for(int i =0; i<4; i++) {
			int nx = x +dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<n && ny >=0 && ny<m) {
				if(visit[nx][ny]==0) {
					dfs(nx,ny,d+1,sum);
				}
			}
			
			
			
			
		}
		
		visit[x][y]=0;
		
		
		
		
	}
}
