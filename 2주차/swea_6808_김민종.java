import java.util.*;
import java.io.*;

public class swea_6808_김민종 {
    static int win, lose;
    static int[] G = new int[9];
    static int[] I = new int[9];
    static boolean[] use = new boolean[19];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            
            boolean[] get = new boolean[19];                //18장의 카드 중 인영이꺼 확인용

            for(int i = 0; i < 9; i++){                     //규영이 카드 채우고
                G[i] = Integer.parseInt(st.nextToken());
                get[G[i]] = true;
            }

            int idx = 0;
            for(int i = 1; i < 19; i++){                     //남는거 인영이 짬처리
                if(!get[i]) {
                    I[idx] = i;
                    idx++;
                }
            }

            win = 0;
            lose = 0;
            Arrays.fill(use, false);

            fx(0, 0, 0);

            System.out.println("#" + test_case + " " + win + " " + lose);
        }
    }
    static void fx(int d, int Gscore, int Iscore){
        if(d == 9){
            if(Gscore > Iscore) win++;      //규영이 승
            else lose++;                    //규영이 패
            return;
        }
        for(int i = 0; i < 9; i++){
            if(!use[i]){
                use[i] = true;                      //한 번 쓴 카드는 다시 못쓰게 true 처리
                int sum = G[d] + I[i];              //얻을 점수
                if(G[d] > I[i]){
                    fx(d + 1, Gscore + sum, Iscore);    //규영이 점수+
                }else {
                    fx(d + 1, Gscore, Iscore + sum);    //인영이 점수+
                }
                use[i] = false;
            }
        }
    }
}
