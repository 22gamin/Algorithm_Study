package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1325 {

	static int n,m,count;
	static List<Integer>[] list;
	static boolean visited[];
	static int[] result;
	
	static void DFS(int start) {
		visited[start]=true;
		for(int next : list[start]) {
			if(!visited[next]) {
				count++; 
				DFS(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		list=new ArrayList[n+1];
		result=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[b].add(a); // B해킹 -> A해킹
		}
		
		int max=0;
		for(int i=1;i<=n;i++) {
			visited=new boolean[n+1];
			count=0;
			DFS(i);
			result[i]=count;
			max=Math.max(max, result[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (result[i] == max) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);

	}

}
