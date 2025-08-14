package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1861 {
    static int[] result;
    static int[][] matrix;
    static pair[] li;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};
    static int n;
    static class pair{
        public int x, y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test =1; test<= t; test++) {
            n = Integer.parseInt(br.readLine());
            matrix = new int[n][n];
            result = new int[n*n +1];
            li = new pair[n*n +1];

            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    int a = matrix[i][j];
                    li[a] = new pair(i,j);
                }
            }
            int maxNumber = 0;
            int startr = Integer.MAX_VALUE;
            for(int i=1; i<=n; i++) {
                int len = dfs(i);
                if(len > maxNumber) {
                    maxNumber = len;
                    startr = i;
                }else if(len == maxNumber) {
                    if(i<startr) {
                        startr = i;
                    }
                }
            }
            System.out.println("#"+test+" "+startr+" "+maxNumber);
        }
    }
    public static int dfs(int start) {
        if(result[start]>0) return result[start];
        //vis[start] = 1;
        int maxnum = 0;
        pair cur = li[start];
        for(int dir=0; dir<4; dir++) {
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];
            if(nx<0||nx>=n || ny<0 || ny>=n) continue;

            int c = matrix[nx][ny];

            if(c == start+1) {
                int nextnum = dfs(c);
                if(nextnum > maxnum) maxnum = nextnum;
            }
        }
        result[start] = 1+maxnum;
        return result[start];
    }
}
/*2
2
1 2
3 4
3
9 3 4
6 1 5
7 8 2
*/
