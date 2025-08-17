package swea;

import java.util.*;
import java.io.*;

public class s_1949 {

    static int N,K,graph[][],top,max;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void dfs(int start_x, int start_y, int cnt) {

        max = Math.max(max,cnt);

        for(int i = 0; i<4; i++){
            int x = start_x + dx[i];
            int y = start_y + dy[i];

            if(0<= x && x <N && 0<= y && y <N && graph[x][y] < graph[start_x][start_y]){
                dfs(x,y,cnt+1);
            }
        }
    }



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i =1; i<T+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            top = 0;
            graph = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < N; k++) {
                    graph[j][k] = Integer.parseInt(st.nextToken());

                    top = Math.max(graph[j][k], top); //최고 높이 찾기
                }
            }

            //입력 끝-----

            List<int[]> tops = new ArrayList<>();

            //최고점 좌표 저장
            for(int j=0; j<N; j++){
                for(int k = 0; k<N; k++){
                    if(top == graph[j][k]) tops.add(new int[]{j,k});
                }
            }

            max = 0;

            for(int j = 0; j < N; j++){
                for(int k =0; k<N; k++){
                    //1부터 k까지 각 좌표를 깎아보고 dfs 진행
                    for(int l =1; l<=K; l++){
                        graph[j][k] -= l;
                        for(int[] xy : tops) dfs(xy[0],xy[1],1);
                        // 다시 원래대로
                        graph[j][k] += l;
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(max).append("\n");

        }
        System.out.println(sb.toString());
    }
}
