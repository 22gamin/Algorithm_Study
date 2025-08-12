import java.io.*;
import java.util.*;
 
public class Solution {
    static int n;
    static int [] number;
    static int [] cal;
    static int min;
    static int max;
     
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
 
        for(int tc =1; tc<=t; tc++) {
            cal =new int[4];
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            n = Integer.parseInt(br.readLine().trim());
            number=  new int[n];
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i  = 0 ; i<4; i++) {
                int c = Integer.parseInt(st.nextToken());           
                cal[i]=c;
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i = 0 ; i<n ; i++) {
                number[i] = Integer.parseInt(st2.nextToken());
            }
             
            find(0,cal[0],cal[1],cal[2],cal[3],number[0]);
            int ans = max- min;
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
         
        System.out.print(sb.toString());
    }
     
     
    static void find(int d,int c1, int c2, int c3 , int c4 ,int sum) {
         
        if(d==n-1) {
            max = Math.max(sum,max);
            min = Math.min(sum,min);
            return;
        }
         
         
        if(c1>0) {
            int nsum = sum + number[d+1];
            find(d+1,c1-1,c2,c3,c4,nsum);
        }
        if(c2>0) {
            int nsum = sum - number[d+1];
            find(d+1,c1,c2-1,c3,c4,nsum);
        }
        if(c3>0) {
            int nsum = sum * number[d+1];
            find(d+1,c1,c2,c3-1,c4,nsum);
        }
        if(c4>0) {
            int nsum = sum / number[d+1];
            find(d+1,c1,c2,c3,c4-1,nsum);
        }
    }
     
     
     
}
