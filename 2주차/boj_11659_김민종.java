import java.util.*;
import java.io.*;

public class boj_11659_김민종 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++){
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());   //앞 숫자까지 합해서 배열에 저장
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if(start == 0){
                System.out.println(arr[end]);
            }else{
                System.out.println(arr[end] - arr[start -1]);
            }
        }
    }
}
