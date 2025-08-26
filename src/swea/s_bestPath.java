package swea;

import java.io.*;
import java.util.*;

public class s_bestPath {
    static int N,point[][],min_dis,office[],home[];
    static boolean[] visited;

    static void dfs(int[] curr, int depths, int dis){
        if(dis >= min_dis) return;

        if(depths==N){
            //마지막 고객 위치에서 집까지의 거리를 더함
            dis += Math.abs(curr[0] - home[0]) + Math.abs(curr[1] - home[1]);
            min_dis = Math.min(min_dis, dis);
            return;
        }

        for(int i = 0; i<N; i++){
            if (!visited[i]){
                visited[i] = true;

                //다음 고객까지의 거리 계산
                int next = Math.abs(curr[0] - point[i][0]) + Math.abs(curr[1]-point[i][1]);
                dfs(point[i], depths + 1, dis + next);

                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <T+1; tc++){
            N = Integer.parseInt(br.readLine());

            point = new int[N][2];
            visited = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            office = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            home = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

            for(int i = 0; i < N; i++){
                point[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            }

            //입력 끝 ---
            min_dis = Integer.MAX_VALUE;

            dfs(office, 0, 0);

            sb.append("#").append(tc).append(" ").append(min_dis).append("\n");
        }
        System.out.println(sb.toString());
    }
}
