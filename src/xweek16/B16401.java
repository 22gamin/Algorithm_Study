package xweek16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16401 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		int maxlen=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			maxlen = Math.max(arr[i], maxlen);
		}
		int low =1;
		int high = maxlen;
		int result = 0;
		
		while(low<=high) {
			
			int mid = (low+high)/2;
			
			// mid길이로 m명에게 나눠줄 수 있나
			long count = 0;
			for(int i=0; i<n; i++) {
				count +=arr[i]/mid;
			}
			if(count>=m) {
				result = mid;
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		System.out.println(result);
	}
}
