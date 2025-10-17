package xweek12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1931 {	
	public static class pair implements Comparable<pair>{
		int x, en;
		public pair(int x, int en) {
			this.x=x;
			this.en=en;
		}
		public int compareTo(pair other) {
			if(this.en == other.en) {
				return this.x-other.x;
			}
			return this.en - other.en;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<pair> li = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			li.add(new pair(start, end));
		}
		Collections.sort(li);
		int preX = 0, cnt = 0;
		for(int i=0; i<li.size(); i++) {
			pair cur = li.get(i);
			if(cur.x<preX ) continue;
			preX = cur.en;
			
			cnt++;
		}
		System.out.println(cnt);
	}
}
