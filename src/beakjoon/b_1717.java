package beakjoon;

import java.util.*;
import java.io.*;

public class b_1717 {

    static int n,m;
    static int[] parents;

    static int find(int a){
        if (parents[a] == a){
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a != b){
            if (a<b){
                parents[b] = a;
            } else {
                parents[a] = b;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];

        //초기화
        for(int i = 1; i<n+1; i++){
            parents[i] = i;
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cal == 0){
                union(a,b);
            }
            else if(cal == 1){
                if (find(a) == find(b))
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        }
    }
}
