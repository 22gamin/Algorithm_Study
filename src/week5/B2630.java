package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 {
    static int[][] map;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        cnt = new int[2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,n);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
    }
    public static void dfs(int x, int y, int n){
        if(chk(x, y, n)){
            cnt[map[x][y]]++;
            return;
        }
        int c = n/2;
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                dfs(x+ i*c, y+j*c, c);
            }
        }
    }
    public static boolean chk(int x, int y, int n){
        for(int i = x; i<x+n; i++){
            for(int j = y; j<y+n; j++){
                if(map[x][y] != map[i][j]) return false;
            }
        }
        return true;
    }
}
