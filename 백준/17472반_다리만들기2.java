import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [][] map;
    static int [][] visit;
    static int [] visit2;
 
    static ArrayList <int []> edge;
    static int result;
    static int [] dx  = new int[] {1,-1,0,0};
    static int [] dy = new int[] {0,0,-1,1};
    static int [] p;
    static Boolean isV;
    public static void main(String[] args)throws IOException {
    	
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i =0; i<n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int islandNum = 0;
        visit = new int[n][m];
        
   
        
        
        
        
        for(int i =0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==1&&visit[i][j]==0) {
                	islandNum++;
                    bfs(i,j,islandNum);
                     //bfs가 끝나고나서 여기서 islandNum을 바로 올리고 있었다 이러면 마지막에 섬개수가 4라도 5로끝나게됨 그래서 다르게하자
                }

            }
        } 
        
      
        
        edge = new ArrayList<>();
        p = new int[islandNum+1];
        
        for(int i=0; i<=islandNum; i++) {
        	p[i]=i;
        }
        visit2 = new int[islandNum+1];
        
        
        for(int i =0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(map[i][j]!=0) {
        			for(int k=0; k<4; k++) {
        				addEd(i,j,map[i][j],k);
        			}
        		}
        	}
        }
        result = 0;
        Collections.sort(edge , (a,b)->{return a[2]-b[2];});
        
        int eC = 0;
        for(int[] a:edge) {
        	if(eC>=islandNum-1) break;
        	int from = a[0];
        	int to = a[1];
        	int w = a[2];
        	
        	
        	if(find(from)!=find(to)) {
        		union(from, to);
        		result+=w;
        		eC++;
        	}
        	
        }
        
        
        isV = true;
 
    	
    	if(eC ==islandNum-1) {
    		System.out.println(result);
    	}else {
    		System.out.println(-1);
    	}
    }
    
    
    static int find(int x) {
    	int rootX = p[x];
    	if(rootX != x) { //rootX != p[x]로 실수함 당연히 같은데
    		p[x] = find(rootX);
    	}
    	
    	return p[x];
    }
    
   static void union(int x, int y) {
	   int rootX = find(x) ; 
	   int rootY = find(y);
       p[rootY] = rootX; 
   
   }
    
    

    static void addEd(int x, int y, int start,int w) {
    	
    	int count = 0;
    	while(true) {
    		x= x + dx[w];
        	y= y + dy[w];
        	
        	
        	if(x>=0 && x<n && y>=0 && y <m) {
        		int next = map[x][y];
        		
        		if(next ==0) {
        			count++;
        			continue;
        			
        		}else if(next == start){
        			break;
        		}else {
        			if(count>1) {
        				edge.add(new int [] {start,next,count});
        			}  		
        			break; //이거 for문에 넣덧다가 실수함
        		}
        	}
        	else {
        		break;
        	}
    	}
    	
    }
    
    
    
    
    
    
    
    
    public static void bfs(int x, int y,int islandNum) {
        visit[x][y] = 1;
        map[x][y] = islandNum;
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {x,y} );

        while(!q.isEmpty()) {
            int [] p = q.poll();
            x = p[0];
            y = p[1];
            map[x][y] = islandNum;
            for(int i =0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m) {
                    if(visit[nx][ny] == 0 && map[nx][ny]==1) {
                        visit[nx][ny]=1;
                        q.offer(new int[] {nx,ny});
                    }
                }
            }
        }

    }


}
