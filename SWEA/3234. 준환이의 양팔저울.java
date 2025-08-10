
import java.util.*;
import java.io.*;

public class Solution{
	static int[] visited ; 
	static int[] arr;
	static int n;
	static int count;
	static int total;
	static int [] fact;
	
	
	public static void main(String[] arg)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			fact = new int[n+1];
			fact[0] = 1; 
			for(int i = 1; i<=n; i++) {
			    fact[i] = fact[i-1] * i;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n+1];
			total= 0;
			for(int i =1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				total += arr[i];
			}
			
			count = 0;
			
			visited = new int[n+1];
			
			
			for(int i =1; i<=n; i++) {
				
				raise(i,arr[i],0,1);
				
			}
			
	
			
		
			System.out.println("#"+tc+" "+count);
			
			
			
		}
		
	}
	
	public static void raise(int x,int l, int r,int d) {
		if(l>=r+total-(l+r)) {
			int rest = n  - d;
			count+= (1<<(rest)) *fact[n-d] ; 
			return;
		}
		
		if(d==n) {
			if(l>=r) {
				count++;
			}
			return;
		}
		
		visited[x]=1;
		
		for(int i =1; i<=n; i++) {
			if(visited[i]==0) {
				raise(i,l+arr[i],r,d+1);
				if(l>=r+arr[i]) {
					raise(i,l,r+arr[i],d+1);
				}
			}
		}
		visited[x]=0;
		
		
		
	}
	
	
}
