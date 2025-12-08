package xweek20;

import java.util.*;
import java.io.*;

public class b_12904 {
    static String S,T;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        StringBuilder sb = new StringBuilder(T);

        while(sb.length() > S.length()){
            int lastIdx = sb.length()-1;
            char re = sb.charAt(lastIdx);

            sb.deleteCharAt(lastIdx);

            if (re=='B'){
                sb.reverse();
            }
        }
        if(sb.toString().equals(S)) System.out.println(1);
        else System.out.println(0);

    }
}
