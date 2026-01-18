package xweek11;

import java.util.*;
import java.io.*;

public class b_11403 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];


        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝

        //거쳐가는 노드
        for(int k = 0; k<N; k++){
            //출발 노드
            for(int i = 0; i<N; i++){
                //도착 노드
                for(int j = 0; j<N; j++){
                    if (graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }

        //출력
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
