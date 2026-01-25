package yweek2_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        for (int i=0; i < len; i++) {
            if (isPalindrome(s.substring(i))) {
                System.out.println(len + i);
                return;
            }
        }
}
    public static boolean isPalindrome(String str) {
        int st = 0;
        int en = str.length() - 1;

        while (st < en) {
            if (str.charAt(st) != str.charAt(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}
