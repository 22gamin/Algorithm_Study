package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test = 1; test<=10; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            List<Integer>[] li = new ArrayList[v+1];
            for(int i=1; i<=v; i++) li[i] = new ArrayList<>();
            int[] dig = new int[v+1];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i=0; i<e; i++){
                int a = Integer.parseInt(st1.nextToken());
                int b = Integer.parseInt(st1.nextToken());

                li[a].add(b);
                dig[b]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=v; i++){
                if(dig[i] == 0) q.add(i);
            }
            List<Integer> result = new ArrayList<>();
            //bfs

            while(!q.isEmpty()){
                int cur = q.poll();
                result.add(cur);

                for(int c : li[cur]){
                    dig[c]--;
                    if(dig[c] == 0) {
                        q.add(c);
                        continue;
                    }
                }
            }
            System.out.print("#"+test+" ");
            for(int c : result) System.out.print(c+" ");
            System.out.println();
        }
    }
}
