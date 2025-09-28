import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{	
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1;  tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n  = Integer.parseInt(st.nextToken());
			int m  = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int [] arr = new int [n];
			for(int i =0; i<n; i++) {
				arr[i]= Integer.parseInt(st2.nextToken());
			}
			
			int l = 0;
			int r = 1000000000;
			int result = 0;
			
			while(l<=r) {
				int mid = (l+r)/2;
				
				long sum = 0;
				for(int i = 0; i<n; i++) {
					int a = arr[i]-mid;
					if(a>0) {
				
						sum+=a;
					}
				}
				
				if(sum>=m) {
					
					result = mid;
					l = mid+1;
				}else {
					r=mid-1;
				}
						
			}
			
			System.out.println("#"+tc+" "+result);
			
			
		}
	}
}
