package xweek11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2141 {
    static class node implements Comparable<node>{
        long loc, popu;
        public node(long loc, long popu){
            this.loc=loc;
            this.popu=popu;
        }
        // 주의
        public int compareTo(node other){
            return Long.compare(this.loc, other.loc);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<node> li = new ArrayList<>();

        long total=0, num=0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            li.add(new node(x, a));
            num += a;
        }
        Collections.sort(li);

        long mid = (num+1)/2;
        for(node nod : li){
            total+=nod.popu;
            if(total>=mid){
                System.out.println(nod.loc);
                return;
            }
        }
    }
}
