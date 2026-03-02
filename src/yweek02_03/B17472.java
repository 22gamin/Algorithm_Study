package yweek02_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 번호 매기기
        Queue<int[]> q = new LinkedList<>();
        int[][] islandNum = new int[n][m];
        int num = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // 바다라면, 번호를 이미매겼다면 continue
                if(map[i][j] == 0 || islandNum[i][j] > 0) continue;
                num++;
                q.offer(new int[]{i, j});
                islandNum[i][j] = num;
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    for(int d=0; d<4; d++){
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];
                        if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                        // 바다거나 이미 번호를 매겼다면 continue
                        if(map[nx][ny] == 0 || islandNum[nx][ny] >0) continue;
                        if(map[nx][ny] == 1) {
                            islandNum[nx][ny] = num;
                            q.add(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
        // 다리 잇기
        // 다리를 어떻게 저장하지
        // 1번 섬에서 n번 섬까지 최단거리 bridge[1][n] 으로 저장
        // int[][] bridge = new int[6][6]; -> 두번해야함
        ArrayList<ArrayList<int[]>> al = new ArrayList<>();
        for(int  i=0; i<10; i++){
            al.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(islandNum[i][j] == 0) continue;
                int curnum = islandNum[i][j];
                for(int d = 0; d<4; d++){
                    int nx = i;
                    int ny = j;
                    int c = 0;
                    while(true){
                        nx += dx[d];
                        ny += dy[d];
                        if(nx<0 || nx>=n || ny<0 || ny>=m || islandNum[nx][ny] == curnum) break;

                        if (islandNum[nx][ny] == 0) {
                            // 1. 바다면 다리 길이를 1 증가시키고 계속 직진
                            c++;
                        } else {
                            // 2. 바다가 아니라면 = 다른 섬에 닿았다면!
                            if (c >= 2) {
                                al.get(curnum).add(new int[]{islandNum[nx][ny], c});
                            }
                            // 길이가 1이든 2이든, 다른 섬에 부딪혔으니 무조건 직진을 멈춥니다(break).
                            break;
                        }
                    }
                }
            }
        }

        // 다리 길이 최솟값
        // 지금 연결리스트에 다 들어가있음 -> 마지막 변수인 길이가 제일 짧은것부터 봐야함
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2)-> n1[1] - n2[1]);
        boolean result[] = new boolean[num+1];

        pq.offer(new int[]{1, 0});
        int totallength = 0;
        int connectedisland = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curisland = cur[0];
            int curcost = cur[1];

            if(result[curisland] == true) continue;

            result[curisland] = true;
            totallength += curcost;
            connectedisland ++;

            for(int i=0; i< al.get(cur[0]).size(); i++){
                int[] nxt = al.get(cur[0]).get(i);
                int nxtisland = nxt[0];
                int nxtcost = nxt[1];

                if(!result[nxtisland]) pq.offer(new int[]{nxtisland, nxtcost});

            }
        }
        if(connectedisland == num){
            System.out.println(totallength);
        }else{
            System.out.println(-1);
        }

    }
}
