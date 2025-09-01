package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_2630 {
    static int white,blue,graph[][];

    static void cut(int startX, int startY, int len){
        int sum = 0;

        for(int i = startX; i<startX+len; i++){
            for(int j = startY; j<startY+len; j++){
                sum += graph[i][j];
            }
        }

        if (sum == len*len) {
            blue++;
        }
        else if (sum == 0){
            white++;
        }
        else{
            len = len/2;
            cut(startX,startY,len);
            cut(startX+len,startY,len);
            cut(startX,startY+len,len);
            cut(startX+len,startY+len,len);
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        blue = white = 0;
        cut(0,0,N);
        System.out.println(white);
        System.out.println(blue);

    }
}
