package week20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B11724 {

    static List<Integer>[] list;
    static boolean[] visited;
    static int count=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

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

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.print(count);
    }
    static public void dfs(int cur){
        visited[cur]=true;
        
        for(int next : list[cur]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
