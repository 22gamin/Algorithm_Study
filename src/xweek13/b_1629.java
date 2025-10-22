package xweek13;

import java.util.*;
import java.io.*;

public class b_1629 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		System.out.println(count(A,B,C));
	}
	static long count(long x, int y, long z) {
		
		if(y == 1) return x%z;
		
		long result = count(x,y/2,z);
		
		long answer = (result * result) %z;
		
		if(y % 2 != 0) {
			answer = (answer*x)%z;
		}
		
		return answer;
	}

}
