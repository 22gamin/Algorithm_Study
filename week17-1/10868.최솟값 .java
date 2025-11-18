import java.io.*;
import java.util.*;

public class Main {
	static int n , m;
	static int[] arr;
	static int[] tree;

	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int [n+1];
		tree = new int[4*n + 1];
		
		for(int i = 1 ; i<=n; i++) {
			int x = Integer.parseInt(br.readLine());
			arr[i]=x; 
		}
		init(1,1,n);
		
		
		StringBuilder sb = new StringBuilder();
		//구하기
		for(int i =0; i<m ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a =  Integer.parseInt(st2.nextToken());
			int b =  Integer.parseInt(st2.nextToken());
			
			sb.append(find(1,1,n,a,b)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	
	static void init(int t,int s, int e) {
		if(s==e) {
			tree[t] = arr[s];
			
			return;
		}
		int mid = (s+e)/2;
		
		init(2*t,s,mid );
		init(2*t+1,mid+1,e);
		
		tree[t] = Math.min(tree[2*t],tree[2*t +1]);
	}
	
	
	static int find(int t, int s, int e, int l, int r) { //s,e(현재 범위)  l,r(찾고자 하는 범위)   t(세그트리 인덱스)
		if(s>r || e<l) return Integer.MAX_VALUE;
		
		if(l<=s && e<=r) {
			return tree[t];
		}
		int mid = (s+e)/2;
		int a = find(2*t,s,mid,l,r);
		int b = find(2*t+1,mid+1,e,l,r);
		
		return Math.min(a, b);
		
	}
	
}
