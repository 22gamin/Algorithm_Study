package xweek20;

import java.util.*;
import java.io.*;

public class b_1038 {
    static int N;
    static List<Long> list = new ArrayList<>();

    static void find(long num){
        list.add(num);

        long last = num % 10; //마지막 자리 숫자 알기

        //last보다 작은 숫자만 올 수 있음
        for(int i = 0; i<last; i++){
            find(num*10+i);
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        if(N>1022){
            System.out.println(-1);
            return;
        }

        for(int i = 0; i<=9; i++){
            find(i);
        }

        Collections.sort(list);

        System.out.println(list.get(N));
    }
}
