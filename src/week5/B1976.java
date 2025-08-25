package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 1){
                    uni(i, j);
                }
            }
        }
        int tmp=0, chk=0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=1; i<=m; i++){
            int city = Integer.parseInt(st1.nextToken());
            if(fin(city) != tmp && i != 1) {
                chk = 1;
                break;
            }
            tmp = fin(city);
        }
        if(chk == 1) System.out.print("NO");
        else System.out.print("YES");
    }
    public static int uni(int a, int b){
        int fir = fin(a);
        int sec = fin(b);
        if(fir == sec) return 0;
        arr[sec] = fir;
        return 1;
    }
    public static int fin(int c){
        if(arr[c] == 0) return c;
        return arr[c] = fin(arr[c]);
    }
}