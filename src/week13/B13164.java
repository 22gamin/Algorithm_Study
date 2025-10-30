package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		// 각 차이값 저장
		int[] diff = new int[N-1];
		for(int i=1;i<N;i++) {
			diff[i-1]=arr[i]-arr[i-1];
		}
		
		// 정렬
		Arrays.sort(diff);
		
		// k-1개의 큰 값 더하기
		int sum=0;
		for(int i=N-2;i>=N-K;i--) {
			sum+=diff[i];
		}
		
		int total = arr[N-1]-arr[0];
		System.out.println(total-sum);
		
	}

}
