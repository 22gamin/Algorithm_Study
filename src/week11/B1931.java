package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931 {
	
	static class time implements Comparable<time>{
		int start;
		int end;
		
		public time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(time o) {
			int cmp = Integer.compare(this.end, o.end);
			if(cmp!=0) return cmp;
			return Integer.compare(this.start, o.start); // 끝 시간이 같을 때 시작 시간 오름차순
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		time[] meeting = new time[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			meeting[i]=new time(s,e);
		}
		
		Arrays.sort(meeting);

		int prev_end = meeting[0].end;
		int cnt=1;
		
		for(int i=1;i<N;i++) {
			if(prev_end > meeting[i].start) continue;
			
			else {
				prev_end = meeting[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

