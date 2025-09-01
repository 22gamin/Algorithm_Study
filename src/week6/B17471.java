package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17471 {
    static int[] arr, vis;
    static int n, minnum;
    static List<Integer>[] li;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        li = new ArrayList[n+1];
        vis = new int[n+1];
        for(int i=1; i<=n; i++) li[i] = new ArrayList<>();
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<num; j++){
                int a = Integer.parseInt(st.nextToken());
                li[i].add(a);
            }
        }
        minnum = Integer.MAX_VALUE;
        // subset
        subset(1);
        if(minnum == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minnum);
    }
    public static void subset(int cnt){
        if(cnt == n+1){
            List<Integer> fir = new ArrayList<>();
            List<Integer> sec = new ArrayList<>();
            int firlen = 0, seclen = 0;
            for(int i = 1; i<=n; i++){
                if(vis[i] == 1){
                    fir.add(i);
                    firlen+=arr[i];
                }else{
                    sec.add(i);
                    seclen+=arr[i];
                }
            }
            if(fir.isEmpty()|| sec.isEmpty()) return;
            else{
                if(chk(fir) && chk(sec)){
                    minnum = Math.min(minnum, Math.abs(firlen - seclen));
                }
                return;
            }
        }
        vis[cnt] = 1;
        subset(cnt+1);
        vis[cnt] = 0;
        subset(cnt+1);
    }
    public static boolean chk(List<Integer> arr){
        if(arr.size()<=1) return true;
        Queue<Integer> q = new LinkedList<>();
        q.add(arr.get(0));
        int count = 1;
        int[] arrvis = new int[n+1];
        arrvis[arr.get(0)] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int c : li[cur]){
                if(arr.contains(c) && arrvis[c] == 0) {
                    arrvis[c] = 1;
                    q.add(c);
                    count++;
                }
            }
        }
        return count == arr.size();
    }
}
// 3055