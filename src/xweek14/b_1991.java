package xweek14;

import java.util.*;
import java.io.*;

public class b_1991 {
	static Map<Character,char[]> map = new HashMap<>();
	static String answer = "";
	
	static void before(char par) {
		answer += par;
		char[] find = map.get(par);
		
		if(find[0] != '.') {
			before(find[0]);		
		}	
		if(find[1] != '.') {
			before(find[1]);
		}
	}
	
	static void center(char par) {
		char[] find = map.get(par);
		
		if(find[0] != '.') {
			center(find[0]);
		}
		
		if(find[1] != '.') {
			answer += par;
			center(find[1]);
		}
		else {
			
			answer += par;
		}
	}
	
	static void after(char par) {
		char[] find = map.get(par);
		
		if(find[0] != '.') {
			after(find[0]);
		}
		
		if(find[1] != '.') {
			after(find[1]);
		}

		answer += par;

	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n =0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char par = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			map.put(par, new char[] {left,right});
		} //입력 끝

		before('A');
		sb.append(answer).append("\n");
		
		answer = "";
		center('A');
		sb.append(answer).append("\n");
		
		answer = "";
		after('A');
		sb.append(answer).append("\n");
		
		System.out.println(sb);
	}

}
