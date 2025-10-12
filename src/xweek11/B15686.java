package xweek11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B15686 {
    public static class node implements Comparable<node>{
        int x, y, cost;
        public node(int x, int y, int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
        public int compareTo(node other){
            return this.cost - other.cost;
        }
    }
    public static List<int[]> li, home;
    static int n, m, mintotal = Integer.MAX_VALUE;
    static int[] vis;
    public static void main(String[] args) throws IOException {
        // 집 들의 중심 (평균) 좌표 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        li = new ArrayList<>();
        home = new ArrayList<>();

        int homecnt = 0;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 1) {
                    home.add(new int[]{i,j});
                    homecnt++;
                }else if(a == 2){
                    li.add(new int[]{i, j});
                }
            }
        }
        vis = new int[m];
        comb(0,0);
        System.out.println(mintotal);
    }
    public static void comb(int start, int cnt){
        if(cnt == m){
            caldist();
            return;
        }
        for(int i=start; i<li.size(); i++){
            vis[cnt] = i;
            comb(i+1, cnt+1);
        }
    }
    public static void caldist(){
        int total = 0;
        for(int[] homes : home){
            int mindist = Integer.MAX_VALUE;

            for(int chicken : vis){
                int[] chi = li.get(chicken);
                int dist = Math.abs(homes[0] - chi[0]) + Math.abs(homes[1] - chi[1]);
                mindist = Math.min(mindist, dist);
            }
            total+=mindist;
        }
        mintotal = Math.min(mintotal, total);
    }
}
