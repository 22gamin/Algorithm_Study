import java.io.*;
import java.util.*;

public class Main {
	
	static int  n,m;
	static int [] p;
	static int [] visit;
	static int [] arr;
	static int [] size;
	static long k, cost;
	static int count;
	static long result;
	static boolean isP =false;
	
	public static void main(String[] args)throws IOException {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		arr = new int[n+1];
		visit = new int[n+1];
		size = new int[n+1];
		cost = 0;
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i =1; i<=n; i++) {
			size[i] = 1;
			p[i]=i;
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		for(int i =0;i<m ; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st3.nextToken());
			int y = Integer.parseInt(st3.nextToken());
			
			union(x,y);
			
		}
		
		for(int i = 1; i<=n; i++) {
			int x = find(i);
			
			if(visit[x] ==1)continue;
			visit[x]=1;
			
			cost += arr[x];
			count += size[x];
			if(cost >k) {
				isP = false;
				break;
			}
			
			if(count ==n ) {
				isP = true;
				break;
			}
			
			
		}
		
		if(isP) {
			System.out.println(cost);
		}else {
			System.out.println("Oh no");
		}
		
		
		
	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py) return;
		
		if(arr[px]>arr[py]) {
			p[px] = py;
			size[py] += size[px];
		}else {
			p[py]=px;
			size[px] += size[py];
		}	
	}
	
	static int find(int x) {
		if(p[x]==x) {
			return x;
		}else {
			p[x] = find(p[x]);
			return p[x];
		}
	}
	
	
	
	
	
	
	
}
