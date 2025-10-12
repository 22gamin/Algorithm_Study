package xweek11;

import java.util.*;
import java.io.*;

public class b_14888 {
    static int N,numbers[],opers[],max,min;

    static void find(int numIdx, int sum) {

        if(numIdx == N) { //연산자의 개수는 N-1이니까
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return ;
        }

        for(int i = 0; i<4; i++){
            if (opers[i] != 0){
                opers[i]--;
                if (i==0){
                    find(numIdx+1, sum + numbers[numIdx]);
                }
                else if(i==1) find(numIdx+1, sum - numbers[numIdx]);
                else if(i==2) find(numIdx+1, sum * numbers[numIdx]);
                else {
                    if (numbers[numIdx] > 0) find(numIdx+1, sum / numbers[numIdx]);
                    else find(numIdx+1, (sum / (numbers[numIdx] * -1)) * -1);
                }
                opers[i]++;
            }
        }



    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        opers = new int[4];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int n = 0; n<N; n++) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<4; i++) {
            opers[i] = Integer.parseInt(st.nextToken());
        }//입력 끝

        int sum = numbers[0];
        find(1, sum);

        System.out.println(max);
        System.out.println(min);
    }

}

