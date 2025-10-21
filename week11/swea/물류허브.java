import java.util.*;

class UserSolution {
	static ArrayList<int[]> [] graph;
	static ArrayList<int[]> [] rGraph;
	static int id;
	static HashMap<Integer,Integer> nodeMap;
	static int nodeCount;
	static int[] dist =new int[600];
	static int[][] temp = new int[2500][2]; //다익스트라 pq 정적할당 인자
	
	
	@SuppressWarnings("unchecked")
	public int init(int N, int sCity[], int eCity[], int mCost[]) {
		graph = new ArrayList[600];
		rGraph = new ArrayList[600];
		nodeMap = new HashMap<>();
		id = 0;
		
		for(int i =0; i<600; i++) {
			graph[i] = new ArrayList<>();
			rGraph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<N; i++) {
			int start = sCity[i];
			int end = eCity[i];
			int sId = 0;
			int eId= 0;
			
			if(nodeMap.containsKey(start)) {
				sId = nodeMap.get(start);
			}else {
				sId = id;
				nodeMap.put(start,id);
				id++;
			}
			
			if(nodeMap.containsKey(end)) {
				eId = nodeMap.get(end);
			}else {
				eId = id;
				nodeMap.put(end,id);
				id++;
			}	
			graph[sId].add(new int[] {eId,mCost[i]});
			rGraph[eId].add(new int[] {sId,mCost[i]});
		}
		
		nodeCount = id;
		
		return nodeCount;	
	}

	public void add(int sCity, int eCity, int mCost) {
		int sId = nodeMap.get(sCity);
		int eId= nodeMap.get(eCity);
			
		graph[sId].add(new int[] {eId,mCost});
		rGraph[eId].add(new int[] {sId,mCost});
		return;
	}

	public int cost(int mHub) {
		int result = 0;
		mHub = nodeMap.get(mHub);
		
		
		int tI = 0;
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue <int []> pq =  new PriorityQueue<>(
			(a,b)->{
				return a[1] - b[1];
			}
		);
		
		temp[tI][0] = mHub;
		temp[tI][1] = 0;
		
		pq.offer(temp[tI++]);
		
		while(!pq.isEmpty()) {
			int [] now = pq.poll();
			int x = now[0];
			int c = now[1];
			
			if(dist[x]<=c) continue;
			
			dist[x] = c;
			result +=c;
			
			for(int[] t : graph[x]) {
				int nx = t[0];
				int nc=  c + t[1];
				
				if(dist[nx]>nc) {
					temp[tI][0] = nx;
					temp[tI][1] = nc;
					
					pq.offer(temp[tI++]);
				}
			}
 		}
		
		
		tI = 0;
		Arrays.fill(dist, Integer.MAX_VALUE);
			
		temp[tI][0] = mHub;
		temp[tI][1] = 0;
		
		pq.offer(temp[tI++]);
		
		while(!pq.isEmpty()) {
			int [] now = pq.poll();
			int x = now[0];
			int c = now[1];
			
			if(dist[x]<=c) continue;
			
			dist[x] = c;
			result +=c;
			
			for(int[] t : rGraph[x]) {
				int nx = t[0];
				int nc=  c + t[1];
				
				if(dist[nx]>nc) {
					temp[tI][0] = nx;
					temp[tI][1] = nc;
					
					pq.offer(temp[tI++]);
				}
			}
 		}
		
		
		
		return result;
	
	
	}
}
