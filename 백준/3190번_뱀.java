import java.io.*;
import java.util.*;

public class Main {
	static int n, k ,l;
 	static int [][] map;
 	static int [] dx = new int[] {0,1,-1,0};
 	static int [] dy = new int[] {1,0,0,-1}; // 오른쪽 아래 위 왼쪽
	public static void main(String[] args)throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		n = Integer.parseInt(br.readLine());
 		k = Integer.parseInt(br.readLine());
 		map= new int[n][n];
 		
 		for(int i=0; i<k; i++) {
 			StringTokenizer st = new StringTokenizer(br.readLine());
 			
 			int x = Integer.parseInt(st.nextToken())-1;
 			int y = Integer.parseInt(st.nextToken())-1;
 			
 			map[x][y] = 2; // 사과는 2
 		}
 		
 		l = Integer.parseInt(br.readLine());
 		
 		String[][] turn = new String[l][2];
 		
 		for(int i =0; i<l; i++) {
 			StringTokenizer st2 = new StringTokenizer(br.readLine());
 			turn[i][0]= st2.nextToken();
 			turn[i][1]= st2.nextToken();
 		}
 		
 		
 		
 		
 		Deque<int[]> dq = new LinkedList<>();
 		
 		
 		dq.add(new int[] {0,0});
 		map[0][0] =1;
 		int sec = 0;
 		int tI = 0;
 		int way = 0; // 기본이 오른쪽
 		
 		while(true) {
 			
 			
 			if(tI<l) {
 				int isTurn = Integer.parseInt(turn[tI][0]);
 	 			char turnWay = turn[tI][1].charAt(0);
 	 			
 	 			if(sec == isTurn ) { // 회전시키면
 	 				if(turnWay == 'L') { //좌회전
 	 					if(way ==0) { //오른쪽 
 	 						way = 2;
 	 					}else if(way ==1) { //아래
 	 						way = 0;
 	 					}else if(way ==2) { //위
 	 						way = 3;
 	 					}else if(way==3) { //왼쪽
 	 						way =1;
 	 					}
 	 				}else if(turnWay == 'D') {//우회전
 	 					if(way ==0) { //오른쪽 
 	 						way =1;
 	 					}else if(way ==1) { //아래
 	 						way =3;
 	 					}else if(way ==2) { //위
 	 						way = 0;
 	 					}else if(way==3) { //왼쪽
 	 						way =2;
 	 					}
 	 					
 	 				}
 	 				tI++;
 	 			}
 			}
 			
 			
 			
 			
 			
 			int nx = dq.peekFirst()[0] + dx[way];
 			int ny = dq.peekFirst()[1]+ dy[way];
 			sec++;
 			
 			if(nx<0 || nx >=n || ny<0 || ny >=n) {
 				break;
 			} //맵밖으로 나가는 경우

 			if(map[nx][ny]==2) { // 사과면
 				map[nx][ny] = 1;
 				dq.addFirst(new int[] {nx,ny}); //꼬리그대로
 			}else if(map[nx][ny]==1) {
 				break; // 자기 몸통과 충돌
 			}else {
 				map[nx][ny] = 1;
 				dq.addFirst(new int[] {nx,ny});
 				int [] last = dq.pollLast();
 				map[last[0]][last[1]] = 0;
 				
 				//사과가 없으면 자기 꼬리 땡겨오기
 			}
 			

 			
 		}
 		
 		System.out.println(sec);
 		
		
 	}
	
		
 	
 	
 	
 	
		
}
