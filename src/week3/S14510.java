package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//15:44
public class S14510 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test<=t; test++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int maxnum = Integer.MIN_VALUE;
            int total=0;
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                total+=arr[i];
                if(maxnum<arr[i]) maxnum = arr[i];
            }
            total-=maxnum;
            int number = (maxnum*(n-1) - (total));

            if(number == 0) {
                System.out.println("#"+test+" "+0);
                continue;
            }
            //
            int odd = 0;
            for(int height : arr) {
                int diff = maxnum - height;
                if (diff > 0) {
                    odd += (diff % 2);
                }
            }

            int count = number/3;
            count*=2;
            number = number%3;
            if(number>0) {
                if(number == 1){
                    count+=1;
                }
                else if(number == 2){
                    count+=2;
                }
            }
            // 1 3 5 7...
            int daysOdd = odd * 2 - 1;
            int result = Math.max(count, daysOdd);
            System.out.println("#"+test+" "+result);
        }
    }
}