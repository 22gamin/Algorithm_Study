package beakjoon;

import java.util.*;
import java.io.*;

public class b_1932 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();

        for(int c = 0; c <n; c++){
            list.add(new ArrayList<>());
        }
        int[][] dp = new int[n][n];

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j<i+1; j++){
                int a = Integer.parseInt(st.nextToken());
                if(j==0){
                    dp[i][j] = a;
                }
                list.get(i).add(a);
            }
        } //입력 끝

        dp[0][0] = list.get(0).get(0);

        int max = dp[0][0];
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i+1; j++){
                if (j==0){
                    dp[i][j] = list.get(i).get(j) + dp[i-1][j];
                }
                else {
                    dp[i][j] = list.get(i).get(j) + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(max);
    }
}
