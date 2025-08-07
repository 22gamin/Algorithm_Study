package swea;

import java.io.*;
import java.util.*;

public class s_1210 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++){
            int T = Integer.parseInt(br.readLine());
            int[][] graph = new int[100][100];

            for (int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 2가 있는 열 위치 찾기
            int row = 99;
            int col = 0;
            for (int i = 0; i < 100; i++) {
                if (graph[99][i] == 2) {
                    col = i;
                    break;
                }
            }

            // 위로 올라가기
            while (row > 0) {
                // 왼쪽 확인
                if (col - 1 >= 0 && graph[row][col - 1] == 1) {
                    while (col - 1 >= 0 && graph[row][col - 1] == 1) {
                        col--;
                    }
                    row--;
                }
                // 오른쪽 확인
                else if (col + 1 < 100 && graph[row][col + 1] == 1) {
                    while (col + 1 < 100 && graph[row][col + 1] == 1) {
                        col++;
                    }
                    row--;
                }
                // 그냥 위로
                else {
                    row--;
                }
            }

            System.out.println("#" + T + " " + col);
        }
    }
}
