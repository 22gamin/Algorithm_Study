package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1783 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());  //세로
        int m = Integer.parseInt(st.nextToken());
        int answer =0;

        //7칸이면 4번의 이동방법 다씀 -> m의 길이가 7이상이면 이후에는 적게 이동하는 (2,1)->(-2,1) 반복
        if (n==1)
            answer = 1;

        else if (n==2)
            answer = Math.min(4,(m+1)/2);

        else if (m<7)
            answer = Math.min(4,m);

        else
            answer = m-2;
        System.out.println(answer);
    }
}
