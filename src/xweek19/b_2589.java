package xweek19;

import java.util.*;
import java.io.*;

public class b_2589 {

    static int se, ga;
    static char map[][];
    static List<int[]> start = new ArrayList<>();
    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    static void find(int[] startDot) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[se][ga];
        visited[startDot[0]][startDot[1]] = true;
        queue.add(new int[]{startDot[0], startDot[1], 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            max = Math.max(max, curr[2]);

            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if (x >= 0 && y >= 0 && x < se && y < ga && !visited[x][y] && map[x][y] == 'L') {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y, curr[2] + 1});
                }
            }
        }
    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        se = Integer.parseInt(st.nextToken());
        ga = Integer.parseInt(st.nextToken());

        map = new char[se][ga];


        for(int i = 0; i<se; i++){
            String str = br.readLine();
            for(int j = 0; j<ga; j++){
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'L') start.add(new int[]{i,j});
            }
        } //입력 끝

        for(int[] dot : start){
            find(dot);
        }

        System.out.println(max);
    }
}
