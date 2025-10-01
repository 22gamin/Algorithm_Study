import java.util.*;
import java.io.*;https://github.com/22gamin/Algorithm_Study/blob/SY/10week/%EB%B0%B1%EC%A4%80/15824.%EB%84%88%20%EB%B4%84%EC%97%90%EB%8A%94%20%EC%BA%A1%EC%82%AC%EC%9D%B4%EC%8B%A0%EC%9D%B4%20%EB%A7%9B%EC%9E%88%EB%8B%A8%EB%8B%A4.java


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
