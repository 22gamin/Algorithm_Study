import java.util.*;
import java.io.*;

public class swea_1873_김민종 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dx = {-1, 1, 0, 0};       //상 하 좌 우 순서
        int[] dy = {0, 0, -1, 1};
        char[] tankdir = {'^', 'v', '<', '>'};

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];
            int X = 0;                      //탱크 x좌표
            int Y = 0;                      //탱크 y좌표
            int dir = 0;                    //탱크 방향

            for(int i = 0; i < H; i++){
                String line = br.readLine();
                for(int j = 0; j < W; j++){
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == '^'){
                        X = i;
                        Y = j;
                        dir = 0;
                    }else if(map[i][j] == 'v'){
                        X = i;
                        Y = j;
                        dir = 1;
                    }else if(map[i][j] == '<'){
                        X = i;
                        Y = j;
                        dir = 2;
                    }else if(map[i][j] == '>'){
                        X = i;
                        Y = j;
                        dir = 3;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String command = br.readLine();

            for (char cmd : command.toCharArray()) {
                if (cmd == 'S') { // 포탄 발사
                    int bulletX = X;
                    int bulletY = Y;

                    while (true) {
                        bulletX += dx[dir];
                        bulletY += dy[dir];

                        if (bulletX < 0 || bulletX >= H || bulletY < 0 || bulletY >= W) {
                            break;
                        }

                        if (map[bulletX][bulletY] == '*') {
                            map[bulletX][bulletY] = '.';
                            break;
                        }

                        if (map[bulletX][bulletY] == '#') {
                            break;
                        }
                    }
                } else { // 이동
                    int newDir = -1;
                    if (cmd == 'U') newDir = 0;
                    else if (cmd == 'D') newDir = 1;
                    else if (cmd == 'L') newDir = 2;
                    else if (cmd == 'R') newDir = 3;

                    map[X][Y] = tankdir[newDir];
                    dir = newDir;

                    int newX = X + dx[newDir];
                    int newY = Y + dy[newDir];

                    if (newX >= 0 && newX < H && newY >= 0 && newY < W && map[newX][newY] == '.') {
                        map[X][Y] = '.';
                        X = newX;
                        Y = newY;
                        map[X][Y] = tankdir[newDir];
                    }
                }
            }
        }
    }
}
