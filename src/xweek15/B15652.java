package xweek15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15652 {
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(1,0);
    }
    public static void dfs(int start, int cnt){
        if(cnt == m){
            for(int c : arr){
                System.out.print(c+" ");

            }
            System.out.println();
            return;
        }
        for(int i = start; i<=n; i++){
            arr[cnt] = i;
            dfs(i, cnt+1);
        }
    }
}
