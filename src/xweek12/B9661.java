package xweek12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9661 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		/*
		int k = (int)(Math.log(n)/Math.log(4));
		long num = (long)Math.pow(4, k);
		// k가 최대 19
		long total=0;
		boolean chk = false;
		for(int i=0; i<=k; i++) {
			total = (long)(1 + Math.pow(4, i));
			if(n%total == 0 || n%total == 2) chk = true;
		}
		*/
		if(n%5 == 2 || n%5 == 0) System.out.println("CY"); else System.out.println("SK");		
	}
}
