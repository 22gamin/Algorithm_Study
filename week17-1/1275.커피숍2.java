import java.io.*;
import java.util.*;

public class Main {
	
	static int  n,q;
	static long[] arr;
	static long[] tree;
	
	
	public static void main(String[] args)throws IOException {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		tree = new long[4*(n+1)];
		arr = new long[n+1];
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for(int i =1; i<=n; i++) {
			arr[i] = Long.parseLong(st3.nextToken());
		}
		
		init(1,n,1);
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<q; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			if(x>y) {
				int temp = x;
				x=y;
				y=temp;
			}
			long temp  =get(1,n,x,y,1);
			sb.append(temp).append("\n");
			update(1,n,a,b,1);
		}
		
		System.out.println(sb.toString());
	}
	
	static void init(int s, int e, int t) {
		if(s==e) {
			tree[t] = arr[s];
			return;
		}
		
		int mid = (s+e)/2;
		
		init(s,mid,2*t);
		init(mid+1, e,2*t+1);
		
		tree[t]  = tree[2*t] + tree[2*t + 1];
		
	}
	
	static long get(int s,  int e, int l, int r, int t) {
		if(r<s || e<l) return 0;
		
		if(l<=s &&e<=r) return tree[t];
		
		int mid = (s+e)/2;
		
		long a = get(s,mid,l,r,2*t);
		long b = get(mid+1,e,l,r,2*t+1);
		
		return a+b;
	}
	
	static void update(int s, int e, int index, int v, int t) {
		if(index<s || e<index) return;
		
		if(s==e && s==index) {
			tree[t] = v; 
			return;
		}
		int mid = (s+e)/2;
		update(s,mid,index,v,2*t);
		update(mid+1,e,index,v,2*t+1);
		
		tree[t]  = tree[2*t] + tree[2*t + 1];
		
		
	}
	
		
		
}
	
	
