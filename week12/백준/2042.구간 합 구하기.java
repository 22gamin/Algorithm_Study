
import java.util.*;
import java.io.*;

public class Main {
	static int n, m, k;
	static long[] arr;
	static long[] tree;
 
    public static void main(String[] arg) throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n+1];
        tree = new long[4*n];
        
        for(int i = 1 ; i<=n; i++) {
        	arr[i] = Long.parseLong(br.readLine());
        }
        init(1,1,n);
      
        StringBuilder sb = new StringBuilder();
        
        
        for(int i = 0 ; i<m+k; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int q = Integer.parseInt(st2.nextToken());
        	int a = Integer.parseInt(st2.nextToken());
        	long b = Long.parseLong(st2.nextToken());
        	if(q==1) {
        		update(1, 1 , n, a,b);
        	}else {
        		sb.append(get(1,1,n,a,(int)b)).append("\n");
        	}
        	
        }
        
        System.out.print(sb.toString().trim());
        
        
        
        
      
    }
    
    static long get(int node, int start, int end ,int left, int right) {
    	if(end <left || right< start ) return 0;
    	
    	if(left <= start && end<=right) {
    		return tree[node];
    	}
    	
    	long l = get(node*2 , start , (end+start)/2, left, right);
    	long r = get(node*2+1 , (end+start)/2+1,end, left, right);
    	
    	return l+r;
    }
    
    
    static void update(int node, int start, int end, int idx, long v) {
    	if(idx<start|| end<idx) {
    		return;
    	}
    	
    	if(start == end) {
    		arr[idx] =v;
    		tree[node] = v;
    		return;
    	}
    	
    	update(node *2, start, (start+end)/2 , idx ,v);
    	update(node *2+1,(end+start)/2+1,end, idx,v );
    	
    	tree[node] = tree[node *2] + tree[node *2+1];
    	
    }
    
    
    
    
    static void init(int node , int start , int end) {
    	
    	if(start == end) {
    		tree[node] = arr[start];
    		return;
    	}
    	
    	init(node*2,start, (start+end)/2 );
    	init(node*2+1 , (start+end)/2 +1 , end);
    	
    	tree[node] = tree[node*2]  + tree[node*2 +1]; 
    } 
}