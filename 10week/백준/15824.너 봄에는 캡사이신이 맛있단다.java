import java.util.*;
import java.io.*;


public class Main {
	static long m;
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		long result = 0;
		m = 1000000007;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int [n];
		
		for(int i =0 ; i <n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
	
		
		
		
		long [] pow = new long[n];
		
		for(int i=0; i<n; i++) {
			pow[i] = pow(i);
		}
		
		
		for(int i =0 ; i<n; i++) {
			long plus = (long)pow[i]-1;
			long minus = (long)pow[n-1-i]-1;
			
			plus %= m;
			minus %=m;

			result += (-(arr[i]*minus %m) +m )%m;
			result += (arr[i]*plus) %m;
			
		
			result %=m;
		}
		
		
		
		System.out.println(result);
		
		
	}
	
	
	
	public static long pow(int x) {
		if(x==0) return 1;
		if(x==1) return 2;
		long half = pow(x/2)%m;
		if(x%2 == 0) {
			return half*half%m;
		}else {
			return 2*half*half%m;
		}
	}
	

}
