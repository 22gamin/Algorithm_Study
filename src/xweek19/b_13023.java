package xweek19;

import java.util.*;
import java.io.*;

public class b_13023 {
    static int N, M;
    static List<List<Integer>> friends = new ArrayList<>();
    static boolean[] check;
    static int fin;

    static void find(int start, int depth){
        if(depth==5){
            fin = 1;
            return;
        }

        for(int i : friends.get(start)){

            if(!check[i]){
                check[i] = true;
                find(i,depth+1);

                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            friends.add(new ArrayList<>());
        }

        for(int m = 0; m<M; m++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends.get(a).add(b);
            friends.get(b).add(a);
        }  // 입력 끝

        for(List<Integer> list : friends){
            if(fin == 1) break;
            for(int a : list){
                check = new boolean[N];
                check[a] = true;
                fin = 0;
                find(a,1);

                if (fin == 1) break;
            }
        }
        System.out.println(fin);
    }
}
