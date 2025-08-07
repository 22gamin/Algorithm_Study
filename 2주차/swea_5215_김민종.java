import java.util.*;
import java.io.*;

public class swea_5215_김민종 {
    static int N, L, ans;
    static int[] T, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());       //이게 재료
            L = Integer.parseInt(st.nextToken());       //이게 제한 칼로리

            T = new int[N];
            K = new int[N];
            ans = 0;

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                T[i] = Integer.parseInt(st.nextToken());
                K[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, 0);

            System.out.println("#" + test_case + " " + ans);
        }
    }

    static void dfs(int idx, int totalT, int totalK){
        if(totalK > L) return;          //칼로리 초과 시 
        if(idx == N){
             ans = Math.max(ans, totalT);
             return;                    //대 소 연
        }

        dfs(idx + 1, totalT + T[idx], totalK + K[idx]);  //재료 선택하고 다음꺼로
        dfs(idx + 1, totalT, totalK); //재료 선택 안하고 넘어가기
    }
}
