import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int [] arr;
	static int [] tree;
	
	public static void main(String[] args)throws IOException {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		tree= new int [4*(n+1)];
		arr = new  int [n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1,1,n);
		
		m = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0 ; i <m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st2.nextToken());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			if(q == 1) {
				update(1, 1, n , a ,b);
			}else {
				sb.append(get(1 , 1, n, a, b)).append("\n");
			}
			
		}
		
		System.out.print(sb.toString());
		
		
	}
	
	static void init(int node , int start, int end) {
		if(start == end) {
			tree[node] = end;
			return;
		}
		
		int mid = (start + end)/2;
		init(node*2 , start ,mid);
		init(node*2 +1, mid+1 , end);
		
		int aI = tree[node*2];
		int a = arr[aI];
		
		int bI = tree[node*2+1];
		int b = arr[bI];
		
		if(a>b) {
			tree[node] =bI;
		}else if(a<b) {
			
			tree[node] = aI;
		}else {
			if(aI<bI) {
				tree[node] = aI;
			}else {
				tree[node] = bI;
			}
		}
	}
	
	static int get(int node, int start, int end , int left, int right) {
		if(right<start || end<left) {
			return Integer.MAX_VALUE;
		}
		
		if( start>=left && end<=right) {
			return tree[node];
		}
		int mid = (start + end)/2;
		int aI = get(node*2, start,mid,left,right);
		int bI = get(node*2 +1 , mid+1, end,left,right);
		
		if(aI==Integer.MAX_VALUE) {
			return bI;
		}else if(bI==Integer.MAX_VALUE) {
			return aI;
		}
		
		if(arr[aI]<arr[bI]) {
			return aI;
		}else if(arr[aI] > arr[bI]) {
			return bI;
		}else {
			if(aI>bI) {
				return bI;
			}else {
				return aI;
			}
		}
	
	}
	
	static void update(int node, int start, int end, int idx, int v) {
		if(start>idx || end<idx ) {
			return;
		}
		if(start==end) {
			arr[idx] = v;
			return;
		}
		
		int mid = (start + end)/2;
		update(node*2 , start ,mid , idx ,v );
		update(node*2 +1, mid+1 , end, idx ,v);
		
		int aI = tree[node*2];
		int a = arr[aI];
		
		int bI = tree[node*2+1];
		int b = arr[bI];
		
		if(a>b) {
			tree[node] =bI;
		}else if(a<b) {
			
			tree[node] = aI;
		}else {
			if(aI<bI) {
				tree[node] = aI;
			}else {
				tree[node] = bI;
			}
		}
		
	}
	
}
