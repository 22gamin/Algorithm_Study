import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx, int count) {
        if (count == N / 2) {
            calc();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    static void calc() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int val = Math.abs(start - link);
        
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        
        min = Math.min(min, val);
    }
}
