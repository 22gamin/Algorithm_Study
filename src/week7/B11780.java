package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B11780 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int INF = Integer.MAX_VALUE;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] d = new int[n+1][n+1];
		int[][] dist = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			Arrays.fill(d[i], INF);
		}		
		for(int i =1; i<=m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			d[a][b] = Math.min(d[a][b], c);
			//d[a][b] = c;
			dist[a][b] = b;
		}
		for(int i=1; i<=n; i++) d[i][i] = 0;
		
		for(int k = 1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(d[i][k]!= INF && d[k][j]!=INF) {
						if(d[i][j]>d[i][k] + d[k][j]) {
							d[i][j] = (d[i][k] + d[k][j]);
							dist[i][j] = dist[i][k];
						}						
					}
				}
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(d[i][j] == INF) System.out.print(0+" ");
				else System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				// 0 이면 0
				if(i == j || d[i][j] == INF) System.out.print(0+" ");
				// 0 아니면 i, 경유도시, j 출력
				else {
					List<Integer> li = new ArrayList<>();
					li.add(i);
					int tmp = i;
					while(true) {
						li.add(tmp);
						tmp = dist[tmp][j];
						
						if(tmp == j) break;							
					}
					System.out.print(li.size()+" ");
					for(int c : li) {
						System.out.print(c+" ");
					}
				}
				System.out.println();
			}
		}		
	}
}
