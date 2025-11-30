import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] time = new int[100001];
    static int[] parent = new int[100001]; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        time[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) {
                // 시간 출력
                System.out.println(time[now] - 1);
                
                // 경로 역추적
                Stack<Integer> stack = new Stack<>();
                int temp = K;
                while (temp != N) {
                    stack.push(temp);
                    temp = parent[temp];
                }
                stack.push(N);
                
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(' ');
                }
                System.out.println(sb);
                return;
            }

         
            int[] nextMoves = {now - 1, now + 1, now * 2};
            
            for (int next : nextMoves) {
                if (next >= 0 && next <= 100000 && time[next] == 0) {
                    q.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now; // 여기서 이전 위치 기록
                }
            }
        }
    }
}
