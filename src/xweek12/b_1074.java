package test;

import java.util.*;
import java.io.*;

public class b_1074 {
	static int N,count;
	
	static void z(int size, int r, int c) {
		if (size == 1) {
			return;
		}
		
		
		int newSize = size /2;
		
		//1사분면
		if(r< newSize && c<newSize) {
			z(newSize,r,c);
		}
		//2사분면
		else if(r < newSize && c>= newSize) {
			count += newSize*newSize;
			z(newSize,r,c-newSize);
		}
		//3사분면
		else if(r >= newSize && c<newSize) {
			count += (newSize * newSize) * 2;
			z(newSize,r-newSize, c);
		}
		//4사분면
		else {
			count += (newSize * newSize) * 3;
			z(newSize,r-newSize, c-newSize);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int size = (int)Math.pow(2,N);
		
		z(size, r,c );
		System.out.println(count);
	}

}
