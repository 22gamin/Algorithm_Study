package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15649 {
	
	static int n,m;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		numbers=new int[m];
		isSelected=new boolean[n+1];
		
		perm(0);
	}
	
	public static void perm(int cnt) {
		if(cnt==m) {
			for (int i = 0; i < m; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();			
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(isSelected[i])
				continue;
			numbers[cnt]=i;
			isSelected[i]=true;
			perm(cnt+1);
			isSelected[i]=false;
		}
	}


}
