import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static boolean[] in;
	static ArrayList<Integer>[] tree;
	static boolean find;
	static int result;
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1;  tc<=t ; tc++) {
			
			n = Integer.parseInt(br.readLine());
			tree= new ArrayList[n+1];
			in = new boolean[n+1];
			for(int i =0; i<=n; i++) {
				tree[i]= new ArrayList<>();
			}
			for(int i =0; i<n-1; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				in[b] = true;
				tree[a].add(b);
			}//트리 저장ㅇㅇ
			
			int root = 1;
			
			for(int i = 1 ; i<=n; i++) {
				if(!in[i]) {
					root=i;
					break;
				}
			}//root 노드 구하기ㅇㅇ
			
			find = false;
			result = root;
		
			StringTokenizer st2= new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			back(root,a,b);
			
			System.out.println(result);
		}
	}
	
	public static boolean[] back(int x , int a , int b){
		
		boolean [] isF = new boolean[2];  
		
		if(find) return isF;
		
		for(int next : tree[x]) {
			boolean[] isF2 = back(next,a,b);
			
			if(find) return isF;
			
			if(isF2[0]) {
				isF[0] = true;
			}
			if(isF2[1]) {
				isF[1]  = true;
			}
			
			if(isF[0] && isF[1]) {
				result = x;
				find = true;
				return isF;
			}
			
			
		}
		
		
		
		
		if(x==a) {
			isF[0]=true;
		}else if(x==b) {
			isF[1]=true;
		}
		
		
		if(isF[0] && isF[1]) {
			result = x;
			find = true;
		}
		return isF;
	}
	
}
