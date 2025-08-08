import java.io.*;
import java.util.*;

public class Main {
    static int n ;
    static boolean isV;
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =  Integer.parseInt(br.readLine());
       
        for(int tc = 1; tc<=t; tc++) {
            n = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            isV=true;
            for(int i =0; i<n; i++) {
                set.add( br.readLine());
            }

            for(String x : set) {
            	if(!isV) break;
            	StringBuilder sb =new StringBuilder();
            	for(int i=0; i<x.length()-1; i++) {
            		sb.append(x.charAt(i));
            		if(set.contains(sb.toString())) {
            			
            			isV = false;
            			break;
            		}
            		
            	}
            }
            
           
           String result = isV? "YES":"NO"; 
           
           System.out.println(result);
           
          
        }

    }

}
