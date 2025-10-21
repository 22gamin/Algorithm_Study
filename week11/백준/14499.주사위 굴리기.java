import java.io.*;
import java.util.*;

public class Main {
	static int n, m ,x, y ,k;
	static int [][] map;
	static int [] query;
	static int [] dice;
	static int [] temp;
	
	public static void main(String[] args)throws IOException {
	
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		dice = new int[6];
		temp = new int[6];
		query = new int[k];
		map = new int[n][m];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j =0; j<m; j++) {
				map[i][j]=Integer.parseInt(st2.nextToken());
			}
		}
		
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			query[i] = Integer.parseInt(st3.nextToken());
		}
		
		for(int i=0; i<k; i++) {
			
			
			
			
			for(int j=0; j<6; j++) {
				temp[j] = dice[j];
			} //여러개를 스왑할거라 저장해놓자
			
			
			if(query[i]==1) { //동
				if(y+1>=m) continue;
				y++;
				dice[1] = temp[4];
				dice[3]= temp[5];
				dice[5] = temp[1];
				dice[4]  =temp[3];
			}
			else if(query[i]==2) { //서
				if(y-1<0) continue;
				y--;
				dice[1]=temp[5];
				dice[3]= temp[4];
				dice[5] = temp[3];
				dice[4] = temp[1];
			}
			else if(query[i]==4) { //남
				if(x+1>=n) continue;
				x++;
				dice[0] = temp[3];
				dice[1] = temp[0];
				dice[2] = temp[1];
				dice[3] = temp[2];
				
  			}
			else if(query[i]==3) { //북
				if(x-1<0) continue;
				x--;
				dice[3] = temp[0];
				dice[2] = temp[3];
				dice[1] = temp[2];
				dice[0] = temp[1];
				
			}	
			
			if(map[x][y] == 0) {
				map[x][y] = dice[3];
			}else {
				dice[3] = map[x][y];
				map[x][y] =0;
			} 
			sb.append(dice[1]).append("\n");
		}
		
		
		System.out.print(sb.toString().trim());
		
	
	}

	
}
