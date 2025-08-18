import java.io.*;
import java.util.*;

public class Main {
    static int n , m;
    static int [][] map;
    static ArrayList<int[]> al;
    static int empty;
    static int min;
    static int[] visit1;
    static int[][] visit2;
    static int [] dx = new int[] {0,0,-1,1};
    static int [] dy = new int[] {1,-1,0,0};
    public static void main(String[] args)throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	min = Integer.MAX_VALUE;
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m= Integer.parseInt(st.nextToken());
    	empty = 0 ; 
    	map = new int [n][n];
    	visit2 = new int[n][n];
    	al = new ArrayList<>();
    	for(int i =0; i<n; i++) {
    		StringTokenizer st2 = new StringTokenizer(br.readLine());
    		for(int j=0; j<n; j++) {
    			map[i][j] = Integer.parseInt(st2.nextToken());
    			if(map[i][j]==2) {
    				al.add(new int[] {i,j});
    			}else if(map[i][j]==0) {
    				empty++;
    			}
    		}
    	}
    	
    	visit1 = new int[al.size()];
    	
    	
    	for(int i =0; i<al.size(); i++) {
    		comb(i,1);
    	}
    	if(min == Integer.MAX_VALUE) {
    		min = -1;
    	}
    	
    	System.out.println(min);
    	
    	
    }
    	
    public static void comb(int start, int depth) {
    	visit1[start] =1;
    	if(depth == m)  {
    		bfs();
    		visit1[start] = 0;
    		return;
    	}
    	for(int i =start+1; i<al.size(); i++) {
    		comb(i,depth+1);
    	}
    	
    	visit1[start] = 0;
    	
    }
    
    
    public static void bfs() {
    	int lastTime = 0;
    	int count = 0;
    	visit2 = new int[n][n];
    	Queue<int[]> q = new LinkedList<>();
    	for(int i =0; i<al.size(); i++) {
    		if (visit1[i]==1) {
    			int x = al.get(i)[0];
    			int y = al.get(i)[1];
    			q.offer(new int[] {x,y,0});
    			visit2[x][y]=1;
    		}
    			
    	}
    	while(!q.isEmpty()) {
    		int [] a = q.poll();
    		int x = a[0];
    		int y = a[1];
    		int time = a[2];
    		
    		for(int i = 0 ; i <4; i++) {
    			int nx = x +dx[i];
    			int ny = y +dy[i];
    			
    			if(nx >=0 && nx <n && ny>=0 && ny<n) {
    				if(visit2[nx][ny]==0 && map[nx][ny]!=1 ) {
    					visit2[nx][ny] =1;
    					
    					 
                        if(map[nx][ny]==0){
                            count++;
                        }    
    	                q.offer(new int[] {nx,ny,time+1});
    					
    						
    					
    					
    				}
    				
    			}
    		}
    		
    		if(map[x][y]==0){
    		    lastTime = Math.max(lastTime, time);
    		}
    		
    	}
    	
    	  if(count == empty) {
    	        min = Math.min(lastTime,min);
    	    }
    
    }
    
    
    
    
    
    
    
    


}
