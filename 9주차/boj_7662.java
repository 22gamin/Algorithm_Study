import java.util.*;
import java.io.*;

public class boj_7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            // 이중 우선순위 큐
            TreeMap<Integer, Integer> map = new TreeMap<>();

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                // I 입력 받으면
                if (cmd.equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                // D 입력 받으면
                else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    int n = Integer.parseInt(st.nextToken());
                    // 최대값 삭제
                    if (n == 1) {
                        int max = map.lastKey();
                        int count = map.get(max);
                        // 최대값이 한 개면 key값 삭제
                        if (count == 1) {
                            map.remove(max);
                        }
                        // 최대값이 여러 개면 value - 1
                        else {
                            map.put(max, count - 1);
                        }
                    }
                    // 최소값 삭제
                    else {
                        int min = map.firstKey();
                        int count = map.get(min);
                        // 최소값이 한 개면 key값 삭제
                        if (count == 1) {
                            map.remove(min);
                        }
                        // 최소값이 여러 개면 value - 1
                        else {
                            map.put(min, count - 1);
                        }

                    }
                }
            }

            // 큐가 비었으면 EMPTY 출력
            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
