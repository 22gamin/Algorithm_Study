package swea;

import java.util.*;
import java.io.*;

public class s_5215 {

    static List<int[]> foods;
    static int N,L,max_value;
    static boolean[] isSelected;

    static void subSet(int cnt,int happy, int cal){

        if (cnt == N){
            if (happy > max_value) max_value = happy;
            return ;
        }

        //어차피 차례대로 편도만 가면됨
        if (cal + foods.get(cnt)[1] <= L)
            subSet(cnt + 1, happy + foods.get(cnt)[0], cal + foods.get(cnt)[1]);

        subSet(cnt + 1, happy, cal);
        }



    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i =1; i<T+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  // 재료 수
            L = Integer.parseInt(st.nextToken());  // 제한 칼로리

            foods  = new ArrayList<>();
            isSelected = new boolean[N]; // 선택/미선택 확인용
            max_value = 0;

            for(int j = 0; j<N; j++){ //재료 입력
                st = new StringTokenizer(br.readLine());
                foods.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
            }

            //칼로리 제한을 기준으로 짝 찾기, 2의 5승 32가지
            subSet(0, 0, 0);

            //출력
            System.out.println("#" + i + " " + max_value);
        }
    }
}
