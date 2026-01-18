package yweek2_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int maxnum = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            maxnum = Math.max(arr[i], maxnum);
            sum += arr[i];
        }

        int low = maxnum;
        int high = sum;
        int ans = 0;

        while(low<=high){
            int mid = (low + high)/2;
            int count = getcount(n, arr,mid);

            if(count <= m){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
    public static int getcount(int n, int[] arr, int size){
        int count = 1;
        int sum = 0;

        for(int i=0; i<n; i++){
            if(sum + arr[i] > size){
                count++;
                // 초기화
                sum = arr[i];
            }else{
                sum += arr[i];
            }
        }
        return count;
    }
}
