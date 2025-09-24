
import java.util.*;
class UserSolution
{
	static int [][] map;
	static Map<String,Integer> pattern;
	static int n;
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {1,-1,0,0};
	
	public void init(int N, int mMap[][])
	{
		n = N;
		map = mMap;
		pattern = new HashMap<>();
		
		for(int i = 1; i<5; i++) { // 2칸 3칸 4칸 5칸 의 길이
			for(int x = 0; x<n; x++) {
				for(int y=0; y<n; y++) {
					if(x+i<n) { //세로
						int max =0;
						for(int j =x; j<=x+i; j++) {
							max = Math.max(max,map[j][y]); 
						}
						StringBuilder sb = new StringBuilder();
						for(int j =x; j<=x+i; j++) {
							sb.append(String.valueOf(max-map[j][y]));
						}
						if(pattern.get(sb.toString())==null) {
							pattern.put(sb.toString(),1);
						}else {
							pattern.put(sb.toString(),pattern.get(sb.toString())+1);
						}
					}
					
					if(y+i<n) { //가로
						int max =0;
						for(int j =y; j<=y+i; j++) {
							max = Math.max(max,map[x][j]); 
						}
						StringBuilder sb = new StringBuilder();
						for(int j =y; j<=y+i; j++) {
							sb.append(String.valueOf(max-map[x][j]));
						}
						if(pattern.get(sb.toString())==null) {
							pattern.put(sb.toString(),1);
						}else {
							pattern.put(sb.toString(),pattern.get(sb.toString())+1);
						}
					}
				}
			}
		}
	}

	
	public int numberOfCandidate(int M, int mStructure[])
	{	if (M == 1) {
			return n * n;
    	}
		int [] s1 = new int[M];
		int [] s2 = new int[M];
		int min = 999;
		for(int i =0; i<M; i++) {
			min = Math.min(min,mStructure[i]);
			s1[i] = mStructure[i];
			s2[(M-1)-i] = mStructure[i]; //뒤집은거
		}
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			sb.append(String.valueOf(s1[i]-min));
			sb2.append(String.valueOf(s2[i]-min));
		}
		
		int count1 = pattern.getOrDefault(sb.toString(), 0); //널포인트익셉션 방지
		if(sb.toString().equals(sb2.toString())) { //패턴 뒤집은게 같은경우
			return count1;
		}
		int count2 = pattern.getOrDefault(sb2.toString(), 0);
		int result = count1 + count2;
		
		return result;
	}
	static int bfs(int level) {
		int count = 0;
		int [][]visited = new int[n][n];
		Queue<int []> q = new LinkedList<>();
		
		
		
		
		for(int i=0;i<n;i++) {
			if(map[0][i]<level && visited[0][i]==0) {
				visited[0][i]=1;
				q.offer(new int[] {0,i});
				count++;
			}
			if(map[i][0]<level&& visited[i][0]==0) {
				visited[i][0]=1;
				q.offer(new int[] {i,0});
				count++;
			}
			if(map[n-1][i]<level&& visited[n-1][i]==0) {
				visited[n-1][i]=1;
				q.offer(new int[] {n-1,i});
				count++;
			}
			if(map[i][n-1]<level&& visited[i][n-1]==0) {
				visited[i][n-1]=1;
				q.offer(new int[] {i,n-1});
				count++;
			}
			
		}
		
		
		while(!q.isEmpty()) {
			int [] xy = q.poll();
			int x = xy[0];
			int y = xy[1];
			
			for(int i =0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(visited[nx][ny]==0 && map[nx][ny]<level) {
						visited[nx][ny] =1;
						count++;
						q.offer(new int[] {nx,ny});
					}
				}
			}
		}
		
		int result = n*n-count;
		
		
		return result;
	}
	
	public int maxArea(int M, int mStructure[], int mSeaLevel)
	{
		int [] s1 = new int[M];
		int [] s2 = new int[M];
		int max = -1;
		for(int i =0; i<M; i++) {
			s1[i] = mStructure[i];
			s2[(M-1)-i] = mStructure[i]; //뒤집은거
		}
		
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				if(x+M-1<n) {
					boolean isV = true;
					
					for(int i = 1; i<M; i++) {
						if(map[x+i-1][y]+s1[i-1]!=map[x+i][y]+s1[i]) {
							isV=false;
							break;
						}			
					}
					
					if(isV) {
						for(int i = 0; i<M; i++) {
							map[x+i][y] += s1[i];
						}
						max = Math.max(bfs(mSeaLevel),max);
						for(int i = 0; i<M; i++) {
							map[x+i][y] -= s1[i];
						}
						
					}
					
					
					isV = true;
					
					for(int i = 1; i<M; i++) {
						if(map[x+i-1][y]+s2[i-1]!=map[x+i][y]+s2[i]) {
							isV=false;
							break;
						}			
					}
					
					if(isV) {
						for(int i = 0; i<M; i++) {
							map[x+i][y] += s2[i];
						}
						max = Math.max(bfs(mSeaLevel),max);
						for(int i = 0; i<M; i++) {
							map[x+i][y] -= s2[i];
						}
					}
				}
				
				if(y+M-1<n) {
					boolean isV = true;
					
					for(int i = 1; i<M; i++) {
						if(map[x][y+i-1]+s1[i-1]!=map[x][y+i]+s1[i]) {
							isV=false;
							break;
						}			
					}
					
					if(isV) {
						for(int i = 0; i<M; i++) {
							map[x][y+i] += s1[i];
						}
						max = Math.max(bfs(mSeaLevel),max);
						for(int i = 0; i<M; i++) {
							map[x][y+i] -= s1[i];
						}
					}
					
					
					isV = true;
					
					for(int i = 1; i<M; i++) {
						if(map[x][y+i-1]+s2[i-1]!=map[x][y+i]+s2[i]) {
							isV=false;
							break;
						}			
					}
					
					if(isV) {
						for(int i = 0; i<M; i++) {
							map[x][y+i] += s2[i];
						}
						max = Math.max(bfs(mSeaLevel),max);
						for(int i = 0; i<M; i++) {
							map[x][y+i] -= s2[i];
						}
					}
				}
			}
		}
		
		
		
		
		
		return max;
	}
}
