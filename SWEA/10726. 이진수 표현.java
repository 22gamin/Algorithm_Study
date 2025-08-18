import java.util.*;
import java.io.*;

public class Solution{

 	public static void main(String[] arg)throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		int t = Integer.parseInt(br.readLine());
 		for(int tc=1; tc<=t; tc++) {
 			StringTokenizer st = new StringTokenizer(br.readLine( ));
 			int n = Integer.parseInt(st.nextToken());
 			int m = Integer.parseInt(st.nextToken());
 			String result = "ON";
 			int mask = (1<<n)-1;
 			if((m&mask)!=mask) {
 				result ="OFF";
 			}
 			System.out.println("#"+tc+" "+result);
 		}
 	
 	}
	
 }
