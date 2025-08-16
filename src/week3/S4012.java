package week3;
//9:51

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S4012 {
    static int n, mintmp;
    static int[][] food;
    static int vis[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test<=t; test++){
            n = Integer.parseInt(br.readLine());
            food = new int[n][n];
            vis = new int[n];
            mintmp =Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    food[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 4개뽑기
            comb(0,0);
            System.out.println("#"+test+" "+mintmp);
        }
    }
    public static void comb(int start, int depth) {
        if (depth == n/2) {
            calculate();
            return;
        }
        for (int i = start; i < n; i++) {
            vis[i] = 1;
            comb(i + 1, depth + 1);
            vis[i] = 0;
        }
    }

    public static void calculate(){
        int a=0, b=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(vis[i] ==1 && vis[j] == 1) {
                    a+=food[i][j];
                }
                else if(vis[i] == 0 && vis[j] == 0) b+=food[i][j];
            }
        }
        int tmp = Math.abs(a-b);
        if(tmp <mintmp) mintmp = tmp;
    }
}
