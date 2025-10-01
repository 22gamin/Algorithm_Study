import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        int [][] dp = new int[n+1][2];
        dp[1][0] = 0;
        dp[1][1] = 0;
        
        
        for(int i =2; i<=n; i++) {
        	dp[i][0] = dp[i-1][0] +1;
        	dp[i][1] = i-1;
        	
        	if(i%2==0) {
        		if(dp[i][0] > dp[i/2][0]+1) {
        			dp[i][0] = dp[i/2][0]+1;
        			dp[i][1] = i/2;
        		}
        	}
        	
        	if(i%3==0) {
        		if(dp[i][0] > dp[i/3][0]+1) {
        			dp[i][0] = dp[i/3][0]+1;
        			dp[i][1] = i/3;
        		}
        	}
        	
        
        }
        
        int index = n;
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ");
        
        while(index !=1) {
        	sb.append(dp[index][1]).append(" ");
        	index = dp[index][1];
        }
        
        System.out.println(dp[n][0]);
        System.out.println(sb.toString());
        
        
        
        
    }
}
