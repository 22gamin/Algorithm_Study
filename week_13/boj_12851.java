import java.util.*;
import java.io.*;

public class boj_12851 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        // 방문 안했으면 -1임(시작점이 0이어야 하니까 -1로 해줌)
        Arrays.fill(time, -1);
        int[] cnt = new int[100001];

        Queue<Integer> q = new LinkedList<>();

        //시작점
        time[N] = 0;
        cnt[N] = 1;
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();

            //-1, +1, *2 세 가지 방법으로 움직임
            int[] nextP = new int[] { cur + 1, cur - 1, cur * 2 };

            for (int next : nextP) {
                if (next >= 0 && next < 100001) {
                    //다음 위치가 방문하지 않은 것이라면?
                    if (time[next] == -1) {
                        time[next] = time[cur] + 1;
                        cnt[next] = cnt[cur];
                        q.offer(next);
                     } //방문한 적이 있으면?? 횟수 합하기 
                    else if (time[next] == time[cur] + 1) {
                        cnt[next] += cnt[cur];
                    }
                }
            }
        }
        System.out.println(time[K]);
        System.out.println(cnt[K]);
    }
}
