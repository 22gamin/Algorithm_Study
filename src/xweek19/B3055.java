package xweek19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        Queue<int[]> animal = new LinkedList<>();
        Queue<int[]> water = new LinkedList<>();
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S') animal.add(new int[]{i,j});
                else if(map[i][j] == '*') water.add(new int[]{i,j});
            }
        }
        // S가 D로 가야함
        // 물 먼저
        int t = 0;
        while(!animal.isEmpty()){
            t++;
            // 물
            int waterSize = water.size();
            for(int i=0; i<waterSize; i++){
                int[] cur = water.poll();
                for(int d= 0; d<4; d++){
                    int nx = dx[d] + cur[0];
                    int ny = dy[d] + cur[1];
                    if(nx<0 || nx>=R || ny<0 || ny>=C || map[nx][ny] == '*') continue;
                    // 돌, D이면 못감
                    if(map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
                    map[nx][ny] = '*';
                    water.add(new int[]{nx,ny});
                }
            }
            int animalSize = animal.size();
            for(int i=0; i<animalSize; i++){
                int[] cur = animal.poll();
                for(int d= 0; d<4; d++) {
                    int nx = dx[d] + cur[0];
                    int ny = dy[d] + cur[1];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C)
                        continue;
                    if(map[nx][ny] == 'D'){
                        System.out.println(t);
                        return;
                    }
                    if(map[nx][ny] == '.'){
                        map[nx][ny] = 'S';
                        animal.add(new int[]{nx,ny});
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }
}
