package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3234 {
    static int[] arr;
    static int[] vis;
    static int n, total=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test<=t; test++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            vis = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            total=0;
            // 순열
            dfs(0,0,0);
            System.out.println("#"+test+" "+total);
        }
    }
    public static void dfs(int depth, int right, int left){
        if(depth == n){
            total++;
            return;
        }
        for(int i=0; i<n; i++){
            if(vis[i] == 0) {
                vis[i] = 1;
                // left에는 무조건 먼저 얹기
                dfs(depth+1, right, left+arr[i]);
                if(right + arr[i] <= left) dfs(depth+1,right+arr[i], left );
                vis[i] = 0;
            }
        }
    }
}