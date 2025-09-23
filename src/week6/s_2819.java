package week6;

import java.util.*;
import java.io.*;

public class s_2819 {
    static String[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<String> list;

    static void dfs(int startX, int startY, int depths, String str) {

        if (depths == 7) {
            if (!list.contains(str)) {
                list.add(str);
            }
            return;
        }

        for(int i = 0; i<4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            if (x>= 0 && y>=0 && x<4 && y<4) {
                String ex = graph[x][y];
                dfs(x,y,depths+1,str+ex);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for(int tc = 1; tc<T+1; tc++) {
            graph = new String[4][4];
            list = new ArrayList<>();

            for(int i = 0; i<4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j<4; j++) {
                    graph[i][j] = st.nextToken();
                }
            }

            //입력 끝----

            for(int i = 0; i<4; i++) {
                for(int j = 0; j<4; j++) {
                    dfs(i,j,1,graph[i][j]);
                }
            }

            sb.append("#").append(tc).append(" ").append(list.size()).append("\n");
        }
        System.out.println(sb.toString());

    }

}
