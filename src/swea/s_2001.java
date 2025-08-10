package swea;

import java.io.*;
import java.util.*;

public class s_2001 {

    static int[][] graph;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i<T+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new int[N][N];
            int max_value = 0;

            for (int j = 0; j<N; j++){
                st = new StringTokenizer(br.readLine());

                for(int k = 0; k<N; k++){
                    graph[j][k] = Integer.parseInt(st.nextToken());
                }
            }


//            int i1 = ((N - M) + 1) * ((N - M) + 1);
            for(int x = 0; x <= N-M; x ++){
                for (int y =0; y<= N-M; y++){
                    int sum = 0;
                    for(int l = 0; l<M; l++){
                        for(int m =0; m<M; m++){
                            sum += graph[x+l][y+m];
                        }
                    }
                    if (sum > max_value) max_value = sum;
                }
            }



            System.out.println("#" + i + " " + max_value);

        }
    }
}
