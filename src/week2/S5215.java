package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class S5215 {
    static int maxScore;
     
    static void dfs(int idx, int currentScore, int currentCal, int[] scores, int[] calories, int limitCal) {
        if(currentCal>limitCal) return;
         
        maxScore=Math.max(maxScore, currentScore);
         
        if(idx==scores.length) return;
         
        //현재 재료 선택
        dfs(idx+1, currentScore+scores[idx], currentCal+calories[idx], scores,calories,limitCal);
        //현재재료 선택하지 않음
        dfs(idx + 1, currentScore, currentCal, scores, calories, limitCal);
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
         
        for(int t=1;t<=T;t++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int limitCal=Integer.parseInt(st.nextToken());
             
            int[] scores=new int[n];
            int[] calories=new int[n];
             
            for(int i=0;i<n;i++) {
                st=new StringTokenizer(br.readLine());
                scores[i]=Integer.parseInt(st.nextToken());
                calories[i]=Integer.parseInt(st.nextToken());
            }
             
            maxScore=0;
            dfs(0,0,0,scores,calories,limitCal); 
            System.out.println("#" + t + " " + maxScore);
        }
 
    }
 
}