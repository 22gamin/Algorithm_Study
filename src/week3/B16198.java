import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] removed;
	static int max=0;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n=sc.nextInt();
		arr=new int[n];
		removed = new boolean[n];
		 
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		dfs(0,0);
		System.out.println(max);
	}
	
	static void dfs(int count, int energy) {
		if(count==n-2) {
			max=Math.max(max, energy);
			return;
		}
		
		for(int i=1;i<n-1;i++) {
			if(removed[i]) continue;
			
			removed[i]=true;
			
			int left=i-1;
			int right=i+1;
			
			// 왼쪽 살아있는 구슬 찾기
			while(left>=0 && removed[left]) {
				left--;
			}
			
			while(right<n && removed[right]) {
				right++;
			}
			
			int gain = arr[left] * arr[right];
			dfs(count+1,energy+gain);
			
			removed[i]=false; // 백트래킹 복구
		}
	}

}