package xweek15;

import java.util.*;
import java.io.*;

public class b_14003 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] seq = new int[N];
		int[] a = new int[N];
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; i++) {
			
			if(i==0) {
				list.add(a[i]);
				continue;
			}
			
			if(a[i] > list.get(list.size()-1)) {
				list.add(a[i]);
				seq[i] = list.size()-1;
				
			} else {
				int idx = Collections.binarySearch(list, a[i]);
				
				if(idx < 0) {
					idx = -(idx+1);
				}

				list.set(idx, a[i]);
				seq[i] = idx;  //몇번째 들어가는지 저장
			}
		}
		
		//seq에는 받은 수열의 값이 가장 뒤에 있을 수 있는 값(자릿값, idx)가 저장되어 있음
		//seq[1]에는 1번째 받은 값이 있을 수 있는 가장 뒤의 값
		
		sb.append(list.size()).append("\n");
		
		int cnt = list.size()-1;
		List<Integer> answer = new ArrayList<>();
		
		for(int i = N-1; i>=0; i--) {
			if (seq[i]==cnt) {
				answer.add(a[i]);	
				cnt--;
			}
		}
		Collections.reverse(answer);
		
		for(int num : answer) {
			sb.append(num).append(" ");
		}

		System.out.println(sb);
	}

}
