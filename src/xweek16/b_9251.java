package xweek16;

import java.util.*;
import java.io.*;

public class b_9251 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		//입력 끝
	
		List<Integer> list = new ArrayList<>();
		
		for(int i =0; i<str1.length(); i++) {
			for(int j = 0; j<str2.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					list.add(str1.charAt(i)-'A');
					break;
				}
			}
		}
		
		List<Integer> answer = new ArrayList<>();
		answer.add(str1.charAt(0)-'A');
		
		for(int i = 0; i<list.size(); i++) {
			int num = list.get(i);
			if(num > answer.get(answer.size()-1)) {
				answer.add(list.get(i));
				continue;
			}
			
			int idx = Collections.binarySearch(answer, list.get(i));
			
			if(idx < 0) {
				idx = -(idx+1);
			}
			
			answer.set(idx, num);
		}
		System.out.println(answer.size());
		
	}

}
