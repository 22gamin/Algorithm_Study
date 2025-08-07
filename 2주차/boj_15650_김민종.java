import java.util.*;
import java.io.*;

public class boj_15650_김민종 {
    static int N, M;
    static int[] ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[M];

        fx(0,1);
    }   
    
    static void fx(int depth, int num){
        if(depth == M){
            for(int i = 0; i < M; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = num; i <= N; i++){
            ans[depth] = i;
            fx(depth + 1, i + 1);
        }
    }
}
