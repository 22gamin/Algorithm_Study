import java.io.*;
import java.util.*;

public class Main {

	
	
	
	static int [] dp;
 	static int n ;
	static List<Integer> [] tree ;

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		tree = new List[n+1];
		
		for(int i = 0 ; i <=n; i++) {
			tree[i] = new ArrayList<>();
		} 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x == -1) continue;		
			tree[x].add(i);
		}
		
		dp = new int[n];
		dfs(0);
		
		System.out.println(dp[0]);
		
		
	}
		
	static void dfs(int x) {
		List<Integer> temp = new ArrayList<>();
		for(int nx : tree[x]) {
			dfs(nx);
			temp.add(dp[nx]);
		}
		
		Collections.sort(temp,Collections.reverseOrder());
		
		int max = 0;
		
		for(int i = 0; i< temp.size(); i++) {
			max = Math.max(max , temp.get(i)+i+1);
		}
		
		dp[x] = max;
		
	}
	
	
	
	
	
		
	
	
}
