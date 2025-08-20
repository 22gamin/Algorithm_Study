package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test=1; test<= 10; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            List<Integer>[] li = new ArrayList[101];
            int[] vis = new int[101];
            int[] count = new int[101];
            for(int i=1; i<=100; i++) li[i] = new ArrayList<>();
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i=0; i<n/2; i++) {
                int fro = Integer.parseInt(st1.nextToken());
                int too = Integer.parseInt(st1.nextToken());
                li[fro].add(too);
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            vis[start] = 1;
            int cnt =0, result =0;

            while(!q.isEmpty()) {
                int len = q.size();
                int maxnum = Integer.MIN_VALUE;
                for(int i=0; i<len; i++) {
                    int cur = q.poll();
                    if(maxnum<cur) maxnum = cur;
                    for(int c : li[cur]) {
                        if(vis[c] == 1)continue;
                        vis[c] = 1;
                        q.add(c);
                    }
                }
                // 방문 순서
                // cnt++;
                // count[cur] = cnt;
                result = maxnum;
            }
            System.out.println("#"+test+" "+ result);
        }
    }
}
