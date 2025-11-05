import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] a,b,c,d,al,al2;
	static long result;
	static Map<Integer, Integer> temp;

	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		result = 0;
	
		
		a = new int[n];
		b = new int[n];
		c = new int[n];
		d = new int[n];
		al = new int[n*n];
		al2 = new int[n*n];
		for(int i  =0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		int aI =0;
		
		for(int i = 0 ; i<n; i++) {
			for(int j = 0 ; j<n; j++) {
				int sum = a[i] + b[j];
				int sum2  =  c[i] + d[j];
				al[aI] = sum;
				al2[aI] =sum2;
				aI++;
			}
		}
		Arrays.sort(al);
		Arrays.sort(al2);
		
		int l = 0 ; 
		int r = n*n-1;
		
		
		while(l<n*n && r>=0) {
			int sum = al[l] + al2[r];
			
			if(sum==0) {
				long sl=1;
				long sr=1;
				
				
				if(l!=n*n-1) {
					while(al[l]==al[l+1]) {
						sl++;
						l++;
						if(l==n*n-1) {
							break;
						}
					}
				}
				
			
				if(r!=0) {
					while(al2[r]==al2[r-1]) {
						sr++;
						r--;
						if(r==0) {
							break;
						}
					}
				}
				
				result += (sl*sr);
				l++;
				r--;
					
				
			}else if(sum>0) {
				r--;
			}else if(sum<0) {
				l++;
			}
		}
		
		
		
		System.out.println(result);
		
		
		
	
	}
	
		
}
