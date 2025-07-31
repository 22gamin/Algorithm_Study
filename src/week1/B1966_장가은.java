package week1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1966_장가은 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스 수

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // 문서 개수
            int M = sc.nextInt(); // 타겟 문서 위치

            Queue<int[]> queue = new LinkedList<>();
            int[] priorities = new int[N];

            for (int i = 0; i < N; i++) {
                int priority = sc.nextInt();
                queue.offer(new int[]{i, priority}); // {index, priority}
                priorities[i] = priority;
            }

            Arrays.sort(priorities); // 중요도 높은 순으로 정렬하기 위해
            int order = 0;
            int idx = N - 1; // 현재 가장 높은 우선순위의 인덱스

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                if (current[1] == priorities[idx]) {
                    order++;
                    idx--;
                    if (current[0] == M) {
                        System.out.println(order);
                        break;
                    }
                } else {
                    queue.offer(current); // 뒤로 보내기
                }
            }
        }
    }

}
