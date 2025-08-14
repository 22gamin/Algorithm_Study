package beakjoon;

//import java.io.*;
//import java.util.*;

public class b_2667 {

    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static List<Integer> list = new ArrayList<>();
    static Queue<int[]> queue = new LinkedList<>();
    static int cnt = 0;
    static int total = 0;

    public static int bfs() {

        while(!queue.isEmpty()) {
            int [] xy = queue.poll();

            for(int i = 0; i<4; i++) {
                int x = xy[0] + dx[i];
                int y = xy[1] + dy[i];

                if(x < 0 || x >= N || y< 0 || y >= N) continue;

                else if(graph[x][y] == 1 && !visited[x][y]) {


                    visited[x][y] = true;
                    cnt ++;
                    queue.add(new int[] {x,y});
                }

            }


        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N][N];


        //입력
        for (int i = 0; i<N; i++) {
            String line = br.readLine();

            for(int j = 0; j<N; j++) {
                graph[i][j] = line.charAt(j) -'0';
            }
        }

        for(int k=0; k<N; k++) {
            for(int l =0; l<N; l++) {
                if (graph[k][l] == 1 && !visited[k][l]) {
                    visited[k][l] = true;
                    queue.add(new int[] {k,l});
                    cnt = 1;
                    list.add(bfs());
                    total++;
                }
            }
        }
        Collections.sort(list);

        System.out.println(total);
        for(int num : list) {
            System.out.println(num);
        }
    }

}


