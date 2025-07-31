// 7/30 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B16927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][]matrix = new int[n][m];
		
		for(int i=0; i<n; i++) {		
			StringTokenizer s = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {				
				matrix[i][j] = Integer.parseInt(s.nextToken());				
			}
		}		
		int t = Math.min(n,m)/2;
		
		// 돌아가는 줄끼리 넣기 
		for (int i =0; i < t; i++) { 
						List<Integer> list = new ArrayList<>();  
						// 반시계 
						// 상단
            for (int j=i; j < m-i; j++) {            	
            	list.add(matrix[i][j]);
            }
            // 우측
            for (int j= i+1; j< n-i; j++) {            	
            	list.add(matrix[j][m -i -1]);
            }
            // 하단
            for (int j=(m-i-2); j >=i; j--) {
            	list.add(matrix[n-i-1][j]);            	
            }            
            // 좌측
            for (int j=(n-i-2); j >i; j--) {            	
            	list.add(matrix[j][i]);
            } 
            
            int size=list.size();
            int rot= r%size;
            
            int idx=0;
            
            // 상단
            for (int j=i; j < m-i; j++) {            	
            	matrix[i][j] =list.get((idx++ +rot) % size);
            }
            // 우측
            for (int j= i+1; j< n-i; j++) {            	
            	matrix[j][m -i-1] =list.get((idx++ +rot) % size);
            }
            // 하단
            for (int j=(m-i-2); j >=i; j--) {
            	matrix[n -i - 1][j] =list.get((idx++ + rot) % size);            	
            }            
            // 좌측
            for (int j=(n-i-2); j >i; j--) {            	
            	matrix[j][i] =list.get((idx++ + rot) % size);
            }            
		}
		for(int i=0; i<n; i++) {
			for(int j=0;j<m; j++) {
				bw.write(matrix[i][j]+" ");
			}
			bw.write('\n');
		}
		bw.flush();
		bw.close();
	}
}
