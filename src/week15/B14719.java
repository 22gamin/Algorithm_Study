package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] count = new int[w]; // 각 열의 블록 높이

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		int[] left_max = new int[w];
		int[] right_max = new int[w];

		left_max[0] = count[0];
		for (int i = 1; i < w; i++) {
			left_max[i] = Math.max(left_max[i - 1], count[i]);
		}
		
		right_max[w-1] = count[w-1];
		for (int i = w-2; i >= 0; i--) {
			right_max[i] = Math.max(right_max[i + 1], count[i]);
		}

		int totalWater = 0;
		for(int i=0;i<w;i++) {
			int water=Math.min(left_max[i], right_max[i])-count[i];
			if(water>0) {
				totalWater+=water;
			}
		}
		System.out.println(totalWater);
	}
}
