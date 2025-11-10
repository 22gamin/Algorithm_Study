import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static long m;
	static long [] arr1, arr2;
	static ArrayList<Long> tComb1, tComb2;
	static long [] comb1, comb2;
	static long count ;
	
	
 	public static void main(String[] args)throws IOException {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		arr1 = new long[n/2];
		arr2 = new long[n - n/2];
		
		StringTokenizer st2 =new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			if(i<n/2) {
				arr1[i] = Long.parseLong(st2.nextToken());
			}else {
				arr2[i-n/2] = Long.parseLong(st2.nextToken());
			}
		}

		tComb1 = new ArrayList<>();
		tComb2 = new ArrayList<>();
		
		for(int i = 0; i<n/2; i++) {
			comb1(i,0);
		}
		for(int i = 0; i<n - (n/2); i++) {
			comb2(i,0);
		}
		
		count += tComb1.size();
		
		count += tComb2.size();
		
		
		Collections.sort(tComb1);
		Collections.sort(tComb2);
		
		for(long x : tComb1) {
			long want = m -x ;
			
			int wI = search(want);
			
			if(wI>-1) {
				count += (wI+1);
			}
			
		}
		
		System.out.println(count+1);
		
 	}
	
 	
 	
 	static int search(long a) {
 		int l = 0;
 		int r = tComb2.size()-1;
 		int max = -1;
 		
 		while(l<=r) {
 			int mid = (l+r)/2 ;
 			
 			if(tComb2.get(mid)==a) {
 				max= Math.max(max, mid);
 				l=mid+1;
 			}else if(tComb2.get(mid)>a) {
 				r = mid-1;
 			}else {
 				max= Math.max(max, mid);
 				l = mid+1;
 			}
 			
 			
 		}
 		return max;
 	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	static void comb1 (int start,long result) {
 		result += arr1[start];
 		if(result>m) return;
 		
 		tComb1.add(result);
 		
 		for(int i = start+1 ; i<n/2; i++) {
 			comb1(i,result);
 		}
 	}
 	
 	static void comb2 (int start,long result) {
 		result += arr2[start];
 		if(result>m) return;
 		
 		tComb2.add(result);
 		
 		for(int i = start+1 ; i<n - n/2; i++) {
 			comb2(i,result);
 		}
 	}
		
}
