package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_1486 {
    static int N,B;
    static int[] arr;
    static int max_value;

    public static void find(int depths, int sum){


        // 모든 직원의 키 합 도달
        if (sum > B){
            max_value = Math.min(max_value, Math.abs(sum-B));
            return ;
        }

        else if(depths == N){
            if (sum >= B)
                max_value = Math.min(max_value, Math.abs(sum-B));
            return ;
        }


        find(depths + 1, sum + arr[depths]);
        find(depths + 1, sum);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for(int i = 1; i < T+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[N];
            max_value = 1000000;
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            find(0, 0);

            //출력
            System.out.println("#" + i + " " + max_value);
        }
    }
}
