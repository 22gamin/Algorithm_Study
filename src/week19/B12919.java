package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12919 {
	static String S;
    static String T;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(answer);
    }

    private static void dfs(String cur) {
        if (answer == 1) return;

        if (cur.length() == S.length()) {
            if (cur.equals(S)) {
                answer = 1;
            }
            return;
        }

        int len = cur.length();

        if (cur.charAt(len - 1) == 'A') {
            dfs(cur.substring(0, len - 1));
        }

        if (cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(cur.substring(1));
            sb.reverse();
            dfs(sb.toString());
        }
    }
}
