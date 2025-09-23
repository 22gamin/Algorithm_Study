package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class s_1210 {

    static List<int[]> list = new ArrayList<>();
    static int[] ma = new int[2];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<T+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 재료의 수
            int L = Integer.parseInt(st.nextToken());  // 제한 칼로리

            //입력
            for (int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int calories = Integer.parseInt(st.nextToken());

                list.add(new int[]{score,calories});

            }

            // 제한 칼로리 이하의 조합 중 맛 점수가 가장 높은 것 
        }
    }
}
