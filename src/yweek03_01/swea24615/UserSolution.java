package yweek03_01.swea24615;

import java.util.*;

class UserSolution{

    int n;
    int maxstamina;
    int[][] map;

    boolean exist[];
    boolean visit[][];
    ArrayList<ArrayList<int[]>> al;

    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    // 초기화
    void init(int N, int mMaxStamina, int mMap[][]){
        n = N;
        maxstamina = mMaxStamina;
        map = mMap;

        exist = new boolean[202];
        al = new ArrayList<>();
        for(int i=0; i<202; i++){
            al.add(new ArrayList<>());
        }
        return;
    }

    // gateid를 기존 map에 +1 해서 넣기
    void addGate(int mGateID, int mRow, int mCol){
        int gateid = mGateID+1;
        visit = new boolean[n][n];
        exist[gateid] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{mRow, mCol, 0});
        visit[mRow][mCol] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int xx = cur[0];
            int yy = cur[1];
            int stam = cur[2];
            for(int d=0; d<4; d++){
                int nx = xx + dx[d];
                int ny = yy + dy[d];
                if(nx<0 || nx>=n || ny<0 ||ny>=n) continue;

                if(visit[nx][ny] || map[nx][ny] == 1) continue;
                visit[nx][ny] = true;
                // 기둥이 아니면
                if(map[nx][ny] != 0){
                    al.get(gateid).add(new int[]{map[nx][ny], stam + 1});
                    al.get(map[nx][ny]).add(new int[]{gateid, stam + 1});
                }
                // 체력이 아직 괜찮으면
                if(stam+1 < maxstamina){
                    q.offer(new int[]{nx,ny, stam+1});
                }
            }
        }
        map[mRow][mCol] = gateid;
        return;
    }

    void removeGate(int mGateID){
        exist[mGateID + 1] = false;
    }

    // int id로 주어짐
    int getMinTime(int mStartGateID, int mEndGateID) {
        int startid = mStartGateID + 1;
        int endid = mEndGateID + 1;

        int dist[] = new int[202];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startid] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1]-n2[1]);
        pq.add(new int[]{startid, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int st = cur[0];
            int cost = cur[1];
            for(int i=0; i<al.get(st).size();  i++){
                int[] now = al.get(st).get(i);

                if(!exist[now[0]]) continue;

                if(dist[now[0]] > cost + now[1]){
                    dist[now[0]] = cost + now[1];
                    pq.add(new int[]{now[0], dist[now[0]]});
                }
            }
        }
        return dist[endid] == Integer.MAX_VALUE ? -1 : dist[endid];
    }
}