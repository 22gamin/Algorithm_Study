package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        int[] num = new int[4];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(st1.nextToken());
        }
        int a = 0, c = 0, g = 0, t = 0, total = 0;
        for (int i = 0; i < s; i++) {
            char number = str.charAt(i);
            if (number == 'A') {
                a++;
            } else if (number == 'C') {
                c++;
            } else if (number == 'G') {
                g++;
            } else if (number == 'T') {
                t++;
            }
        }
        // 처음꺼 확인
        if (a >= num[0] && c >= num[1] && g >= num[2] && t >= num[3]) {
            total++;
        }
        for (int i = s; i < p; i++) {
            char ch = str.charAt(i);
            if (ch == 'A')
                a++;
            else if (ch == 'C')
                c++;
            else if (ch == 'G')
                g++;
            else if (ch == 'T')
                t++;

            if (str.charAt(i - s) == 'A')
                a--;
            else if (str.charAt(i - s) == 'C')
                c--;
            else if (str.charAt(i - s) == 'G')
                g--;
            else if (str.charAt(i - s) == 'T')
                t--;

            if (a >= num[0] && c >= num[1] && g >= num[2] && t >= num[3]) {
                total++;
            }
        }
        System.out.print(total);
    }
}
