package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_2961 {
    static int N,food[][];
    static int min = Integer.MAX_VALUE;
    static boolean[] isSelected;

    static void cook(int depths, int s, int b){

        if (depths == N){
            if (s == 1){
                return ;
            }
            min = Math.min(min,Math.abs(s-b));
            return;
        }

        s *= food[depths][0];
        b += food[depths][1];

        cook(depths+1, s, b);

        s /= food[depths][0];
        b -= food[depths][1];

        cook(depths+1,s,b);

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        food = new int[N][2];
        isSelected = new boolean[N];

        for(int n = 0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            food[n] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        cook(0,1,0);

        System.out.println(min);
    }
}
