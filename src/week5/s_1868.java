package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class s_1868 {

    static char[][] graph;
    static int N,point;
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,-1,1};
    static List<List<Integer>> list;

    static void check(int start_x, int start_y) { //점 개수랑 지뢰 개수 저장

        int star = 0;

        for(int d = 0; d<8; d++) {
            int x = start_x + dx[d];
            int y = start_y + dy[d];

            if (x<0 || y<0|| x>= N || y>= N ) continue;


            if (graph[x][y] == '*') star++;

        }
        list.get(start_x).add(star);
        if (star == 0) {

        }
    }

    static void dfs(int start_x, int start_y) {

        for(int d = 0; d<8; d++) {
            int x = start_x + dx[d];
            int y = start_y + dy[d];

            if (x<0 || y<0|| x>= N || y>= N || graph[x][y] == '*') continue;

            if (graph[x][y] == '.') {
                if (list.get(x).get(y) == 0) {
                    graph[x][y] = (char)(0+'0');
                    dfs(x,y);
                    continue;
                }
                else {
                    graph[x][y] = (char)(list.get(x).get(y) + '0');
                }
            }


        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc < T+1; tc++) {
            N = Integer.parseInt(br.readLine());

            graph = new char[N][N];
            list = new ArrayList<>();

            for(int n = 0; n<N; n++) {
                list.add(new ArrayList<>());
            }

            for(int i = 0; i<N; i++) {
                String str = br.readLine();

                for(int j = 0; j<N; j++) {
                    graph[i][j] = str.charAt(j);
                }
            }

            // 입력 끝 ---

            //주변 지뢰, 점 개수 저장
            for(int i =0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    if (graph[i][j] == '*') {
                        list.get(i).add(-1);
                        continue;
                    }

                    check(i,j);
                }
            }

            // 지뢰 0인 것을 다 누르고 남은 점 세기
            point = 0;
            for(int i = 0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    if (list.get(i).get(j) == 0 && graph[i][j] == '.') {
//						System.out.println(i+"-"+ j);
                        point++;
                        graph[i][j] = (char)(0+'0');
                        dfs(i,j);

                    }
                }
            }

            for(int i = 0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    if (graph[i][j] == '.') {
                        point++;
//						System.out.println(i+"-"+ j);
                    }
                }
            }

//			for(int i =0; i<N; i++) {
//				for(int j = 0; j<N; j++) {
//					System.out.print(graph[i][j]);
//				}
//				System.out.println();
//			}
            System.out.println("#"+tc + " " + point);
        }
    }
}
