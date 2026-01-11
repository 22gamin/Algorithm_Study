import java.util.*;
import java.io.*;

public class Main {
	static int w,h;
	static int[][][] mCount;
	static char[][] map;
	static int[] dx = new int [] {0 , 0 , 1, -1}; //동 서 남 북
	static int[] dy = new int [] {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new char [h][w];
		
		
		int [] start = new int[2];
		int [] end = new int[2];
		int cCount =0;
		for(int i =0; i<h; i++) {
			String a = br.readLine();
			
			for(int j = 0; j<w; j++) {
				map[i][j]=a.charAt(j);
				if(map[i][j] == 'C') {
					if (cCount ==0) {
						cCount++;
						start[0] = i;
						start[1] = j;
					}else {
						end[0] = i;
						end[1] = j;
					}
				}
			}
			
			
		}
		
		mCount = new int[h][w][4];
		for(int i =0; i<h; i++){
            for(int j =0; j<w; j++){
                for(int k=0; k<4; k++){
                     mCount[i][j][k] = Integer.MAX_VALUE;
                }
               
            }
        }
		
		PriorityQueue<int []> pq = new PriorityQueue<> (
				(a,b)->{
					return a[3]-b[3];
				}		
		);
		
		boolean isFind = false;
		
		for(int i=0; i<4; i++) { 
			int cx = start[0];
			int cy = start[1];
			
			int nx = cx+dx[i];
			int ny  =cy+dy[i];
			
			if(nx==end[0] && ny ==end[1]) {
				isFind = true;
				mCount[nx][ny][i]=0;
				break;
			}
			
			if(0<=nx && 0<=ny && nx<h && ny<w) {
				if(map[nx][ny]!='*') {
					pq.offer(new int[] {nx,ny,i,0});
					mCount[nx][ny][i] = 0;
				}
			}
	
		}
		
		if(!isFind) {
			while(!pq.isEmpty()) {
				int [] c = pq.poll();
				
				int cx = c[0];
				int cy = c[1];
				int cw = c[2];
				int cm = c[3];
				
				if(cm>mCount[cx][cy][cw]) continue;
				
				for(int i=0; i<4; i++) { 
					int nx = cx+dx[i];
					int ny  =cy+dy[i];
					
					if(0<=nx && 0<=ny && nx<h && ny<w) {
						if(map[nx][ny]!='*') {
							if(i==cw) {//거울 설치 안함
								int nm = cm;
								
								if(nm<mCount[nx][ny][i]) {
									
									mCount[nx][ny][i]=nm;
									pq.offer(new int[] {nx,ny,i,nm});
								}
							}else {//거울 설치 함
								int nm = cm+1;
								
								if(nm<mCount[nx][ny][i]) {
									mCount[nx][ny][i]=nm;
									pq.offer(new int[] {nx,ny,i,nm});
								}
							}
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
            
            for(int i =0; i<4; i++){
                min = Math.min(min,mCount[end[0]][end[1]][i]);
               
            }
			
			 System.out.println(min);
			
			
			
		
		}
		
			
	}
		
		
}

