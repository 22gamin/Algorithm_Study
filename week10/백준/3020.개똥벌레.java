import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int [] b = new int[h+1];
        int [] t = new int[h+1];
        int [] preSum1 = new int[h+1];
        int [] preSum2 = new int[h+1];
        int min = Integer.MAX_VALUE;
        int count = 0;
        
        for(int i = 0 ; i<n; i++) {
        	int x = Integer.parseInt(br.readLine());
        	if(i%2 ==0) {
        		b[x]++;
        	}else {
        		t[h-x+1]++;
        	}        	
        }
        
        for(int i = h-1; i>=1; i--) {
        	preSum1[i] = b[i] + preSum1[i+1];
        }
        
        for(int i =1; i<=h; i++) {
        	preSum2[i] = t[i] + preSum2[i-1] ;
        	if(preSum2[i]+ preSum1[i]<=min) {
        		if(preSum2[i] + preSum1[i]==min) {
        			count++;
        		}else {
        			min = preSum2[i]+ preSum1[i];
        			count = 1;
        		}
        	}
        }
        
        
        System.out.println(min + " "+count);
        
    }
}
