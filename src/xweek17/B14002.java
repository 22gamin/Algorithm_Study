package xweek17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[1001];
        int maxnum = 0;

        // 1 
        for(int i=0; i<n; i++) dp[i] = 1;

        for(int i=0; i<n; i++){
            for(int j = 0; j<i; j++){
                // 오름차순이면
                if(arr[i]>arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxnum = Math.max(dp[i], maxnum);
        }

        System.out.println(maxnum);
        int[] li = new int[n];
        int cnt=0;
        for(int i = n-1; i>=0; i--){
            //System.out.print(dp[i]+" ");
            if(dp[i] == maxnum){
                li[cnt++] = (arr[i]);
                maxnum--;
            }
        }
        System.out.println();
        for(int i = cnt-1; i>=0; i--){
            System.out.print(li[i]+" ");
        }
    }
}
