package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class B6603 {
    static int[] arr;
    static int[] vis;
    static int[] result;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            arr = new int[n+1];
            result = new int[6];
            vis = new int[n+1];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            System.out.println("");
        }
    }
    public static void dfs(int start ,int cnt){
        if(cnt == 6){
            for(int i = 0; i<6; i++){
                System.out.print(result[i]+" ");
            }
            System.out.println("");
            return;
        }
        for(int i=start; i<n; i++){
            if(vis[i] == 1)continue;
            vis[i] = 1;
            result[cnt] = arr[i];
            dfs(i, cnt+1);
            vis[i] = 0;
        }
    }
}
