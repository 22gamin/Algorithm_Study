import java.util.*;
import java.io.*;

public class boj_11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        int set = 0; // int 변수를 집합으로 사용

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            int n = 0;

            // 명령어 all은 "all" 한 단어만 입력 받으므로 뒤에 숫자를 받지 않으므로 hasMoreTokens() 사용
            if (st.hasMoreTokens())
                n = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case "add": // n번째 비트 값을 1로
                    set |= (1 << n);
                    break;
                case "remove": // n번째 비트 값을 0으로
                    set &= ~(1 << n);
                    break;
                case "check": // n번째 비트 값이 있으면 1, 없으면 0
                    sb.append((set & (1 << n)) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle": // n번째 비트 값을 바꿈
                    set ^= (1 << n);
                    break;
                case "all": // n + 1번째 비트를 1로 만든 후(1000...) -1을 통해 (0111...)로 만듦
                    set = (1 << 21) - 1;
                    break;
                case "empty": // set 비우기
                    set = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}
