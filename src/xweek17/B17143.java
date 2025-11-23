package xweek17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17143 {
    public static class triple{
        int s, d, z;
        public triple(int s, int d, int z){
            this.s = s;
            this.d = d;
            this.z =z;
        }
    }
    static int totalcount = 0, R, C;
    static triple[][] map, tmpmap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new triple[R+1][C+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int sharkx = Integer.parseInt(st.nextToken());
            int sharky = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // s는 속력, d는 이동 방향, z는 크기
            map[sharkx][sharky] = new triple(a, b, c);
        }
        int nowloc = 0;
        // 낚시왕이 (0,0)부터 (0,C-1)까지 이동
        for(int t=0; t<C; t++){
            // 낚시왕 현재 열 갱신
            nowloc+=1;

            // 상어 잡기
            catchShark(nowloc, R);

            // 상어 이동
            tmpmap = new triple[R+1][C+1];
            for(int i=1; i<=R; i++ ){
                for(int j=1; j<=C; j++){
                    if(map[i][j] == null) continue;
                    moveShark(i, j);
                }
            }
            // 이동 후 갱신
            map = tmpmap;
        }
        System.out.println(totalcount);
    }

    public static void moveShark(int i, int j){
        int ii = i;
        int jj = j;

        triple tmpshark = map[i][j];

        int d = tmpshark.d;
        int z = tmpshark.z;
        int s = tmpshark.s;
        // d  = 1(위), 2 = 2(아래), 3 = 3(오른쪽), 4 = 4(왼쪽)
        while (s > 0) {
            if (d == 1) { // 위
                // 벽 전까지
                if (ii - 1 >= s) {
                    ii -= s;
                    s = 0;
                }
                // 벽
                else {
                    s -= (ii - 1);
                    ii = 1;
                    d = 2; // 아래로
                }
            }
            // 아래
            else if (d == 2) {
                if (R - ii >= s) {
                    ii += s;
                    s = 0;
                } else {
                    s -= (R - ii);
                    ii = R;
                    d = 1; // 위로
                }
            }
            // 오른쪽
            else if (d == 3) {
                if (C - jj >= s) {
                    jj += s;
                    s = 0;
                } else {
                    s -= (C - jj);
                    jj = C;
                    d = 4; // 왼쪽으로
                }
            }
            // 왼쪽
            else if (d == 4) {
                if (jj - 1 >= s) {
                    jj -= s;
                    s = 0;
                } else {
                    s -= (jj - 1);
                    jj = 1;
                    d = 3; // 오른쪽으로
                }
            }
        }

        tmpshark.d = d;

        // 바뀐 상어 위치 저장

        // 같은 위치에 상어 있으면
        if (tmpmap[ii][jj] != null) {
            if (tmpmap[ii][jj].z < z) {
                tmpmap[ii][jj] = tmpshark;
            }
        } else {
            tmpmap[ii][jj] = tmpshark;
        }

    }

    public static void catchShark(int col, int R){
        for(int i=1; i<=R; i++){
            if(map[i][col] != null){
                totalcount+=map[i][col].z;
                map[i][col] = null;
                return;
            }
        }
    }
}
