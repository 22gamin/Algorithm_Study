package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B4195 {

	static int[] parent;
	static int[] size;
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int F=Integer.parseInt(br.readLine());
			parent = new int[F*2]; 
			size = new int[F*2];
			map=new HashMap<>();
		
			for(int i=0;i<F*2;i++) {
				parent[i]=i;
				size[i]=1;
			}
			
			int idx = 0;
			for(int i=0;i<F;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if(!map.containsKey(a)) map.put(a, idx++);
				if(!map.containsKey(b)) map.put(b, idx++);
				
				int aId = map.get(a);
				int bId = map.get(b);
				
				sb.append(union(aId,bId)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
            if (a < b) {
                parent[b] = a;
                size[a] += size[b];
            } else {
                parent[a] = b;
                size[b] += size[a];
            }
        }

        return size[find(a)]; 
	}
}
