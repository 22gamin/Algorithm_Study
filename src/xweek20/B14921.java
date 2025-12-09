package xweek20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        long mindiff = Long.MAX_VALUE;
        long total = 0;
        for(int i=0; i<n-1; i++){

            // 다음꺼부터 확인
            int min = i+1;
            int max = n-1;
            int mid = 0;
            while(min<=max){
                mid = (min+max)/2;

                long tmp = arr[mid] + arr[i];
                if(Math.abs(tmp)<mindiff){
                    mindiff = Math.abs(tmp);
                    total = tmp;
                }
                if(tmp<0){
                    min = mid+1;
                }else{
                    max = mid-1;
                }
            }
        }
        System.out.println(total);
    }
}
