package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class S1873 {
    static int H, W;
    static char[][] map;
    static int x, y;  // 전차 위치
    static int dir;   // 전차 방향 (0:위, 1:아래, 2:왼쪽, 3:오른쪽)
 
    static int[] dx = {-1, 1, 0, 0}; // 위, 아래, 왼쪽, 오른쪽
    static int[] dy = {0, 0, -1, 1};
    static char[] tankChar = {'^', 'v', '<', '>'};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
 
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '^') {
                        x = i; y = j; dir = 0;
                    } else if (map[i][j] == 'v') {
                        x = i; y = j; dir = 1;
                    } else if (map[i][j] == '<') {
                        x = i; y = j; dir = 2;
                    } else if (map[i][j] == '>') {
                        x = i; y = j; dir = 3;
                    }
                }
            }
 
            int N = Integer.parseInt(br.readLine());
            String commands = br.readLine();
 
            for (int i = 0; i < N; i++) {
                char cmd = commands.charAt(i);
                action(cmd);
            }
 
            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
 
    // 명령 실행
    static void action(char cmd) {
        if (cmd == 'U') {
            dir = 0;
            map[x][y] = '^';
            move();
        } else if (cmd == 'D') {
            dir = 1;
            map[x][y] = 'v';
            move();
        } else if (cmd == 'L') {
            dir = 2;
            map[x][y] = '<';
            move();
        } else if (cmd == 'R') {
            dir = 3;
            map[x][y] = '>';
            move();
        } else if (cmd == 'S') {
            shoot();
        }
    }
 
    // 이동 처리
    static void move() {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
            map[x][y] = '.';
            x = nx; y = ny;
            map[x][y] = tankChar[dir];
        }
    }
 
    // 포탄 발사 처리
    static void shoot() {
        int nx = x;
        int ny = y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];
 
            if (nx < 0 || nx >= H || ny < 0 || ny >= W) break; // 맵 밖
            if (map[nx][ny] == '*') { // 벽돌벽
                map[nx][ny] = '.';
                break;
            }
            if (map[nx][ny] == '#') { // 강철벽
                break;
            }
        }
    }
}