package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14716 {
	static int[][] arr;
	static int m,n;
	
	// 8방향 이동 (상, 하, 좌, 우, 대각선)
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		// 배열 받기
		arr = new int[m][n];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					dfs(i, j);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(int x , int y) {
		arr[x][y]=0;
		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			// 범위 체크
			if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
				if (arr[nx][ny] == 1) {
					arr[nx][ny]=0;
					dfs(nx, ny);
				}
			}
		}
	}

}
