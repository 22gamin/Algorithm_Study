package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S5644 {
    static public class Pair{
        public int x, y, c, p;
        public Pair(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0 1 2 3 4
        int[] dy = {0,-1,0, 1, 0};
        int[] dx = {0,0,1,0,-1};
        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test<=t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            //int[][] matrix = new int[11][11];
            int[] firmem = new int[m];
            int[] secmem = new int[m];
            int total=0;
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) firmem[i] = Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) secmem[i] = Integer.parseInt(st2.nextToken());

            Pair[] bs = new Pair[a];
            for(int i=0; i<a; i++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine());

                int b = Integer.parseInt(st3.nextToken());
                int h = Integer.parseInt(st3.nextToken());
                int r = Integer.parseInt(st3.nextToken());
                int e = Integer.parseInt(st3.nextToken());
                bs[i] = new Pair(b,h,r,e);
            }
            int fx = 1, fy = 1;
            int lx = 10, ly = 10;

            // 초
            for(int i=0; i<=m; i++) {
                List<Integer> arr = new ArrayList<>();
                List<Integer> arr2 = new ArrayList<>();
                // bc들 모두 비교
                for(int j=0; j<a; j++) {
                    if(distance(fx, fy, bs[j].x, bs[j].y)<=bs[j].c) {
                        arr.add(j);
                    }
                    if(distance(lx, ly, bs[j].x, bs[j].y)<=bs[j].c) {
                        arr2.add(j);
                    }
                }
                int maxnum = 0;
                if(arr.isEmpty() && arr2.isEmpty()){} //continue;
                else if(arr2.isEmpty()) {
                    for(int tmp : arr) {
                        if(maxnum<bs[tmp].p) maxnum = bs[tmp].p;
                    }
                }else if(arr.isEmpty()) {
                    for(int tmp : arr2) {
                        if(maxnum<bs[tmp].p) maxnum = bs[tmp].p;
                    }
                }else {
                    for(int tmp1 : arr) {
                        for(int tmp2 : arr2) {
                            int charge=0;
                            if(tmp1 == tmp2) {
                                charge = bs[tmp1].p;
                            }else {
                                charge = (bs[tmp1].p + bs[tmp2].p);
                            }
                            maxnum = Math.max(charge, maxnum);
                        }
                    }
                }
                total+=maxnum;
                if(i<m) {
                    fx+=dx[firmem[i]];
                    fy+=dy[firmem[i]];
                    lx+=dx[secmem[i]];
                    ly+=dy[secmem[i]];
                }

            }
            System.out.println("#"+test+" "+ total);
        }
    }
    public static int distance(int X, int Y, int fir, int sec) {
        int tmpDistance = Math.abs(X-fir) + Math.abs(Y-sec);
        return tmpDistance;
    }
}
