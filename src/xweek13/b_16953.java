package xweek13;

import java.util.*;
import java.io.*;

public class b_16953 {
	static int A,B,min;
	
	static void find(int cnt, long num) {
		if (num == B) {
			min = Math.min(cnt, min);
			return ;
		}
		
		if(num > B) {
			return ;
		}
		
		String str = String.valueOf(num);
//		int numChange = Integer.parseInt(str+1);
		long numChange = Long.parseLong(str+1);
		
		find(cnt+1,num*2);
		find(cnt+1,numChange);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		find(0,A);
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min+1);
		}
	}

}
