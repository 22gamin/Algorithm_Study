import java.io.*;
import java.util.*;

public class Main {
	static int n ,m;
	static int cycle;
	static int []p;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		StringTokenizer st0 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st0.nextToken());
		m = Integer.parseInt(st0.nextToken());
		while(n != 0 || m != 0) {
			
			p = new int[n+1];
			for(int i =1; i<=n; i++) {
				p[i] =i;
			}
			cycle = 0;
			Set<Integer> cSet = new HashSet<>();
			Set<Integer> set = new HashSet<>();
			
			for(int i =0; i<m; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				int a = find(x);
				int b = find(y);
				if(a==b) {
					cSet.add(a); // 사이클이다.
				}else {	//두개가 서로 다른 연결관계일때
					union(a,b);
					if(cSet.contains(a)||cSet.contains(b)) {
						cSet.add(a);
					}
				}
				
			
			}
			
			int count = 0;
			for(int i =1; i<=n; i++) {
				int a = find(i);
				if(!cSet.contains(a)) {
					set.add(a);
				}
			}
			count = set.size();
			
			
			
			
			
			
			
			
			
			
		
			if(count==0) {
				System.out.println("Case "+t+": No trees.");
			}else if(count ==1 ) {
				System.out.println("Case "+t+": There is one tree.");
			}else {
				System.out.println("Case "+t+": A forest of "+count+" trees.");
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t++;
		}
				
		
		
	}
	public static int find(int x) {
	    if(p[x] != x) {
	        p[x] = find(p[x]);
	    }
	    return p[x];
	    }
	
	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		p[rootY] = rootX;
	}
	
}
