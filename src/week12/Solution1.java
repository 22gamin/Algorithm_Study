package week12;

import java.util.*;

class Solution1 {
    public int solution(String t, String p) {
        int n = p.length();
        int count=0;
        long pNum = Long.parseLong(p);
        
        for(int i=0;i<=t.length()-n; i++){
            String sub = t.substring(i,i+n);
            long subNum = Long.parseLong(sub);
            if(subNum<=pNum){
                count++;
            }
        }
        return count;
    }
}