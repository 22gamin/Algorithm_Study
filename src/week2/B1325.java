package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1325 {
    static boolean[] vis;
    static int total;
    static List<Integer>[] li;

    public static void dfs(int a){
        vis[a] = true;
        total++;
        for(int i: li[a]){
            if(vis[i]) continue;
            dfs(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt( st.nextToken());
        int m = Integer.parseInt( st.nextToken());
        int[] count = new int[n+1];
        li = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            li[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            li[b].add(a);
        }

        int[] number = new int[n+1];
        int maxn = 0;
        for(int i=1; i<=n; i++){
            vis = new boolean[n+1];
            total=0;
            dfs(i);
            number[i] = total;
            if(maxn<total) maxn = total;
        }
        for(int i=1; i<=n; i++){
            if(maxn == number[i]) System.out.print(i+" ");
        }
    }
}
