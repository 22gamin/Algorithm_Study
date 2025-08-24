import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int s  =Integer.parseInt(st.nextToken());
	int left=0 , right = 0;
	int [] arr = new  int [n];
	StringTokenizer st2 = new StringTokenizer(br.readLine());

	for(int i =0; i<n; i++) {
		arr[i] = Integer.parseInt(st2.nextToken());
	}
	
	int sum =0;
	int min =n+1;
	
	
	while(right<=n&&left<=n) {
		if(sum<s&&right<n) {
			sum += arr[right];
			right++;	
		}else if(left<n) {
			sum -= arr[left];
			left++;  
		}
		
		if(sum>=s&&left<n) {
			min = Math.min((right-left),min);
		}
		if(right>=n&&left>=n) break;
	}
	if(min == n+1) {
		min =0;
	}
	System.out.println(min);
	br.close();
	}
}
