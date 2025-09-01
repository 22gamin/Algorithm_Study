package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1767 {
    public static class pair{
        int x, y;
        public pair(int x, int y){
            this.x = x ;
            this.y = y;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static List<pair> core;
    static int n, maxnum, totallen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test<=t; test++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            core = new ArrayList<>();
            for(int i=0; i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j =0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i==0 || i==n-1 || j==0 || j==n-1) continue;
                    if(map[i][j] == 1) core.add(new pair(i, j));
                }
            }
            maxnum = 0;
            totallen = Integer.MAX_VALUE;
            dfs(0,0,0);
            System.out.println("#"+test+" "+totallen);
        }
    }
    public static void dfs(int cnt, int minlen, int index){
        if(index == core.size()){
            if(maxnum<cnt){
                maxnum = cnt;
                totallen = minlen;
            }else if(maxnum == cnt){
                totallen = Math.min(totallen, minlen);
            }
            return;
        }
        pair cur = core.get(index);
        for(int d=0; d<4; d++){
            if(chkconnect(cur.x, cur.y, d)){
                int len = setwire(cur.x, cur.y, d, 2);
                dfs(cnt+1, minlen+len, index+1);
                setwire(cur.x, cur.y, d, 0);
            }
        }
        dfs(cnt, minlen, index+1);
    }
    // 연결가능한지 확인하기
    private static boolean chkconnect(int a, int b, int d){
        while(true){
            a+=dx[d];
            b+=dy[d];
            // 순서
            if(map[a][b]>0) break;
            if(a==0 || a==n-1 || b==0 || b==n-1) return true;

        }
        return false;
    }
    // 연결시키거나 제거하기
    private static int setwire(int a, int b, int d, int num){
        int count = 0;
        while(true){
            a+=dx[d];
            b+=dy[d];
            if(a<0 || a>=n || b<0 || b>=n) return count;
            map[a][b] = num;
            count++;
        }
    }
}
