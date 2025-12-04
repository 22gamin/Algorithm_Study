package xweek19;

import java.util.*;
import java.io.*;

public class b_11729 {
    static int K;
    static StringBuilder sb = new StringBuilder();

    static void find(int k, int start, int mid, int to){
        if(k==1){
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        find(k-1, start, to, mid);

        sb.append(start).append(" ").append(to).append("\n");
        find(k-1,mid,start, to);
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();

        sb.append((int)(Math.pow(2,K)-1)).append("\n");

        find(K, 1, 2, 3);

        System.out.println(sb);
    }
}
