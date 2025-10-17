package xweek12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] arr = s.split("-");
		int st = 0;
		int len = arr.length;
		
		for(int i=0; i<arr.length; i++) {
			String[] tmp = arr[i].split("\\+");
			int a = 0;
			for(int j=0; j<tmp.length; j++) {
				a+=Integer.parseInt(tmp[j]);
			}
			if(i==0) st+=a;
			else st-=a;
		}
		System.out.println(st);
	}
}
