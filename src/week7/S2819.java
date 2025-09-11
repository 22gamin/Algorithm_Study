package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class S2819 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr;
	static Set<String> li;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test=1; test<=t; test++) {
			arr = new int[4][4];
			for(int i =0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			li = new HashSet<>();
			for(int i =0; i<4; i++) {
				for(int j=0; j<4; j++) {
					String str= Integer.toString(arr[i][j]);
					dfs(i,j,str);
				}
			}
			System.out.println("#"+test+" "+li.size());
		}
	}
	public static void dfs(int a, int b, String str) {
		if(str.length() == 7) {
			li.add(str);
			return;
		}		
		
		for(int d=0; d<4; d++) {
			int nx = a + dx[d];
			int ny = b + dy[d];
			if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;
			String c = Integer.toString(arr[nx][ny]);
			String tmp = str+c;
			dfs(nx, ny, tmp);
		}
	}
}
