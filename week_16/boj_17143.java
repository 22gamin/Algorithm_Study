import java.io.*;
import java.util.*;

class Shark {
    int r, c, s, d, z;

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

public class boj_17143 {
    static int R, C, M;
    static Shark[][] map;
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r, c, s, d, z);
        }

        // 낚시꾼은 0번 열부터 C-1열까지 이동
        for (int i = 0; i < C; i++) {
            // 상어 잡기
            catching(i);

            // 상어 잡고 상어 무빙 침
            moving();
        }

        System.out.println(sum);
    }

    public static void catching(int col) {
        for (int row = 0; row < R; row++) {
            if (map[row][col] != null) {
                sum += map[row][col].z;
                map[row][col] = null;
                return;
            }
        }
    }

    public static void moving() {
        Shark[][] nextMap = new Shark[R][C];

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (map[row][col] != null) {
                    Shark shark = map[row][col];

                    int newR = shark.r;
                    int newC = shark.c;
                    int newD = shark.d;
                    int speed = shark.s;

                    if (newD <= 2) { // 상하 이동
                        speed %= (R - 1) * 2;
                        for (int i = 0; i < speed; i++) {
                            // ▼▼▼▼▼▼▼ [수정된 로직] ▼▼▼▼▼▼▼
                            if (newD == 1) { // 위로 이동
                                newR--;
                                if (newR < 0) { // 벽에 부딪힘
                                    newR = 1;
                                    newD = 2; // 방향 전환
                                }
                            } else { // 아래로 이동 (newD == 2)
                                newR++;
                                if (newR >= R) { // 벽에 부딪힘
                                    newR = R - 2;
                                    newD = 1; // 방향 전환
                                }
                            }
                            // ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
                        }
                    } else { // 좌우 이동
                        speed %= (C - 1) * 2;
                        for (int i = 0; i < speed; i++) {
                            // ▼▼▼▼▼▼▼ [수정된 로직] ▼▼▼▼▼▼▼
                            if (newD == 4) { // 왼쪽으로 이동
                                newC--;
                                if (newC < 0) { // 벽에 부딪힘
                                    newC = 1;
                                    newD = 3; // 방향 전환
                                }
                            } else { // 오른쪽으로 이동 (newD == 3)
                                newC++;
                                if (newC >= C) { // 벽에 부딪힘
                                    newC = C - 2;
                                    newD = 4; // 방향 전환
                                }
                            }
                            // ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
                        }
                    }

                    Shark movedShark = new Shark(newR, newC, shark.s, newD, shark.z);

                    if (nextMap[newR][newC] == null) {
                        nextMap[newR][newC] = movedShark;
                    } else {
                        if (nextMap[newR][newC].z < movedShark.z) {
                            nextMap[newR][newC] = movedShark;
                        }
                    }
                }
            }
        }

        map = nextMap;
    }
}
