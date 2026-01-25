package week22;

import java.io.*;

public class B1802 {
    static char[] arr;

    static boolean check(int l, int r) {
        if (l == r) return true;

        int mid = (l + r) / 2;

        // 가운데 기준 대칭은 반드시 달라야 함
        for (int i = 1; mid - i >= l; i++) {
            if (arr[mid - i] == arr[mid + i]) return false;
        }

        // 왼쪽/오른쪽도 같은 규칙으로 재귀 확인
        return check(l, mid - 1) && check(mid + 1, r);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            arr = s.toCharArray();

            sb.append(check(0, arr.length - 1) ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }
}
