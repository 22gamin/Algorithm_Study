package yweek0219;

import java.util.*;


class UserSolution{

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    // n, map, stamina
    static int n;
    static int map[][];
    static int stamina;
    static boolean exist[];
    static boolean visit[][];

    // 인접리스트
    ArrayList<ArrayList<int[]>> al;

    // 초기화
    void init(int N, int mMaxStamina, int mMap[][]){

        n = N;
        stamina = mMaxStamina;
        map = mMap;

        exist = new boolean[202];
        al = new ArrayList<>();
        for(int i=0; i<202; i++){
            al.add(new ArrayList<>());
        }
        return;
    }

    void addGate(int mGateID, int mRow, int mCol){
        visit = new boolean[n][n];

        // exist에 id 추가
        exist[mGateID + 1] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{mRow, mCol, 0});
        visit[mRow][mCol] = true;

        while(!q.isEmpty()){
            int now[] = q.poll();
            int xx = now[0];
            int yy = now[1];
            int cnt = now[2];

            for(int d = 0; d<4; d++){
                int nx = xx + dx[d];
                int ny = yy + dy[d];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(map[nx][ny] != 1 && visit[nx][ny] == false){
                    visit[nx][ny] = true;
                    // 게이트라면
                    if(map[nx][ny] != 0){
                        al.get(mGateID + 1).add(new int[]{map[nx][ny], cnt + 1});
                        al.get(map[nx][ny]).add(new int[]{mGateID + 1, cnt + 1});
                    }
                    if(cnt+1<stamina){
                        q.offer(new int[]{nx, ny, cnt+1});
                    }
                }
            }
        }
        map[mRow][mCol] = mGateID+1;
        return;
    }

    void removeGate(int mGateID){
        exist[mGateID+1] = false;
        return;
    }

    // int id로 주어짐
    int getMinTime(int mStartGateID, int mEndGateID){
        int start = mStartGateID + 1;
        int end = mEndGateID + 1;

        // 다익스트라
        int dist[] = new int[202];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            // 목적게이트라면 break
            if(now[0] == end) break;

            for(int i = 0; i < al.get(now[0]).size(); i++){
                int[] cur = al.get(now[0]).get(i);

                if(!exist[cur[0]]) continue;
                if(dist[cur[0]] > now[1] + cur[1]){
                    dist[cur[0]] = now[1] + cur[1];
                    pq.add(new int[]{cur[0], dist[cur[0]]});
                }
            }
        }
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }
}