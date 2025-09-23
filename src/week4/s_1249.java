package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class s_1249 {

    static int N;
    static int[][] graph, dist;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            graph = new int[N][N];
            dist = new int[N][N];

            for(int i = 0; i< N; i++){
                String str = br.readLine();

                for(int j = 0; j<N; j++){
                    graph[i][j] = str.charAt(j) - '0';
                }
            }

            //입력 끝 ----
            // 도착시간 저장할 배열 초기화
            for(int i = 0; i<N; i++){
                Arrays.fill(dist[i], INF);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] -b[0]);

            dist[0][0] = graph[0][0];
            pq.offer(new int[]{dist[0][0],0,0});

            while(!pq.isEmpty()){

                int[] current = pq.poll();

                int time = current[0];
                int row = current[1];
                int col = current[2];


                if (time > dist[row][col]) continue;

                for(int k =0; k<4; k++){
                    int x = row + dx[k];
                    int y = col + dy[k];

                    if (x < 0 || y < 0 || x >=N || y >= N) continue;

                    int newCost = dist[row][col] + graph[x][y];

                    if(newCost < dist[x][y]){
                        dist[x][y] = newCost;
                        pq.offer(new int[]{newCost, x, y});
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(dist[N-1][N-1]).append("\n");

        }
        System.out.println(sb.toString());

    }
}