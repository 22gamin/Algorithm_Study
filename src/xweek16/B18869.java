package xweek16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B18869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		List<String> list = new ArrayList<>();
		for(int i=0; i<m; i++	) {
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[n];
			TreeSet<Integer> size = new TreeSet<>();
			
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				size.add(arr[j]);
			}
			
			HashMap<Integer, Integer> map = new HashMap<>();
			int rank = 0;
			for(int sizes : size) {
				map.put(sizes, rank++);
			}
			
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<n; j++) {
				sb.append(map.get(arr[j])).append(" ");
			}
			
			list.add(sb.toString());
			
		}
		long total = 0;
		for(int i=0; i<m; i++) {
			for(int j=i+1; j<m; j++) {
				if(list.get(i).equals(list.get(j))) {
					total++;
				}
			}
		}
		System.out.println(total);
	}
}
