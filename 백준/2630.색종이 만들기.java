import java.util.*;
import java.io.*;

public class Main {
	static int  n;
	static int[][] map;
	static int zero , one;
	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("Test2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		zero = 0;
		one = 0;
		for(int i =0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		partition(0,0,n);
		
		System.out.println(zero);
		System.out.println(one);
	}
	
	
	
	static boolean isUniform(int x, int y, int size,int value) {
		for(int i =x; i<x+size; i++) {
			for(int j =y; j<y+size; j++) {
				if(map[i][j]!=value) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void partition(int x, int y, int size) {
		
		if(isUniform(x,y,size,0)) {
			zero++;
			return;
		}
		if(isUniform(x,y,size,1)) {
			one++;
			return;
		}
		
		size = size/2;
		
		partition(x,y,size);
		partition(x+size,y,size);
		partition(x,y+size,size);
		partition(x+size,y+size,size);
		
		
	}
	
	

}
