import java.io.*;
import java.util.*;

public class Main {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		
		int [] start = new int[n];
		int [] want  = new int[n];
		
		
		String a = br.readLine();
		String b = br.readLine();
		
		for(int i = 0 ; i<n; i++) {
			start[i]  = Integer.parseInt(String.valueOf(a.charAt(i)));
			want[i]  = Integer.parseInt(String.valueOf(b.charAt(i)));
		}
		
		int[] start2 = Arrays.copyOf(start,n);
		
		int result1 = 0;
		int result2 = 0;
		
		for(int i=0; i<n; i++) {
			if(i==0) {
				toggle(0, start);
				toggle(1,start);
				result1 ++;
			}else {
				if(start[i-1]!=want[i-1]) {
					toggle(i-1,start);
					toggle(i, start);
					if(i!=n-1) {
						toggle(i+1,start);
					}
					
					result1 ++;
				}
				
			}
		}//바꾸고 하는거
		
		if(start[n-1] != want [n-1]) {
			result1= Integer.MAX_VALUE;
		}
		
		
		
		for(int i=1; i<n; i++) {
			
			if(start2[i-1]!=want[i-1]) {
				toggle(i-1,start2);
				toggle(i, start2);
				if(i!=n-1) {
					toggle(i+1,start2);
				}		
				result2 ++;
			}
		}//안 바꾸고 하는거
		
		
		if(start2[n-1] != want [n-1]) {
			result2= Integer.MAX_VALUE;
		}
		
		int result = Math.min(result1, result2);
		
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void toggle(int index, int[] arr) {
		if(arr[index]==0) {
			arr[index] =1;
		}else {
			arr[index] = 0;
		}
	}
		
}
