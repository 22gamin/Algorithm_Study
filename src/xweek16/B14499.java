package xweek16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14499 {
    static int[]dice = new int[7];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startx = Integer.parseInt(st.nextToken());
        int starty = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++){
            int c = Integer.parseInt(st.nextToken());
            // 다음 이동할 좌표 계산
            int nx = startx + dx[c-1];
            int ny = starty + dy[c-1];
            if (nx<0 || nx >= n|| ny < 0 || ny >= m) {
                continue;
            }
            // 주사위 이동
            dicemove(c);

            // 현재 위치 갱신
            startx = nx;
            starty = ny;

            // 주사위 갱신
            if (map[startx][starty] == 0) {
                map[startx][starty] = dice[6];
            } else {
                dice[6] = map[startx][starty];
                map[startx][starty] = 0;
            }
            System.out.println(dice[1]);
        }
    }
    static void dicemove(int c) {
        int tmp = dice[1];

        if(c == 1) {
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] =tmp;
        }
        else if(c == 2) {
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = tmp;
        }
        else if(c == 3) {
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = tmp;
        }
        else if(c == 4){
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = tmp;
        }
    }
}
