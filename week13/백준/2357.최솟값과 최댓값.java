import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] arr;
	static int[] maxTree, minTree;
	public static void main(String[] args)throws IOException {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st  = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		maxTree = new int[4*(n+1)];
		minTree = new int[4*(n+1)];
		
		for(int i = 1 ; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		init1(1,1,n);
		init2(1,1,n);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =  0 ; i<m ; i++) {
			StringTokenizer st2  = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			int min = get1(1,1,n,a,b);
			int max = get2(1,1,n,a,b);
			sb.append(min+" "+ max).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}
	
	static void init1(int node, int start, int end) {
		if(end==start) {
			minTree[node] = arr[end];
			return;
		}
		
		init1(2*node, start, (start+end)/2);
		init1(2*node+1, (start+end)/2+1, end);
		
		minTree[node] = Math.min(minTree[2*node], minTree[2*node+1]);
	}
	
	
	static int get1(int node, int start, int end, int left, int right) {
		if(end<left || right<start) {
			return Integer.MAX_VALUE;
		}
		
		if(left<=start && right>=end) {
			return minTree[node];
		}
		
		int a = get1(2*node, start, (start+end)/2,left, right);
		int b = get1(2*node+1, (start+end)/2+1, end,left, right);
		
		return Math.min(a, b);
	}
	
	
	
	
	
	
	
	
	
	
	static void init2(int node, int start, int end) {
		if(end==start) {
			maxTree[node] = arr[end];
			return;
		}
		
		init2(2*node, start, (start+end)/2);
		init2(2*node+1, (start+end)/2+1, end);
		
		maxTree[node] = Math.max(maxTree[2*node], maxTree[2*node+1]);
		
	
	}
	
	static int get2(int node, int start, int end, int left, int right) {
		if(end<left || right<start) {
			return 0;
		}
		
		if(left<=start && right>=end) {
			return maxTree[node];
		}
		
		int a = get2(2*node, start, (start+end)/2,left, right);
		int b = get2(2*node+1, (start+end)/2+1, end,left, right);
	
		return Math.max(a, b);
	}
	
	
		
}
