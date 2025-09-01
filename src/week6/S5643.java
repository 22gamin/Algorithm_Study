package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S5643 {
    static List<Integer>[] shortarr;
    static List<Integer>[] tallarr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int test = 1; test<=t; test++){
            n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            shortarr = new ArrayList[n+1];
            tallarr = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                shortarr[i] = new ArrayList<>();
                tallarr[i] = new ArrayList<>();
            }
            for(int i=0; i<m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                shortarr[a].add(b);
                tallarr[b].add(a);
            }
            int totalcount = 0;
            for(int i=1; i<=n; i++){
                int len = bfs(i, shortarr);
                int tallen = bfs(i, tallarr);
                if(len+tallen == n-1) totalcount++;
            }
            System.out.println("#"+test+" "+totalcount);
        }
    }
    public static int bfs(int start, List<Integer>[] arr){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int count = 0;
        int[] vis = new int[n+1];
        vis[start] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int c : arr[cur]){
                if(vis[c] == 1)continue;
                count++;
                q.add(c);
                vis[c] = 1;
            }
        }
        return count;
    }
}
