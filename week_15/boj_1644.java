import java.util.*;
import java.io.*;

public class boj_1644 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[N + 1];
        Arrays.fill(check, true);
        check[0] = check[1] = false;

        for (int i = 2; i * i <= N; i++) {
            for (int j = i * i; j <= N; j += i) {
                check[j] = false;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (check[i] == true) {
                list.add(i);
            }
        }

        int left = 0;
        int sum = 0;
        int count = 0;
        for (int right = 0; right < list.size(); right++) {
            sum += list.get(right);

            while (sum > N && left <= right) {
                sum -= list.get(left);
                left++;
            }
            if (sum == N)
                count++;
        }

        System.out.println(count);
    }
}
