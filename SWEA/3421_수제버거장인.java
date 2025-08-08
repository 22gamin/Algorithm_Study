import java.io.*;
import java.util.*;
 
public class Solution {
    static int n, m;
    static int count;
    static ArrayList<ArrayList<Integer>> sang;
     
 
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
     
         
        for(int tc = 1;  tc<=t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sang = new ArrayList<>();
            for(int i  = 0 ; i<=n; i++) {
                sang.add(new ArrayList<>());
            }
             
         
             
            for(int i = 0; i<m; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                 
                int a =Integer.parseInt( st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                 
                sang.get(a).add(b);
                sang.get(b).add(a);
             
                 
                 
             
            }
 
            count =1 ;
            ArrayList <String> al = new ArrayList<>();
             
            for(int i =1; i<=n; i++) {
                    getCom(i,al);
                 
            }
             
             
             
             
         
             
            System.out.println("#"+tc+" "+count);
             
             
        }
             
         
         
    }   
    static void getCom(int start,ArrayList<String> al) {
         
        if(al.size()>0) {
            for(int i : sang.get(start)) {
                for(String j : al) {
                    if(Integer.parseInt(j)==i) {
                        return;
                    }
                }
                 
            }
        }
         
        al.add(String.valueOf(start));
        count++;
         
        for(int i =start+1; i<=n; i++) {
            getCom(i,al);
        }
         
        al.remove(al.size()-1);
    }
     
}