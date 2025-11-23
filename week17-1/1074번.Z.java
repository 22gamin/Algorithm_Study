import java.io.*;
import java.util.*;

public class Main {
	static int n, r, c;
	static int idx;
	static boolean isF;


    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        idx = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
     
        
        isF = false;
        
       
        recur(0,0,(int) Math.pow(2,n));
        
        System.out.println(idx);
    
    }
    
    static void recur(int x, int y,int l) {
    	if(isF) return;
    	
    	if((x+l-1)<r || x>r || y>c || (y+l-1)<c) {
    		for(int i=0; i<l*l; i++) {
    			idx++;
    		}
    		return;
    	}
    	
    	if(l==2) {
    		for(int i = x; i<=x+1; i++) {
    			for(int j=y; j<=y+1; j++) {
    				if(i==r && j ==c) {
    					isF=true;
    					return;
    				}
    				idx++;
    			}
    		}
    		return;
    	}
    	
    	
    	recur(x,y,l/2);
    	recur(x,y+(l/2),l/2);
    	recur(x+(l/2),y,l/2);
    	recur(x+(l/2),y+(l/2),l/2);
    }
    
    
    
}
