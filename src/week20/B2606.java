package week20;

import java.io.*;
import java.util.*;

public class B2606 {

    static List<Integer>[] list;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        System.out.println(count);

    }

    static public void dfs(int cur){
        visited[cur]=true;
        
        for(int next : list[cur]){
            if(!visited[next]){
                count++;
                dfs(next);
            }
        }
    }
}