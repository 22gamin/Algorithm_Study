
import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args)throws IOException{
   
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m  = Integer.parseInt(st.nextToken());
	    int r = Integer.parseInt(st.nextToken());
	    int [][] arr = new int[n][m];
	    for(int i= 0; i<n; i++) {
	    	StringTokenizer st2 = new StringTokenizer(br.readLine());
	    	for(int j=0; j<m; j++) {
	    		arr[i][j] = Integer.parseInt(st2.nextToken());
	    	}
	    }
	  
	    
	
		
	    int l = Math.min(n,m);
	    	
	    
	    	
	    	for(int i =0; i<l/2; i++) {
	    		int rotate = r%(2*((n-2*i)+(m-2*i))-4);
	    		while (rotate-- > 0) {
	    			int temp = arr[i][i];

	    		 
	    		    for (int j = 1+i; j<n-i; j++) {
	    		        temp = swap(arr, j, i, temp);
	    		    }

	    		   
	    		    for (int j =1+i; j<m-i; j++) {
	    		        temp = swap(arr, n - 1 - i, j, temp);
	    		    }

	    		    for (int j = n-2-i; j>=i; j--) {
	    		        temp = swap(arr, j, m - 1 - i, temp);
	    		    }

	    		  
	    		    for (int j = m-2-i; j>=i; j--) {
	    		        temp = swap(arr, i, j, temp);
	    		    }
	    		}
	    		
	  	    	
	  	    }
	    	
	    
	    	
	    	
	    	
	    
	    
	    
	    
	    
	    for(int i =0; i<n; i++) {
	    	for(int j=0;j<m; j++) {
	    		System.out.print(arr[i][j]+" ");
	    		  
	    	}
	    	System.out.println();
	    }
	   
	  
	    	
	    	
	    	
	
	    	
	    	
	    	
	    	
	    	
	    
	    
	    
	    
	    
	    
	    
	    
    br.close();
    }
    
    public static int swap(int[][] arr,int x,int y, int temp) {
    	int a = arr[x][y];
    	arr[x][y] = temp;
    	
    	return a;
    }
    
    
    
    
    
    
    
}
