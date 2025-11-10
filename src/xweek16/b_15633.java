package xweek16;

import java.util.*;
import java.io.*;

public class b_15663 {
	static int N, M, nums[];
	static boolean visited[];
	static List<List<Integer>> dap = new ArrayList<>();
	static Set<List<Integer>> set = new HashSet<>();
	
	static void find(List<Integer> answer) {
		if(answer.size() == M) {
			set.add(new ArrayList<>(answer));
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				answer.add(nums[i]);
				find(answer);
				
				answer.remove(answer.size()-1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
	
		for(int n = 0; n<N; n++) {
			nums[n] = Integer.parseInt(st.nextToken());
		} //입력 끝
		
		find(new ArrayList<>());
		
		List<List<Integer>> real = new ArrayList<>(set);
		
		Collections.sort(real,(listA, listB) -> {
			for(int i = 0; i<M; i++) {
				int com = listA.get(i).compareTo(listB.get(i));
				
				if(com != 0) {
					return com;
				}
			}
			return 0;
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(List<Integer> list : real) {
			for(int num : list) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
