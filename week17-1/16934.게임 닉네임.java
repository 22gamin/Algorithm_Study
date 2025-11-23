import java.io.*;
import java.util.*;

public class Main {
	static int n;
	
	static class Node{
		Node [] childs = new Node[26];
		int endCount = 0;
		
		Node() {
		}
	}
	
	static Node [] start;
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n  =Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        start = new Node[26];
        
        Node t = null;
    	Node [] temp = new Node[26];
    	
        for(int i = 0; i<n; i++) {
        	String a= br.readLine();
        	int l = a.length();
        	boolean isF = false;
        	
        	for(int j = 0; j<l; j++) {
        		char apb = a.charAt(j);
            	int idx = apb - 'a';     
            	
            	if(!isF) {
            		sb.append(apb);
            	}
            	
            	
            	if(j==0) {
            		if(start[idx]==null) {
            			isF=true;
            			start[idx]=new Node();   
            			
            		}
            		t = start[idx];
            		temp = t.childs;
            	}else {
            		if(temp[idx]==null) {
            			isF=true;
            			temp[idx]=new Node();
            			
            		}
            		t = temp[idx];
            		temp = t.childs;
            	}
            	
            	
            	
            	
            	
            	if(j==l-1) {
            		t.endCount++;
            		if(!isF) {
            			int x = t.endCount;	      
            			if(x>1) {
            				sb.append(x);
            			}
            		}         		
            	}
            	
            	
            	
            	
        	}
        	sb.append("\n");
        
        }
        
        System.out.println(sb.toString());
   
    
    }
    
    
    
    
    
    
    
}
