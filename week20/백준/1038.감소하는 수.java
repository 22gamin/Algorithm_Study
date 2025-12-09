import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Long> l = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		if (n > 1022) {
			System.out.println(-1);
			return;
		}

		for (int i = 0; i < 10; i++) d(i);
		
		Collections.sort(l);
		System.out.println(l.get(n));
	}






	static void dfs(long v) {
		l.add(v);
		for (int i = 0; i < v % 10; i++) {
			dfs(v * 10 + i);
		}
	}
}
