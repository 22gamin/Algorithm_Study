package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650 {
    static int[] result;
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        comb(0,0,m);
    }
    public static void comb(int start, int depth, int r){
        if(depth == r){
            for(int c : result){
                System.out.print(c+" ");
            }
            System.out.println("");
            return;
        }
        for(int i=start; i<n; i++){
            result[depth] = arr[i];
            comb(i+1, depth+1, r);
        }
    }
}
