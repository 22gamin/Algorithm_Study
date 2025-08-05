package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2583 {
    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> li = new ArrayList<>();
        int[][] matrix = new int[n][m];
        int[][] vis = new int[n][m];
        while (k-- > 0) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int c = Integer.parseInt(st1.nextToken());
            int d = Integer.parseInt(st1.nextToken());
            for (int i = b; i < d; i++) {
                for (int j = a; j < c; j++) {
                    matrix[i][j] = 1;
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 1 || matrix[i][j] == 1) {
                    continue;
                }
                q.add(new Pair(i, j));
                total++;
                int cnt = 0;
                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    cnt++;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = dx[dir] + cur.x;
                        int ny = dy[dir] + cur.y;
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }
                        if (vis[nx][ny] == 1 || matrix[nx][ny] == 1) {
                            continue;
                        }
                        q.add(new Pair(nx, ny));
                        vis[nx][ny] = 1;

                    }
                }
                if(cnt>1)li.add(cnt-1);
                else li.add(cnt);
            }
        }
        Collections.sort(li);
        System.out.println(total);
        for (Integer c : li) {
            System.out.print(c + " ");
        }
    }
}
