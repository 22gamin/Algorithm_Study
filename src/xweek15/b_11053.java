package xweek15;

import java.util.*;
import java.io.*;

public class b_11053 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n<N; n++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(n==0) {
			
			// 첫 번째 값으로 초기화
				list.add(num);
				continue;
			}
			
			if(num > list.get(list.size()-1)) {
			
			// 1. lis의 마지막 값보다 크면, 뒤에 추가
				list.add(num);
				
			} else {
			
			// 2. lis의 마지막 값보다 작거나 같으면,
      //    lis 배열에서 num이 들어갈 위치를 이진 탐색으로 찾아서 덮어씀
      
      // Collections.binarySearch는 num 이상의 값이 처음 나오는 위치(lower bound)를 찾음
				int idx = Collections.binarySearch(list, num);
				
				if (idx < 0) {
					idx = -(idx+1);
				}
				
				list.set(idx, num); // 해당 위치의 값을 num으로 교체
			}
		}
		System.out.println(list.size());

	}

}
