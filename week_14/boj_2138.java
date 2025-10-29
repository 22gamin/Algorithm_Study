import java.util.*;
import java.io.*;

public class boj_2138 {
    static int N;
    static int[] want;
    static int[] now1;
    static int[] now2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        now1 = new int[N];
        now2 = new int[N];
        want = new int[N];

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            now1[i] = s.charAt(i) - '0';
            now2[i] = s.charAt(i) - '0';
        }

        s = br.readLine();
        for (int i = 0; i < N; i++) {
            want[i] = s.charAt(i) - '0';
        }

        // 1번째 전구 딸깍
        now1[0] = 1 - now1[0];
        now1[1] = 1 - now1[1];
        int r1 = start(now1, 1);

        // 1번째 전구 노터치
        int r2 = start(now2, 0);

        int ans = Math.min(r1, r2);

        if (ans == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static int start(int[] arr, int count) {
        // 두 번째 전구부터 시작해줌
        for (int i = 1; i < N; i++) {
            // i - 1번 전구를 목표와 똑같게 만들어주면서 진행할거임
            if (arr[i - 1] != want[i - 1]) {
                count++;
                if (i == N - 1) { // 마지막 전구는 본인과 본인 전꺼 두개만 바뀌니까 따로 처리
                    arr[i - 1] = 1 - arr[i - 1];
                    arr[i] = 1 - arr[i];
                } else { // i - 1, i, i + 1 전구 바꿔주기
                    arr[i - 1] = 1 - arr[i - 1];
                    arr[i] = 1 - arr[i];
                    arr[i + 1] = 1 - arr[i + 1];
                }
            }
        }

        // 끝까지 와서 마지막 전구가 똑같으면 완성한거임
        if (arr[N - 1] == want[N - 1]) {
            return count;
        } else {
            return 100001;
        }

    }
}
