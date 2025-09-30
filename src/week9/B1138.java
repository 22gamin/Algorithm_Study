package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1138 {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] line=new int[N];
		
		for(int i=0;i<N;i++) {
			int count=arr[i];
			for(int j=0;j<N;j++) {
				if(line[j]==0) {
					if(count==0) {
						line[j]=i+1;
						break;
					}
					count--;
				}
			}
		}
		for(int x : line) {
			System.out.print(x + " ");
		}
	}
}
