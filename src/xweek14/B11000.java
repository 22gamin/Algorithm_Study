package xweek14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11000 {
	public static class node implements Comparable<node>{
		int x, y;
		public node(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public int compareTo(node other) {
			if(this.x == other.x) {
				return this.y - other.y;
			}
			return this.x - other.x;
		}
	}
	static List<node> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 list.add(new node(a, b));
		}
		
		Collections.sort(list);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(node cur : list) {
			if (!pq.isEmpty() && pq.peek() <= cur.x) {
				pq.poll();
			}
			pq.add(cur.y);
		}
		System.out.println(pq.size());
	}
}
