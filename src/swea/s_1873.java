package swea;

import java.util.*;
import java.io.*;

public class s_1873 {

    static int H, W, N;
    static String str;
    static char chars[],graph[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i < T + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int H = Integer.parseInt(st.nextToken()); // 세로
            int W = Integer.parseInt(st.nextToken()); // 가로

            graph = new char[H][W];
            // start
            int start_x = 0;
            int start_y = 0;

            for (int j = 0; j < H; j++) {
                str = br.readLine().trim();

                for (int k = 0; k < W; k++) {
                    graph[j][k] = str.charAt(k);

                    //전차 찾기
                    if (graph[j][k] == '>' || graph[j][k] == '<' || graph[j][k] == '^' || graph[j][k] == 'v') {
                        start_x = j;
                        start_y = k;
                    }
                }

            }

            N = Integer.parseInt(br.readLine());
            str = br.readLine();

            chars = new char[N];
            for (int l = 0; l < N; l++) {
                chars[l] = str.charAt(l);
            }

            // ---입력 끝

            // 배틀 시작

            for (char c : chars) {

                // 전차 이동
                if (c == 'U') {
//                    System.out.println("U");
                    graph[start_x][start_y] = '^';

                    // 범위 확인 및 앞에 장애물 확인
                    if (start_x-1 < 0 || start_x-1 >= H || graph[start_x - 1][start_y] == '*'
                            || graph[start_x - 1][start_y] == '#' || graph[start_x - 1][start_y] == '-') {
                        continue;
                    }
                    graph[start_x][start_y] = '.';
                    graph[--start_x][start_y] = '^';
                    continue;
                }

                if (c == 'D') {
//                    System.out.println("D");
                    graph[start_x][start_y] = 'v';

                    // 범위 확인 및 앞에 장애물 확인
                    if (start_x+1 < 0 || start_x+1 >= H || graph[start_x + 1][start_y] == '*'
                            || graph[start_x + 1][start_y] == '#' || graph[start_x + 1][start_y] == '-') {
                        continue;
                    }
                    graph[start_x][start_y] = '.';
                    graph[++start_x][start_y] = 'v';
                    continue;
                }

                if (c == 'L') {
//                    System.out.println("L");
                    graph[start_x][start_y] = '<';

                    // 범위 확인 및 앞에 장애물 확인
                    if (start_y-1 < 0 || start_y-1 >= W || graph[start_x][start_y - 1] == '*'
                            || graph[start_x][start_y - 1] == '#' || graph[start_x][start_y - 1] == '-') {
                        continue;
                    }
                    graph[start_x][start_y] = '.';
                    graph[start_x][--start_y] = '<';
                    continue;
                }

                if (c == 'R') {
//                    System.out.println("R");
                    graph[start_x][start_y] = '>';

                    // 범위 확인 및 앞에 장애물 확인
                    if (start_y+1 < 0 || start_y+1 >= W || graph[start_x][start_y + 1] == '*'
                            || graph[start_x][start_y + 1] == '#' || graph[start_x][start_y + 1] == '-') {
                        continue;
                    }
                    graph[start_x][start_y] = '.';
                    graph[start_x][++start_y] = '>';
                    continue;
                }

                // -----------전차이동 끝

                // shooting
                if (c == 'S') {
//                    System.out.println("S");
                    int shoot_x = start_x;
                    int shoot_y = start_y;

                    if (graph[shoot_x][shoot_y] == '>') {
//                        System.out.println(">S");
                        while (true) {
//                            System.out.println(1);
                            // 맵 밖으로 나갈 때 + 강철
                            if (shoot_y + 1 >= W || graph[shoot_x][shoot_y + 1] == '#')
                                break;

                            // 벽돌
                            if (graph[shoot_x][shoot_y + 1] == '*') {
                                graph[shoot_x][shoot_y+1] = '.';
                                break;
                            }
                            shoot_y++;
                        }
                    }
                    if (graph[shoot_x][shoot_y] == '<') {
//                        System.out.println("<S");
                        while (true) {
//                            System.out.println(2);
                            // 맵 밖으로 나갈 때 + 강철
                            if (shoot_y - 1 < 0 || graph[shoot_x][shoot_y - 1] == '#')
                                break;

                            // 벽돌
                            if (graph[shoot_x][shoot_y - 1] == '*') {
                                graph[shoot_x][shoot_y-1] = '.';
                                break;
                            }
                            shoot_y--;
                        }
                    }
                    if (graph[shoot_x][shoot_y] == '^') {
//                        System.out.println("^S");
                        while (true) {
//                            System.out.println(3);
//                            System.out.println("x좌표 = " + shoot_x );
                            // 맵 밖으로 나갈 때 + 강철
                            if (shoot_x - 1 < 0 || graph[shoot_x - 1][shoot_y] == '#'){
//                                System.out.println("!!!!!!!!" + shoot_x);
                                break;}

                            // 벽돌
                            if (graph[shoot_x - 1][shoot_y] == '*') {
//                                System.out.println("벽돌~~" + shoot_x);
                                graph[shoot_x-1][shoot_y] = '.';
                                break;
                            }
                            shoot_x--;

                        }
                    }
                    if (graph[shoot_x][shoot_y] == 'v') {
//                        System.out.println("vS");
                        while (true) {
//                            System.out.println(4);
                            // 맵 밖으로 나갈 때 + 강철
                            if (shoot_x + 1 >= H || graph[shoot_x + 1][shoot_y] == '#')
                                break;

                            // 벽돌
                            if (graph[shoot_x + 1][shoot_y] == '*') {
                                graph[shoot_x+1][shoot_y] = '.';
                                break;
                            }
                            shoot_x++;
                        }
                    }

                }



            } // ----shooting 끝

            System.out.print("#" + i +" ");

            for(int k = 0; k<H; k++) {
                for(int l = 0; l<W; l++) {
                    System.out.print(graph[k][l]);
                }
                System.out.println();
            }

        }

    }

}

