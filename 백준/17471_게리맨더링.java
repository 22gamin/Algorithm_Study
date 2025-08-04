package test;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int n;
	static int[] value;
	static int min = Integer.MAX_VALUE;
	
	static ArrayList<Integer> comb;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n =  Integer.parseInt(br.readLine());
		value = new int[n+1];
		graph = new ArrayList<>();
		for(int i =0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		StringTokenizer st = new StringTokenizer (br.readLine());
		
		for(int i = 1; i <=n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i =1; i <=n; i++) {
			StringTokenizer st2 = new StringTokenizer (br.readLine());
			int j = Integer.parseInt(st2.nextToken());
			for(int k =0; k<j; k++) {
				int x = Integer.parseInt(st2.nextToken());
				graph.get(i).add(x);
				
			}
		}
		
		
		
		for(int i = 1; i <=n/2; i++) {
			comb = new ArrayList<>();
			combi(1,0,i);
			
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
		
		
		
	}

	
	public static void combi(int start,int d, int limit ) { //limit 크기의 조합을 뽑는 함수
		if(d==limit) {
			check();
			 return;
		}
		for(int i =start; i<=n; i++) { //스타트 부터 시작해서
			comb.add(i);
			combi(i+1,d+1,limit); //현재 인덱스에 +1을 재귀호출 해주는게 조합 뽑기의 기본
			comb.remove(comb.size() - 1);
		}
	}
	
	
	
	

	public static void check() { //각 선거구들 (선거구1 : 조합으로 뽑힌 번호(지역)들 , 선거구 2 : 조합 이외의 번호(지역)들)이 연결이 잘되어있는지 확인 하는 함수
		int size = comb.size();
		int[] visited = new int[n+1];
		for(int x : comb) {
			visited[x] = 1;
		}
		Queue <Integer> q= new LinkedList<>();
		int sum = 0;
		int count = 0;
		
		q.add(comb.get(0));
		
		while(!q.isEmpty()) { //조합으로 뽑힌 번호들이 연결되어있는지 bfs탐색 (선거구 1)
			int x= q.poll();
			visited[x] =0;
			sum += value[x];
			count ++;
			for(int nx : graph.get(x)) {
				if(visited[nx]==1) {
					q.add(nx);
					visited[nx] =0;
				}
			}
		}
		
		if (count!=size) return;
		
		
		
		
		
		q = new LinkedList<>(); //조합으로 뽑힌 번호들 이외의 번호들이 연결되어있는지 bfs탐색 (선거구 2)
		visited = new int[n+1];
		for(int x : comb) {
			visited[x] = 1;
		}
		int sum2 = 0;
		count = 0;
		int start = 0;
		for(int i=1;i<=n; i++) {
			if(visited[i]!=1) {
				start =i;
				break;
			}
		}
		if (start == 0) return; 
		q.add(start);
		while(!q.isEmpty()) {
			int x= q.poll();
			visited[x] =1;
			sum2 += value[x];
			count ++;
			for(int nx : graph.get(x)) {
				if(visited[nx]==0) {
					q.add(nx);
					visited[nx] =1;
				}
			}
		}
		if (count!=n-size) return;
		
		
		min= Math.min(min,Math.abs(sum-sum2));
		
		
		
		
	}
	
}
