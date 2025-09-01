package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B20040 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        Arrays.fill(arr, -1);
        boolean chk = false;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(uni(a,b,i)){
                chk = true;
                break;
            }
        }
        if(!chk) System.out.println(0);
    }
    public static boolean uni(int a, int b, int num){
        int fir = fin(a);
        int sec = fin(b);
        if(fir == sec){
            System.out.println(num+1);
            return true;
        }
        arr[sec] = fir;
        return false;
    }
    public static int fin(int c){
        if(arr[c] < 0) return c;
        return arr[c] = fin(arr[c]);
    }
}
