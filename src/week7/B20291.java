package week7;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class B20291 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		sc.nextLine();
		
		TreeMap<String, Integer> map = new TreeMap<>();

		for(int i=0;i<N;i++) {
			String file = sc.nextLine();
			String[] parts=file.split("\\.");
			String ext = parts[1];
			map.put(ext,map.getOrDefault(ext, 0)+1);
		}

		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}
