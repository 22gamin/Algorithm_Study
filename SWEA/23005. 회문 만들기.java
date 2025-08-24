import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        for(int tc =1; tc<=t; tc++) {
            String a = br.readLine().trim();
            int r = a.length()-1;
            int l = 0;
            boolean isV = true;
            int count = 0;

            while(l < r) {
                char x = a.charAt(r);
                char y = a.charAt(l);

                if(x == y) {
                    l++;
                    r--;
                } else if(x == 'x') {
                    count++;
                    r--;
                } else if(y == 'x') {
                    count++;
                    l++;
                } else {
                    isV = false;
                    break;
                }
            }
            int result = -1;
            if(isV) {
            	result = count;
            }
            
            
            System.out.println("#"+tc+" "+result);
        }
    }
}
