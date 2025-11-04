import java.io.*;
import java.util.*;

public class Main {
	static int n, k ;
	
	static long result;
	static int[][] jewls;
	static TreeMap<Integer,Integer> bags;
	
	
	
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		jewls = new int[n][2];
		bags = new TreeMap<>();
		result = 0;
		
		for(int i = 0 ; i <n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			jewls[i][0] =  Integer.parseInt(st2.nextToken()); // 무게
			jewls[i][1] =  Integer.parseInt(st2.nextToken());	// 값어치
		}
		
		for(int i =0; i<k; i++) {
			int w = Integer.parseInt(br.readLine());
			if(bags.containsKey(w)) {			
				bags.put(w,bags.get(w)+1);
			}else {
				bags.put(w,1);
			}
		}
		
		Arrays.sort(jewls,
				(a,b)->{
					return b[1] - a[1];
				}
				
		);
		
		
		
		for(int i =0; i<n; i++) {
			if(bags.isEmpty()) break;
			int m = jewls[i][0];
			int v = jewls[i][1];
			
			Integer key =  bags.ceilingKey(m);
			
			if(key == null) {
				continue;
			}
			
			int count = bags.get(key);
			result += v;
			count--;
			
			if(count ==0) {
				bags.remove(key);
			}else {
				bags.put(key, count);
			}
			
		}
		
		System.out.println(result);
	}
	
}
