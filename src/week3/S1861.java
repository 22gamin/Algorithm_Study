package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1861 {
    static Pair[] li;
    static int[][] arr;
    static int[] result;
    static int n;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class Pair{
        public int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test=1; test<=t; test++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            li = new Pair[n*n + 1];
            result = new int[n*n + 1];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    int a = arr[i][j];
                    li[a] = new Pair(i,j);
                }
            }
            int maxlen = Integer.MIN_VALUE;
            int num=0;
            for(int i =1; i<=n; i++){
                int len = dfs(i);
                if(maxlen<len) {
                    maxlen = len;
                    num = i;
                }
            }
            System.out.println("#"+test+" "+num+" "+maxlen);
        }
    }
    public static int dfs(int start){
        if(result[start]>0) return result[start];
        Pair cur = li[start];
        int maxnum = 0;
        for(int dir=0; dir<4; dir++){
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];
            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            int c = arr[nx][ny];
            if(c == start+1){
                int maxtmp = dfs(c);
                if(maxtmp>maxnum) maxnum = maxtmp;
            }
        }
        result[start] = maxnum +1;
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
