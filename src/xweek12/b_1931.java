package xweek12;

import java.util.*;
import java.io.*;

public class b_1931 {
	static int N;
	static List<Meeting> meetings;
	
	static class Meeting implements Comparable<Meeting>{
		int start; 
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
		
		@Override
		public String toString() {
			return "[" + this.start + "," + this.end + "]";
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		meetings = new ArrayList<>();
		
		for(int n = 0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meetings.add(new Meeting(start,end));
		}
		Collections.sort(meetings);
		
		int end = 0;
		int cnt = 0;
		
		for(int i = 0; i<N; i++) {
			if (end <= meetings.get(i).start) {
				end = meetings.get(i).end;
				cnt++;

			}
		}
		
		System.out.println(cnt);
	}

}
