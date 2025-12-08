package xweek19;

import java.util.*;
import java.io.*;

public class b_1914 {
    static StringBuilder sb = new StringBuilder();

    static void find(int N, int start, int mid, int end){
        if(N == 1){
            sb.append(start).append(" ").append(end).append("\n");
            return ;
        }

        find(N - 1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        find(N - 1, mid, start, end);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        BigInteger count = new BigInteger("2");
        count = count.pow(N).subtract(BigInteger.ONE);
        
        System.out.println(count);

        if (N <= 20) {
            find(N, 1, 2, 3);
            System.out.print(sb);
        }
    }
}
