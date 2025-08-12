
import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int[][] map;
	static ArrayList<int [] > start;
	static int[] black;
	static int max;
	static int[] dx = new int[] {0,0,-1,1}; // 우0, 좌1, 상2, 하3 
	static int[] dy = new int[] {1,-1,0,0};
	static ArrayList<ArrayList<int[]>> worm;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1;  tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			start= new ArrayList<>();
			black = new int[2];
			worm = new ArrayList<>();
			for(int i =0; i<=10; i++) {
				worm.add( new ArrayList<>());
			}
			
			for(int i = 0 ; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j =0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==0) {
						start.add (new int[] {i,j});
					}else if(map[i][j]==-1) {
						black[0]=i;
						black[1]=j;
					}else if(map[i][j]>=6 && map[i][j]<=10) {
						worm.get(map[i][j]).add(new int[] {i,j});
					}
						
					
					
					
				}
			}
			int startIndex = 0;
			max = 0;
			for(int [] arr : start) {
				int x = arr[0];
				int y = arr[1];
				for(int i = 0; i<4; i++) {
					play(x,y,i,x,y);
				}
			
				
			}
			
			
			System.out.println("#"+tc+" "+max);
			
			
			
			
			
		}
	}
	
	
	public static void play(int x, int y,int w,int startX , int startY) { 
		
		int score = 0;
		while(true) {
			int nx = x+dx[w];
			int ny = y+dy[w];
			
			
			if(nx<0 || nx>=n || ny<0 || ny>=n) {
				if(w==0) { //우
					w=1;
				}else if(w==1) { //좌
					w=0;
				}else if(w==2) { //상
					w=3;
				}else if(w==3) { //하
					w=2;
				}
				score++;
				x=nx;
				y=ny;
				continue;
			}else {
				if(map[nx][ny]==-1) {
					break;
				}
					
				if(map[nx][ny]<=5 && map[nx][ny]>=1) {
					if(map[nx][ny]==1) {
						if(w==0) { //우
							w=1;
						}else if(w==1) { //좌
							w=2;
						}else if(w==2) { //상
							w=3;
						}else if(w==3) { //하
							w=0;
						}
						x=nx;
						y=ny;
						score++;
					}else if(map[nx][ny]==2) {
						if(w==0) { //우
							w=1;
						}else if(w==1) { //좌
							w=3;
						}else if(w==2) { //상
							w=0;
						}else if(w==3) { //하
							w=2;
						}
						x=nx;
						y=ny;
						score++;
					}else if(map[nx][ny]==3) {
						if(w==0) { //우
							w=3;
						}else if(w==1) { //좌
							w=0;
						}else if(w==2) { //상
							w=1;
						}else if(w==3) { //하
							w=2;
						}
						x=nx;
						y=ny;
						score++;
					}else if(map[nx][ny]==4) {
						if(w==0) { //우
							w=2;
						}else if(w==1) { //좌
							w=0;
						}else if(w==2) { //상
							w=3;
						}else if(w==3) { //하
							w=1;
						}
						x=nx;
						y=ny;
						score++;
					}else if(map[nx][ny]==5) {
						if(w==0) { //우
							w=1;
						}else if(w==1) { //좌
							w=0;
						}else if(w==2) { //상
							w=3;
						}else if(w==3) { //하
							w=2;
						}
						x=nx;
						y=ny;
						score++;
					}
				}else if(map[nx][ny]==0) {
					if(nx==startX && ny==startY) {
						break;
					}
					x=nx;
					y=ny;
				}else {
					for(int[] t : worm.get(map[nx][ny])) {
						if(t[0] != nx || t[1]!=ny) {
							x = t[0];
							y = t[1];
							break;
						}
					}
				}
				
			}
		}
		
		max = Math.max(max,score);
	}
	
	
		
}
