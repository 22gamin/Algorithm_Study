package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2382 {
    private static class Node implements Comparable<Node>{
        public int x, y, cost, d;
        public Node(int x, int y, int cost, int d){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.d =d;
        }
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0,-1,1,0,0};
        int[] dy = {0,0,0,-1,1};
        int t = Integer.parseInt(br.readLine());
        for(int test= 1; test<=t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            List<Node>li = new ArrayList<>();
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int co = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());;
                li.add(new Node(a, b, co, dir));
            }
            for(int p =0; p<m; p++){
                // 이동
                List<Node>[][] nextli = new ArrayList[n][n];
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        nextli[i][j] = new ArrayList<>();
                    }
                }
                for(Node cur : li){
                    int nx = cur.x + dx[cur.d];
                    int ny = cur.y + dy[cur.d];
                    // 약물안에 있으면 방향, 수/2
                    if(nx == 0 || nx==n-1 || ny== 0|| ny==n-1){
                        if(cur.d == 1) cur.d = 2;
                        else if(cur.d == 2) cur.d = 1;
                        else if(cur.d == 3) cur.d = 4;
                        else if(cur.d == 4) cur.d = 3;
                        cur.cost = cur.cost/2;
                    }
                    nextli[nx][ny].add(new Node(nx, ny, cur.cost, cur.d));
                }
                // 체크
                List<Node> tmpli = new ArrayList<>();
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        if(nextli[i][j].isEmpty()) continue;
                        else if(nextli[i][j].size() == 1){
                            tmpli.add(nextli[i][j].get(0));
                        }else{
                            int sumcost = 0, maxcost=0, maxd = 0;
                            for(Node cur : nextli[i][j]){
                                sumcost+=cur.cost;
                                if(maxcost<cur.cost){
                                    maxcost = cur.cost;
                                    maxd = cur.d;
                                }
                            }
                            tmpli.add(new Node(i,j,sumcost, maxd));
                        }
                    }
                }
                li = tmpli;
            }
            int totalcost = 0;
            for(Node c : li){
                totalcost+=c.cost;
            }
            System.out.println("#"+test+" "+totalcost);
        }
    }
}
