package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_1861 {
    static int N, cnt;
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void find(int start_x, int start_y, int value) {

        for(int i = 0; i < 4; i++) {
            int x = start_x + dx[i];
            int y = start_y + dy[i];


            if (x<0 || x>=N || y < 0 || y>=N) continue;

            if (graph[x][y] - value == 1) {
                cnt ++;

                find(x,y,graph[x][y]);
            }
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T= Integer.parseInt(br.readLine());

        for(int i = 1; i<T+1; i++) {
            N = Integer.parseInt(br.readLine());

            graph = new int[N][N];

            for(int j = 0; j<N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int k = 0; k<N; k++) {
                    graph[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int max_cnt = 0;
            int start = 0;

            for(int l = 0; l <N; l++) {
                for(int m = 0; m <N; m++) {
                    cnt = 1;
                    find(l,m,graph[l][m]);

                    if (max_cnt < cnt) {
                        max_cnt = cnt;
                        start = graph[l][m];
                    }
                    else if (max_cnt == cnt && start > graph[l][m]) {
                        max_cnt = cnt;
                        start = graph[l][m];
                    }
                }
            }

            System.out.println("#" + i + " " + start + " "+ max_cnt);
        }


    }

}
