package week8;

import java.util.*;

public class B23350 {
    static class Container {
        int p, w; // priority, weight
        Container(int p, int w) {
            this.p = p;
            this.w = w;
        }
    }

    static int ans = 0;
    static int[] cntPrior;

    // push: 컨테이너를 구조에 넣으면서 비용 누적
    static <T extends Collection<Container>> void push(Container c, Deque<Container> to) {
        to.addLast(c);
        ans += c.w;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        Queue<Container> unsortedQ = new LinkedList<>();
        cntPrior = new int[M + 1];
        for (int i = 0; i < N; i++) {
            int p = sc.nextInt();
            int w = sc.nextInt();
            unsortedQ.add(new Container(p, w));
            cntPrior[p]++;
        }

        Queue<Container> q = new LinkedList<>();

        // 우선순위 정렬: 낮은 우선순위(M)부터 q에 옮기기
        int idx = M;
        while (!unsortedQ.isEmpty()) {
            while (idx > 0 && cntPrior[idx] == 0) idx--; // 남은 우선순위 찾기
            while (unsortedQ.peek().p != idx) { // idx 찾을 때까지 앞으로 보냄
                Container c = unsortedQ.poll();
                unsortedQ.add(c);
                ans += c.w;
            }
            q.add(unsortedQ.poll());
            cntPrior[idx]--;
        }

        // 실제 적재 시뮬레이션
        Stack<Container> s = new Stack<>();
        Stack<Container> temp = new Stack<>();

        s.push(new Container(0, 0)); // dummy

        while (!q.isEmpty()) {
            Container next = q.peek();

            // 무게 규칙: 같은 priority인데 스택 top이 더 가벼우면 꺼냄
            while (next.p == s.peek().p && next.w > s.peek().w) {
                Container removed = s.pop();
                ans += removed.w;
                temp.push(removed);
            }

            // q -> s
            ans += next.w;
            s.push(q.poll());

            // temp -> s
            while (!temp.isEmpty()) {
                Container putBack = temp.pop();
                ans += putBack.w;
                s.push(putBack);
            }
        }

        System.out.println(ans);
    }
}
