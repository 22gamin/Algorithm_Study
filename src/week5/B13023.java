package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B13023 {
    static int[] vis;
    static int n, chk = 0;
    static List<Integer>[] li;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        li = new ArrayList[n+1];
        for(int i=1; i<=n; i++) li[i] = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            li[a+1].add(b+1);
            li[b+1].add(a+1);
        }

        for(int i=1; i<=n; i++){
            vis = new int[n+1];
            vis[i] = 1;
            dfs(i, 1);
            if(chk == 1) break;
        }
        if(chk == 1) System.out.println(1);
        else System.out.println(0);
    }
    public static void dfs(int start, int cnt){
        if(cnt == 5) {
            chk = 1;
            return;
        }
        for(int c : li[start]){
            if(vis[c] == 0){
                vis[c] = 1;
                dfs(c, cnt+1);
                vis[c] = 0;
            }
        }
    }
}
