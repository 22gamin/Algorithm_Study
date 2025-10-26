import java.io.*;
import java.util.*;

public class Main {
	static int[] visit;
	static char[] arr;
	static String a;
	static int size=0;
	static String result;
	static StringBuilder  sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = br.readLine();
		result ="";
		arr = new char[a.length()];
		for( int i  = 0 ; i<a.length(); i++) {
			 arr[i] = '0';
		}
		if(a.length()==1) {
			System.out.println(a);
		}else {
			zoac(0,a.length());
		}
		//한글자 예외처리
		
		System.out.println(sb.toString());
	
	
	}
	
	static void zoac(int start,int end) {
	
		while(start != end) {
			int  min = start; 
			for(int i =start; i<end ; i++) {
				
				if(a.charAt(i)<a.charAt(min)) {
					min  = i;	
				} // 찾고 min
			}
			
			
			
			arr[min] = a.charAt(min);
			size=  0 ;
			for(int j = 0  ; j<a.length(); j++) {
				if(arr[j]!='0') {
					sb.append(arr[j]);
					size++;
				}
			}
			sb.append("\n");
		
		
			
			//min에서 재귀호출
			zoac(min+1, end);
			
		
			//재귀 끝나면 min보다 이전거부터 다시 찾기시작해야함
			end = min;
			
			
				
			
		}
		
		
	}
		
	
	
}
