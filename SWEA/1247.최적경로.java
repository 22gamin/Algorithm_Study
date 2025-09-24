import java.util.*;
import java.io.*;
public class Solution {
	
	static int n;
	static int[][] pos;
	static int min;
	static int[] visited;
	static ArrayList<ArrayList<Integer>> al;
	
	public static void main(String[] args)throws IOException {
		//System.setIn(new FileInputStream("test.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=t; tc++) {	
			
			  min = Integer.MAX_VALUE;
			  n = Integer.parseInt(br.readLine());
			  pos = new int[n+2][2];
			  al = new ArrayList<>();
			  visited = new int[n+2]; 
			  StringTokenizer st = new StringTokenizer(br.readLine());	  
			  
			  for(int i =0; i<n+2; i++) {
				  int x = Integer.parseInt(st.nextToken());
				  int y = Integer.parseInt(st.nextToken());
				  pos[i][0]=x;
				  pos[i][1]=y;
			  }
			  
			  for(int i=0; i<n+2; i++) {
				  al.add(new ArrayList<>());
			  }
			  
			  for(int i=0; i<n+2; i++) {
				  for(int j=0; j<n+2; j++) {
					  int d = Math.abs(pos[i][0]-pos[j][0]) + Math.abs(pos[i][1]-pos[j][1]);
					  al.get(i).add(d);
				  }
			  }
			  
			  dfs(0,1,0);
			  
			  System.out.println("#"+tc+" "+min);
			  
		}
		
	}
	static void dfs(int nI, int depth,int sum) {
		if(sum>=min) return;
		
		visited[nI] =1;
		
		if(depth==n+2) {
			min = Math.min(min,sum);
			visited[nI] =0;
			return;
		}
		
		for(int i =1; i<n+2; i++) {
			if(visited[i]==0) {
				if(i==1 && depth!=n+1) continue;
				
				int nD = al.get(nI).get(i);
				
				dfs(i,depth+1,sum+nD);
			}
		}
		
		visited[nI] =0;
		
		
		
	}
	
	
	
}
