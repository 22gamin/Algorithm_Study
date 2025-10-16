package xweek12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2212 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		// 차이니까 n-1개 
		Integer[] diff = new Integer[n-1];
		for(int i=1; i<arr.length; i++) {
			diff[i-1] = arr[i] - arr[i-1];
		}
		int cnt = 0;
		Arrays.sort(diff, Collections.reverseOrder());
		for(int i=k-1; i<diff.length; i++) {
			cnt+=diff[i];
		}
		System.out.println(cnt);
	}
}
