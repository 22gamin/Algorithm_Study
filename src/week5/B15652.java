package week1;

import java.util.Scanner;

public class B15652 {
	static int n,m;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		result=new int[m];
		
		perm(0,1);

	}
	static void perm(int cnt,int start) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=n;i++) {
			result[cnt]=i;
			perm(cnt+1,i);
		}
	}
}
