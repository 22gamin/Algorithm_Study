package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1873 {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test=1; test<=t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Character[][] matrix = new Character[h][w];
            int x = -1, y = -1;
            for(int i=0; i<h; i++) {
                String a = br.readLine();
                for(int j=0; j<w; j++) {
                    Character c = a.charAt(j);
                    matrix[i][j] = c;
                    // 어차피 하나
                    if (matrix[i][j] == '>' || matrix[i][j] == '<' || matrix[i][j] == '^' || matrix[i][j] == 'v') {
                        x = i;
                        y = j;
                    }
                }
            }
            int n = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for (char command : commands.toCharArray()) {
                // shoot
                if (command == 'S') {

                    char direction = matrix[x][y];
                    int bulletX = x;
                    int bulletY = y;

                    while (true) {
                        if (direction == '^') bulletX--;
                        else if (direction == 'v') bulletX++;
                        else if (direction == '<') bulletY--;
                        else if (direction == '>') bulletY++;

                        if (bulletX < 0 || bulletX >= h || bulletY < 0 || bulletY >= w) {
                            break;
                        }
                        // 벽돌
                        if (matrix[bulletX][bulletY] == '*') {
                            matrix[bulletX][bulletY] = '.';
                            break;
                        }
                        // 강철
                        if (matrix[bulletX][bulletY] == '#') {
                            break;
                        }
                    }
                } else {

                    int nextX = x;
                    int nextY = y;
                    char nextDir = ' ';

                    if (command == 'U') {
                        nextDir = '^';
                        nextX--;
                    } else if (command == 'D') {
                        nextDir = 'v';
                        nextX++;
                    } else if (command == 'L') {
                        nextDir = '<';
                        nextY--;
                    } else if (command == 'R') {
                        nextDir = '>';
                        nextY++;
                    }

                    // 방향
                    matrix[x][y] = nextDir;
                    if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && matrix[nextX][nextY] == '.') {
                        matrix[nextX][nextY] = matrix[x][y];
                        matrix[x][y] = '.';
                        x = nextX;
                        y = nextY;
                    }
                }

            }
            System.out.print("#" + test + " ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
