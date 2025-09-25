import java.util.*;
import java.io.*;

public class Solution {
	static long s;
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 1; tc <= t; tc++) {
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	long a = Long.parseLong(st.nextToken());
        	long b = Long.parseLong(st.nextToken());
        	long k = Long.parseLong(st.nextToken());
        	s = a+b;
        	
        	long ak = (a*pow(k))%s;
        	
        	long result = Math.min(ak,s-ak);
    
        	sb.append("#"+tc+" "+result).append("\n");
         
        }
           
        System.out.println(sb.toString());
        
  
    }
    
    static long pow(long k) {
    	if(k==1) return 2;
    	long x = pow(k/2)%s;
    	if(k%2 ==0) {
    		return (x*x)%s;
    	}else {
    		return (2*x*x)%s;
    	}
    }
}
