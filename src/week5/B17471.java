package week5;

import java.awt.SystemTray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17471 {
    static int[] arr, vis;
    static List<Integer>[] li;
    static int n, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        li = new ArrayList[n+1];
        for(int i=1; i<=n; i++) li[i] = new ArrayList<>();
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++){
                int a = Integer.parseInt(st.nextToken());
                li[i].add(a);
            }
        }
        tmp = Integer.MAX_VALUE;
        vis = new int[n+1];
        subset(1);
        if(tmp == Integer.MAX_VALUE) tmp = -1;
        System.out.print(tmp);
    }
    private static void subset(int cnt){
        if(cnt == n+1){
            // 각 리스트에 넣기
            List<Integer> fir = new ArrayList<>();
            List<Integer> sec = new ArrayList<>();
            int firlen = 0, seclen = 0;
            for(int i=1; i<=n; i++){
                if(vis[i] == 1){
                    fir.add(i);
                    firlen+=arr[i];
                }
                else {
                    sec.add(i);
                    seclen+=arr[i];
                }
            }
            if(fir.isEmpty() || sec.isEmpty()) return;
            if(isable(fir) && isable(sec)){
                tmp = Math.min(tmp, Math.abs(firlen - seclen));
            }
            return;
        }

        vis[cnt] = 1;
        subset(cnt+1);
        vis[cnt] = 0;
        subset(cnt+1);
    }
    private static boolean isable(List<Integer> country){
        if(country.size() <=1) return true;
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(country.get(0));
        int[] grovis = new int[n+1];
        grovis[country.get(0)] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int c : li[cur]){
                if(country.contains(c) && grovis[c] == 0) {
                    count++;
                    grovis[c] = 1;
                    q.offer(c);
                }

            }
        }
        if(count == country.size()) return true;
        else return false;
    }
}
