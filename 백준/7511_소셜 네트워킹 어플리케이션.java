import java.io.*;
import java.util.*;

public class Main {
	static int n , k, m;
	static int[] p;
	static int[] h;
	public static void main(String[] args )throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder ();
		for(int t=1; t<=tc; t++) {
			sb.append("Scenario "+t+":").append("\n");
			n = Integer.parseInt(br.readLine());
			p = new int[n+1];
			h = new int[n+1];
			for(int i = 1; i<=n; i++) {
				p[i] = i;
			}
			
			k = Integer.parseInt(br.readLine());
			
			for(int i =0; i<k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union(x,y);
				
			}
			
			m = Integer.parseInt(br.readLine());
			
			for(int i = 0 ; i<m; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				
				if(find(x)==find(y)) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
			}
			sb.append("\n");
			
		}
		System.out.print(sb.toString());
	}
	
	
	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(h[rootX] > h[rootY]) {
			p[rootY] = rootX;
		}else if(h[rootY]>h[rootX]) {
			p[rootX] = rootY;
		}else {
			p[rootY] = rootX;
			h[rootX]++;
		}
		
		
	}
	
	public static int find(int x) {
		int rootX = p[x];
		if(rootX!=x) {
			p[x] = find(rootX);
		}
		return p[x] ;
	}
	
	
	
}
