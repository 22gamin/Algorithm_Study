import java.util.*;
import java.io.*;

public class boj_15649_김민종 {
    static int N, M;
    static int[] ans;
    static boolean[] use;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[M];           //수열 저장용
        use = new boolean[N + 1];   //썼는지 안썼는지 확인용

        dfs(0);
    }

    static void dfs(int depth){
        if(depth == M){                     //M개 채우면 끝
            for(int i = 0; i < M; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= N; i++){
            if(use[i] == true) continue;        //자연수 i를 썼으면 건너뜀
            use[i] = true;
            ans[depth] = i;
            dfs(depth + 1);
            use[i] = false;     //백트래킹
        }
    }
}
