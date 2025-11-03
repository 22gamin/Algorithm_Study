import java.io.*;
import java.util.*;

public class Main {
	static int n,m,s,d;
	static StringBuilder sb;
	static ArrayList<ArrayList<int []>> graph;
	static int [] dist;
	static int min;
	static Set<Integer>[] prev;
	static int[] visit;
	static Set<Integer>[]minPrev;
	
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			
			if(n==0 && m==0) break;
			
			visit= new int[n];
			prev = new HashSet[n];
			minPrev = new HashSet[n];
			graph = new ArrayList<>();
			
			for(int i = 0; i<n; i++) {
				graph.add(new ArrayList<>());
				prev[i] = new HashSet<>();
				minPrev[i] = new HashSet<>();
			}
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			s =Integer.parseInt(st2.nextToken());
			d = Integer.parseInt(st2.nextToken());
			
			for(int i=0; i<m; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st3.nextToken());
				int v = Integer.parseInt(st3.nextToken());
				int p = Integer.parseInt(st3.nextToken());
				graph.get(u).add(new int[] {v,p}); //{도착지, 비용}
			}
			
			dist = new int[n];
			
			for(int i = 0 ; i<n; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[s] =  0;			
			min = Integer.MAX_VALUE;
			
			PriorityQueue<int []> pq = new PriorityQueue<>(
				(a,b)->{
					return a[1] - b[1];	
				}	
			);
			
			for(int [] x : graph.get(s)) {
				int next = x[0];
				int w  =x[1];
				
				prev[next].add(s);
				dist[next] = w;
				pq.offer(new int[] {next,w,s});
			}
			
			while(!pq.isEmpty()) {
				int [] cur = pq.poll();
				int x = cur[0];
				int w = cur[1];
				int from = cur[2];
				if(dist[x]<w || min<w) {
					continue;
				}
				
				if(w<dist[x]) {
					prev[x].clear();
					prev[x].add(from);
					dist[x] = w;
				}else if(w==dist[x]) {
					dist[x] = w;
					prev[x].add(from);
				}		
					
				
				if(x == d) continue;
				
				
				for(int[] next : graph.get(x)) {
					int nX = next[0];
					int nW = next[1] + w;
					from = x;
					
					if(dist[nX]>=nW) {
						dist[nX] = nW;
						pq.offer(new int[] {nX, nW, from});
					}
				}
				
				
			}
			
			
			
			
			minPrevInit(d);
			
			pq.clear();
			for(int i = 0 ; i<n; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[s] =  0;		
			
			
			

			for(int [] x : graph.get(s)) {
				
				int next = x[0];
				
				int w  =x[1];
				
				if(minPrev[next].contains(s)) continue;
				dist[next] = w;
				pq.offer(new int[] {next,w,s});
			}
			
			while(!pq.isEmpty()) {
				int [] cur = pq.poll();
				int x = cur[0];
				int w = cur[1];
				int from = cur[2];
				if(dist[x]<w) {
					continue;
				}
				
				if(minPrev[x].contains(from)) continue;
				
				if(x == d) break;
				
				for(int[] next : graph.get(x)) {
					int nX = next[0];
					int nW = next[1] + w;			
					if(minPrev[nX].contains(x)) continue;
					if(dist[nX]>=nW) {
						dist[nX] = nW;
						pq.offer(new int[] {nX, nW,x});
					}
				}
			
			}
			
			
			if(dist[d]==Integer.MAX_VALUE) {
				sb.append(-1).append("\n");
			}else {
				sb.append(dist[d]).append("\n");
			}
			
			
		}
		
		System.out.println(sb.toString().trim());
		
		                                                                                                                                                                                                                   
	}
	
	
	
	static void minPrevInit(int x) {
		if(x==s) return;
		
		if(visit[x] == 1) {
	        return; 
	    }
	    
	    visit[x] = 1;
	    
		for(int a : prev[x]) {
			minPrev[x].add(a);
			minPrevInit(a);
		}
	}
	
	
		
	
	
}
