import java.util.*;
import java.io.*;

public class Solution {
    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            long count = 0;

            while (n > 2) {
                long a = (long) Math.sqrt(n); 
                // sqrt 함수는 내부적으로 이진 탐색 기반으로 구현되어 있어 O(logN) 시간복잡도를 가집니다.

                if (a * a != n) {
                    a = a + 1;
                    count += ((a * a) - n) + 1; // +1은 제곱근 연산 횟수
                    n = a;
                } else {
                    n = a;
                    count++;
                }
            }
            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
}
