package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14510 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int t=1;t<=T;t++) {
			int n=Integer.parseInt(br.readLine());
			int[] trees=new int[n];
			st=new StringTokenizer(br.readLine());
			
			int max=0;
			for(int i=0; i<n;i++) {
				trees[i]=Integer.parseInt(st.nextToken());
				max=Math.max(max, trees[i]);
			}
			
			int even=0, odd=0;
			for(int i=0;i<n;i++) {
				int diff=max-trees[i];
				
				even+=diff/2;
				odd+=diff%2;
			}
			
			if(even>odd) {
				while(Math.abs(even-odd)>1) {
					even--;
					odd+=2;
				}
			}
			
			int result=0;
			if(even>odd) {
				result=even*2;
			} else if(odd>even) {
				result=odd*2-1;
			} else {
				result=even+odd;
			}
			System.out.println("#" + t + " " + result);
		}
	}
}