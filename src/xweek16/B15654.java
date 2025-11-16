package xweek16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15654 {
    static int n, m;
    static int[] vis, result, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];
        vis = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
    }
    public static void dfs(int cnt){
        if(cnt == m){
            for(int c : result){
                System.out.print(c+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(vis[i]==0){
                vis[i] = 1;
                result[cnt] = arr[i];
                dfs(cnt+1);
                vis[i] = 0;
            }
        }
    }
}
