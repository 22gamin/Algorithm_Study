package xweek13;

import java.util.*;
import java.io.*;

public class b_2096 {
	static int N, sumMax[],sumMin[],max,min;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        
		sumMax = new int[3]; 
		sumMin = new int[3];
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(i==0) {
				sumMax[0] = a; sumMax[1] = b; sumMax[2] = c;
				sumMin[0] = a; sumMin[1] = b; sumMin[2] = c;
				continue;
			}
			
			int prevMax0 = sumMax[0];
			int prevMax1 = sumMax[1];
			int prevMax2 = sumMax[2];
			
			int prevMin0 = sumMin[0];
			int prevMin1 = sumMin[1];
			int prevMin2 = sumMin[2];
			
			sumMax[0] = Math.max(prevMax0, prevMax1) + a;
			sumMin[0] = Math.min(prevMin0, prevMin1) + a;

			sumMax[1] = Math.max(Math.max(prevMax0, prevMax1), prevMax2) + b;
			sumMin[1] = Math.min(Math.min(prevMin0, prevMin1), prevMin2) + b;

			sumMax[2] = Math.max(prevMax1, prevMax2) + c;
			sumMin[2] = Math.min(prevMin1, prevMin2) + c;

		} //입력 끝

		for(int i = 0; i<3; i++) {
			max = Math.max(max, sumMax[i]);
			min = Math.min(min, sumMin[i]);
		}
		System.out.println(max + " " + min);
	}

}
