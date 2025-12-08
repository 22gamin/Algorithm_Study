package xweek20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long arr[] = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken()    );
        }

        long mindiff = Long.MAX_VALUE;
        long[] total = new long[2];
        for(int i=0; i<n-1; i++){

            int min = i+1;
            int max = n-1;
            int mid = 0;
            while(min<=max){
                mid = (min+max)/2;

                long target = arr[i] + arr[mid];

                if(Math.abs(target)<mindiff){
                    mindiff = Math.abs(target);
                    total[0] = arr[i];
                    total[1] = arr[mid];
                }
                if(target<0){
                    min = mid+1;
                }else{
                    max = mid-1;
                }
            }
        }
        System.out.println(total[0]+" "+total[1]);
    }
}
