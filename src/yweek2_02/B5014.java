package yweek2_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        // s에서 g로 가야함
        if(s == g){
            System.out.println(0);
            return;
        }
        int[] arr = {u, -d};
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int[] vis = new int[f+1];
        while(!q.isEmpty()){
            int cur = q.poll();;
            for(int i=0; i<2; i++){
                int t = arr[i]+cur;
                if(t<=0 || t>f || vis[t] > 0 || t == cur) continue;
                if(t == g){
                    System.out.println(vis[cur]+1);
                    return;
                }
                vis[t] = vis[cur]+1;
                q.add(t);
            }
        }
        System.out.println("use the stairs");
    }
}
