package swea;

import java.io.*;
import java.util.*;

public class s_2112 {

    static int D,W,K,min,inject[],map[][];

    // 부분 집합으로 가능한 배열 만들고 바로 체크 들어가기
    static void subs(int cnt, int su){ //cnt: 행 개수, su: 현재 약 투약 개수

        //K행만큼 약을 투약하면 그것이 최소값이 되기 때문에 이것보다 커지면 의미없음
        if(su >= min) return ;

        if(cnt ==D){ //모든 행 완료, su 최소값 비교
            if(check()) min = Math.min(min, su);
            return ;
        }

        inject[cnt] = -1;  // 비선택(투약안함)
        subs(cnt+1, su);

        inject[cnt] = 0;   //A 선택
        subs(cnt+1,su+1);

        inject[cnt] = 1;   //B 선택
        subs(cnt+1, su+1);
    }

    // 모두 만들어진 배열을 보고 합격 기준에 통과하는지 안 하는지 확인
    static boolean check(){
        outer: for(int w = 0; w<W; w++){
            int cnt = 1;

            //다음 배열의 값까지 비교해야하므로 D-1까지만
            for(int d= 0; d<D-1; d++){
                int curr = inject[d] == -1? map[d][w] : inject[d];    // 투약안했으니까 원래 값 map[d][w]
                int next = inject[d+1] == -1? map[d+1][w] : inject[d+1];  // 투약했으니까 바뀐 값으로 inject[d+1]

                //연속되어 있는지
                if(curr==next){
                    cnt++;
                    if(cnt>=K) continue outer; //빠르게 다음행
                }
                else { // 다르면 리셋
                    cnt =1;
                }
            }

            if(cnt < K) return false; //합격 기준 통과 못함
        }
        return true;  //모두 통과
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i<T+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[D][W];
            inject = new int[D];

            for(int j = 0; j < D; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<W; k++){
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // ---------입력 끝

            min = K;
            subs(0,0);
            sb.append("#").append(i).append(" ").append(min).append("\n");

        }
        System.out.print(sb.toString());
    }


}
