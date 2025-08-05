package beakjoon;

import java.io.*;
import java.util.*;

public class b_1012 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[] {1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static int[] current = new int[2];
    static Queue<int[]> queue = new LinkedList<>();

    public static void bfs(int M, int N) {

        while(!queue.isEmpty()) {
            current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int k = 0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                    continue;
                else if(graph[nx][ny] == 1 && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx,ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //덩어리별로 배추흰지렁이 하나 배정 => 결론: 덩어리 개수 세기

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); //가로
            int N = Integer.parseInt(st.nextToken()); //세로
            int K = Integer.parseInt(st.nextToken()); //위치의 개수

            graph = new int[M][N];
            visited = new boolean[M][N];
            int cnt = 0;

            //graph에 넣기
            for (int j = 0; j<K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());

                graph[a][b] = 1;
            }

            //bfs로 전체 순회 돌기
            for(int l=0; l<M; l++) {
                for(int m=0; m<N; m++) {
                    if (graph[l][m] == 1 && visited[l][m]== false) {
                        visited[l][m] = true;
                        queue.add(new int[] {l,m});
                        bfs(M,N);
                        cnt ++;
                    }
                }
            }
            System.out.println(cnt);

        }

    }
}

