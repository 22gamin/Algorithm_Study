package xweek10;

import java.util.*;
import java.io.*;

public class b_1992 {
    static int N;
    static int[][] graph;
    static String answer="";

    static void div(int row, int col,int n) {	//(x, y, 길이)

        int sum = 0;
        for(int i = row; i<row+n; i++) {
            for(int j = col; j<col+n; j++) {
                sum += graph[i][j];
            }
        }
        if(sum == 0) {
            answer += '0';
            return ;
        }
        else if (sum ==n*n) {
            answer += '1';
            return ;
        }
        n /= 2;

        answer += "(";
        div(row,col,n);
        div(row,col+n,n);
        div(row+n,col,n);
        div(row+n,col+n,n);
        answer += ")";
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int n = 0; n<N; n++) {
            String str = br.readLine();
            for(int nn = 0; nn<N; nn++) {
                graph[n][nn] = str.charAt(nn) - '0';
            }
        }
        //입력 끝
        div(0,0,N);

        System.out.println(answer);
    }

}

