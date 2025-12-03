package xweek19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B23324 {
    static int[] arr;
    static int nodex, nodey;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(i+1 == k) {
                nodex = a;
                nodey = b;
                continue;
            }
            uni(a, b);
        }

        int[] count = new int[n+1];
        // root별로 트리 노드 수 세기
        int tmp = fin(1);
        boolean chk = true;
        for(int i = 1; i<=n; i++){
            int a = fin(i);
            count[a]++;
            if(tmp!=a)chk = false;
        }
        // 한번에 다 묶여있다
        if(chk){
            System.out.println(0);
            return;
        }

        int xx = fin(nodex);
        int yy = fin(nodey);

        long total = (long)count[xx]*(long)count[yy];
        System.out.println(total);
    }

    public static int fin(int c){
        if(arr[c] == c) return c;
        return arr[c] = fin(arr[c]);
    }

    public static void uni(int a, int b){
        int fir = fin(a);
        int sec = fin(b);
        if(fir == sec) return;
        arr[sec] = fir;
        return;
    }
}
