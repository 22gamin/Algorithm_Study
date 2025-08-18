package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15903 {
    public static void main(String[] args) throws IOException {
        // 점수를 가장 작게 만드는 것이 놀이의 목표
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st1.nextToken());
        for(int i=0; i<s; i++){
            Arrays.sort(arr);
            long tmp = arr[0]+arr[1];
            arr[0] = tmp;
            arr[1] = tmp;
        }
        long total = 0;
        for(long c : arr){
            total+=c;
        }
        System.out.println(total);
    }
}
