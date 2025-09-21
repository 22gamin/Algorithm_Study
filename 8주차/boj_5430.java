package week_8;

import java.util.*;
import java.io.*;

public class boj_5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();

            // 1. 배열 문자열 파싱하여 Deque에 저장
            // [ ] 와 , 를 기준으로 파싱하기 위해 StringTokenizer 대신 split 사용
            if (n > 0) {
                String[] nums = arrStr.substring(1, arrStr.length() - 1).split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            // 2. 명령어 처리
            for (char command : p.toCharArray()) {
                if (command == 'R') {
                    isReversed = !isReversed;
                } else { // 'D'
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            // 3. 결과 출력
            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    if (isReversed) {
                        sb.append(deque.pollLast());
                    } else {
                        sb.append(deque.pollFirst());
                    }
                    if (i < size - 1) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
