import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static ArrayList<ArrayList<Integer>> al;
	static int [] visit;
	static int count;
	public static void main(String[] args )throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		al = new ArrayList<>();
		
		for(int i =0; i<=n; i++) {
			al.add(new ArrayList<>());
		}
		
	
		for(int i =0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			al.get(x).add(y);
			al.get(y).add(x);
		}
		
		count = 0;
		visit = new int[n+1];
		visit[1] =1;
		for(int x : al.get(1)) {
			if(visit[x]==1) count--;
			dfs(x,1);
			
			
		}
		
		System.out.println(count);
	}
	
	static void dfs(int x, int d) {
		visit[x] = 1;
		count++;
		if(d == 2) {
			return;
		}
		
		for(int nx : al.get(x)) {
			if(visit[nx]==0) {
				dfs(nx,d+1);
			}
		}
		
	}
	
	
	
	
}
