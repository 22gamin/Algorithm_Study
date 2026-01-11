import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, m;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int total = 0;
		int maxL = 0;
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
			maxL = Math.max(arr[i], maxL);
		}
		
		int start = maxL;
		int end = total;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int count = 1;
			int sum = 0;
			
			for(int i = 0; i < n; i++) {
				if(sum + arr[i] > mid) {
					count++;
					sum = arr[i];
				} else {
					sum += arr[i];
				}
			}
			
			if(count <= m) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(start);
	}
}
