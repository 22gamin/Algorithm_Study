package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B12101 {
	static int n, k;
	static int count=0;
	static List<Integer> list = new ArrayList<>();
	static boolean found = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		dfs(0);
		if (!found) System.out.println(-1);
	}
	
	static void dfs(int sum) {
		if(sum==n) {
			count++;
			if(count==k) {
				for(int i=0;i<list.size();i++) {
					System.out.print(list.get(i));
					if(i<list.size()-1) {
						System.out.print("+");
					}
				}
				System.out.println();
				found = true;
			}
			return;
		}
		
		if(sum>n || found) return;
		
		for(int i=1;i<=3;i++) {
			list.add(i);
			dfs(sum+i);
			list.remove(list.size()-1);
		}
	}
}
