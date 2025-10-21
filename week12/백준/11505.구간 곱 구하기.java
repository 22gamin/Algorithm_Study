import java.util.*;
import java.io.*;

public class Main {
	static int n, m , k;
	static long [] arr;
	static long [] tree;
	static final int r = 1000000007;
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];
        tree = new long[4*n];
        
        for(int i = 0 ; i<n; i++) {
        	arr[i] = Long.parseLong(br.readLine());
        }
        
        init(1,0,n-1);
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i<m+k; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int q = Integer.parseInt(st2.nextToken());
        	int a = Integer.parseInt(st2.nextToken());
        	int b = Integer.parseInt(st2.nextToken());
        	if(q==1) {
        		update(1,0,n-1,a-1,b);
        	}else {
        		sb.append(get(1,0,n-1,a-1,b-1)).append("\n");
        	}
        }
        
        
        System.out.print(sb.toString().trim());
        
        
        
        
     
    }
    
    
    static void init(int node , int start, int end) {
    	if(start == end) {
    		tree[node] = arr[start]%r;
    	}else {
    		init(2*node,start,(start+end)/2);
    		init(2*node+1,(start+end)/2+1,end);
    		tree[node] = (tree[node*2] * tree[node*2+1])%r;
    	}
    }
    
    static long get(int node, int start, int end, int left, int right) { //left랑 right가 찾으려는 범위고
    	//start랑 end를 줄여나가면서 범위에 있으면 바로 뽑아내버리는겨
    	if(right<start || left>end) {
    		return 1;
    	}
    	if(left<=start && end<=right) {
    		return tree[node];
    	}
    	long lGet = get(node*2 ,start , (start+end)/2 , left, right)%r;
    	long rGet = get(node*2+1 , (start+end)/2+1, end, left, right)%r;
    	
    	return (lGet * rGet) % r;
    	
    }
    
    static void update(int node, int start, int end, int index, long val) {
        if (index < start || index > end) {
            return;
        }
        if (start == end) {
            arr[index] = val;
            tree[node] = val;
            return;
        }
        update(node*2, start, (start+end)/2, index, val);
        update(node*2+1, (start+end)/2+1, end, index, val);
        tree[node] = (tree[node*2] * tree[node*2+1])%r;
    }
    
}