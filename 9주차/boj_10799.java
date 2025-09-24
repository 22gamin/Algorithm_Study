package week_9;

import java.util.*;
import java.io.*;

public class boj_10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            if (cur == '(') {
                stack.push(cur);
            } else {
                stack.pop();

                if (str.charAt(i - 1) == '(') {
                    ans += stack.size();
                } else {
                    ans += 1;
                }
            }

        }
        System.out.println(ans);
    }
}
