import java.util.*;
import java.io.*;

public class swea_14510_김민종 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            int max = 0;
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] > max) max = arr[i];          //제일 큰 나무
            }
            
            int odd = 0;            //+1 필요한 수
            int even = 0;           //+2 필요한 수

            for(int i = 0; i < N; i++){
                int j = max - arr[i];
                odd += j % 2;
                even += j / 2;
            }

            int ans = odd + even;

            if(odd < even){                     //짝수 일이 더 많으면 압축
                int gap = (even - odd) * 2;         //(쉬고 + 2) 묶음 개수로 환산
                int remain = (gap / 3) * 2;         //(1, 2)  쌍으로 최대한 압축
                if(gap % 3 == 2) remain += 2;       //나머지가 2면 (쉬고 + 2) 한 번 더 필요
                else if (gap % 3 == 1) remain += 1; //나머지가 1이면 +1 하루 더
                ans = odd * 2 + remain;
            }else if(odd - even > 1) {              //홀수 작업일이 더 많으면 중간에 하루씩 쉬는 날 필요
                ans += (odd - even - 1);
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
