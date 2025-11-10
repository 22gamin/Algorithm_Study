package week14;

import java.io.*;
import java.util.*;

public class B4889 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        int tc = 1;

        while ((s = br.readLine()) != null) {
            s = s.trim();
            if (s.length() > 0 && allHyphens(s)) break;
            if (s.isEmpty()) continue; 

            int open = 0; 
            int ops  = 0; 

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '{') {
                    open++;
                } else { 
                    if (open > 0) {
                        open--;
                    } else {
                        // 짝이 없는 '}'를 '{'로 뒤집음
                        ops++;
                        open = 1;
                    }
                }
            }
            ops += open / 2; // 남은 '{'는 두 개당 1번 뒤집기

            sb.append(tc++).append(". ").append(ops).append('\n');
        }

        System.out.print(sb.toString());
    }

    private static boolean allHyphens(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') return false;
        }
        return true;
    }
}
