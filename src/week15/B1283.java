package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1283 {
	static boolean[] used = new boolean[26];
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < n; k++) {
            String line = br.readLine();
            int len = line.length();
            boolean assigned = false;

            // 각 단어의 첫 글자부터 확인
            for (int i = 0; i < len; i++) {
                if (i == 0 || line.charAt(i - 1) == ' ') {
                    char c = line.charAt(i);
                    if (c != ' ' && isAlpha(c) && !isUsed(c)) {
                        markUsed(c);
                        sb.append(insertBracket(line, i)).append('\n');
                        assigned = true;
                        break;
                    }
                }
            }

            if (assigned) continue;

            // 전체 문자열 순회하면서 첫 글자 외의 글자도 확인
            for (int i = 0; i < len && !assigned; i++) {
                char c = line.charAt(i);
                if (c != ' ' && isAlpha(c) && !isUsed(c)) {
                    markUsed(c);
                    sb.append(insertBracket(line, i)).append('\n');
                    assigned = true;
                }
            }

            // 아무 것도 못 찾으면 그대로 출력
            if (!assigned) {
                sb.append(line).append('\n');
            }
        }

        System.out.print(sb);
    }

    // 알파벳인지 확인
    private static boolean isAlpha(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    // 이미 단축키로 쓰였는지 확인
    private static boolean isUsed(char c) {
        c = Character.toLowerCase(c);
        return used[c - 'a'];
    }

    // 단축키로 사용 표시
    private static void markUsed(char c) {
        c = Character.toLowerCase(c);
        used[c - 'a'] = true;
    }

    private static String insertBracket(String line, int idx) {
        return line.substring(0, idx) + "[" + line.charAt(idx) + "]" + line.substring(idx + 1);
    }
}
