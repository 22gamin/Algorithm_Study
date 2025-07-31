package test;
import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args)throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int [] arr = new int[n+1];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int [][] result = new int[n+1][2];
    	for(int i =1; i<=n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		
    	}
    	
    	Stack<Integer> stack = new Stack<>();
    	
    	
    	for(int i =n; i>0; i--) {// <---- 방향으로 탐색
    		if(!stack.isEmpty()) {
    			if(arr[i]<arr[stack.peek()]) {
    				result[i][0] = stack.size();
        			result[i][1] = stack.peek();
        			stack.add(i);
    			}else {
    				stack.pop();
    				
    				while(!stack.isEmpty()) {
    					if(arr[i]<arr[stack.peek()]) {
    						result[i][0] = stack.size();
    	        			result[i][1] = stack.peek();

    	        			break;
    					}
    					stack.pop();
    				}
    				stack.add(i);
    			}
    		}else {
    			stack.add(i);
    		}
    		
    	} 
    	
    	stack = new Stack<>(); //스택 초기화
    	for(int i = 1; i<=n; i++) { // ----> 방향으로 탐색
    		if(!stack.isEmpty()) {
    			if(arr[i]<arr[stack.peek()]) {
    				result[i][0] += stack.size();
    				if(Math.abs(i-stack.peek())<=Math.abs(i-result[i][1])) {
    					result[i][1] = stack.peek();
    				}
    				stack.add(i);
    			}
    			else {
    				stack.pop();
    				while(!stack.isEmpty()) {
    					if(arr[i]<arr[stack.peek()]) {
    						result[i][0] += stack.size();
    	    				if(Math.abs(i-stack.peek())<=Math.abs(i-result[i][1])) {
    	    					result[i][1] = stack.peek();
    	    				}
    	    				
    	    				break;
    					}
    					stack.pop();
    				}
    				stack.add(i);
    			}
    			
    			
    		}else {
    			stack.add(i);
    		}
    	}
    	
    	
    	for(int i =1; i<=n; i++) {
    		if(result[i][0] ==0) {
    			System.out.println("0");
    		}else {
    			System.out.println(result[i][0]+" "+result[i][1]);
    		}
    	
    	}
    	
    	
    	
    }
    
    
    
    
    
}
