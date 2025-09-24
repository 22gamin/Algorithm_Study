package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new LinkedList<>();
        for(int i=1; i<=n; i++){
            dq.add(i);
        }
        int cnt=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int a = Integer.parseInt(st.nextToken());
            // find함수 없어서 리스트 사용, 매번 dq넣어주기
            List<Integer> li = new ArrayList<>(dq);
            int target = li.indexOf(a);
            while(dq.getFirst() != a){
                // 순환
                if(target<=dq.size()/2) {
                    dq.addLast(dq.getFirst());
                    dq.pollFirst();
                }
                // 역순환
                else{
                    dq.addFirst(dq.getLast());
                    dq.pollLast();
                }
                cnt++;
            }
            dq.pollFirst();
        }
        System.out.println(cnt);
    }
}
