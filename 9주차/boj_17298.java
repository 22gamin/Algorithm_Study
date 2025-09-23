package week_9;

import java.util.*;
import java.io.*;

public class boj_17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] sequence = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        // Deque를 스택으로 사용
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[N];

        // 0번 인덱스부터 시작
        for (int i = 0; i < N; i++) {
            // 스택이 비어있지 않고, 현재 원소가 스택의 top이 가리키는 원소보다 클 경우
            while (!stack.isEmpty() && sequence[stack.peek()] < sequence[i]) {
                // 스택의 top에 있던 인덱스는 오큰수를 찾았으므로 pop
                // 해당 인덱스의 정답 배열에 현재 원소 값을 저장
                answer[stack.pop()] = sequence[i];
            }
            // 현재 원소의 인덱스를 스택에 push
            stack.push(i);
        }

        // 스택에 남아있는 인덱스들은 오큰수가 없는 것들
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }
}
