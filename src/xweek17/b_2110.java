package xweek17;

import java.util.*;
import java.io.*;

public class b_2110 {
	static int N,C;
	static List<Integer> home = new ArrayList<>();
	
	static boolean check(long mid) {
		int count = 1;
		int lastPos = home.get(0);
		
		for(int i = 0; i<home.size(); i++) {
			if(home.get(i) - lastPos >= mid) {
				count++;
				lastPos = home.get(i);
			}
		}
		
		return count >= C;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for(int n = 0; n<N; n++) {
			home.add(Integer.parseInt(br.readLine()));
		} //입력 끝
		Collections.sort(home);
		
		long low = 1;
		long high = home.get(home.size()-1) - home.get(0);
		
		long dis = 0;
		
		
		
		while(low <= high) {
			long mid = low + (high-low)/2;
			
			if(check(mid)) {
				dis = mid;
				
				low = mid + 1;
			} else {
				high = mid-1;
			}
		}
		System.out.println(dis);
	}

}
