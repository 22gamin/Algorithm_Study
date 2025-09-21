package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S2383 {
    public static class pair{
        int x,y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] arr;
    static int[] vis;
    static int n, minnum, stair1x, stair1y, stair1c, stair2x, stair2y, stair2c;
    static List<pair> li;
    static List<int[]> stair;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 계단의 입구는 반드시 2개
        // 다익스트라?

        // 사람(최대10명) 두 그룹으로 나누기 10명이면 터지려나 그럼 dp인가.. 근데 나 dp 못 풀어
        // 맨해튼거리로 최단거리 구하기, 예시(2 3 4, 1 3 3)

        // 그룹의 사람 수가 해당 3보다 작거나 같을 경우 계단 최대시간 반환
        // 그룹의 사람 수가 해당 3보다 클 경우 (2 2 2 3) 계단수 = 2
        // 오름차순 정렬 -> 최솟값*계단수 > 다음 사람 => +(다음사람*계단수)
        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test<=t; test++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            li = new ArrayList<>();
            for(int i=0; i<n; i++) li = new ArrayList<>();
            stair = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j]==1) li.add(new pair(i,j));
                    if(arr[i][j]>1){
                        stair.add(new int[]{i,j,arr[i][j]});
                    }
                }
            }

            stair1x = stair.get(0)[0];
            stair1y = stair.get(0)[1];
            stair1c = stair.get(0)[2];

            stair2x = stair.get(1)[0];
            stair2y = stair.get(1)[1];
            stair2c = stair.get(1)[2];
            minnum = Integer.MAX_VALUE;
            vis = new int[10];
            // dfs 부분 집합
            dfs(0);
            System.out.println("#"+test+" "+minnum);
        }
    }
    public static void dfs(int cnt){
        if(cnt == li.size()){
            List<Integer> fir = new ArrayList<>();
            List<Integer> sec = new ArrayList<>();
            for(int i=0; i<li.size(); i++){
                pair cur = li.get(i);
                if(vis[i] == 1){
                    int a = bfs(cur.x, cur.y, stair1x, stair1y);
                    fir.add(a+1);
                }else {
                    int a = bfs(cur.x, cur.y, stair2x, stair2y);
                    sec.add(a+1);
                }
            }
            int len1=0, len2=0;
            if(!fir.isEmpty()) len1 = chk(fir, stair1c);
            if(!sec.isEmpty()) len2 = chk(sec, stair2c);
            int tmpmax = Math.max(len1, len2);
            minnum = Math.min(tmpmax, minnum);
            return;
        }

        vis[cnt] = 1;
        dfs(cnt+1);
        vis[cnt] = 0;
        dfs(cnt+1);
    }
    public static int bfs(int a, int b, int stx, int sty){
        return Math.abs(a - stx) + Math.abs(b - sty);
    }
    public static int chk(List<Integer> gro, int stairnum){
        // 도착하고 내려가기시작 반영
        // stairnum+=1;
        Collections.sort(gro);
        if(gro.size()<=3){
            int b = gro.size()-1;
            return gro.get(b) + stairnum;
        }else{
            // 그룹의 사람 수가 해당 3보다 클 경우 (2 2 2 3) 계단수 = 2
            // 오름차순 정렬 -> 최솟값+계단수 > 다음 사람 => +(다음사람+계단수)
            int time = gro.get(0)+stairnum;
            int idx = 3;
            for(int i=0; i<gro.size(); i++){
                // 대기자 있을 경우
                if(gro.size() >= 1+idx){
                    // 다음 대기자가 바로 계단 내려갈 수 있는 경우
                    if(time>=gro.get(idx)){
                        time += stairnum;
                    }else {
                        int betweentime = gro.get(idx) - time;
                        time += betweentime;
                        time += stairnum;
                    }
                    idx++;
                }else break;
            }
            return time;
        }
    }
}
