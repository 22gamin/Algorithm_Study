import java.util.*;
import java.io.*;

public class boj_2458_김민종 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N +1][N + 1];         //arr[a][b] --> a에서 b로 가는거

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){            //여기가 출발 정점
                if(!arr[i][k]) continue;            //i -> k 가 안되면 넘기기
                for(int j = 1; j <= N; j++){        //도착 정점
                    if(arr[k][j]){
                        arr[i][j] = true;           // i -> k -> j 경로가 가능하면 i -> j 도 참
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= N; i++){                //i번째 학생이 확정할 수 있는가 확인
            int check = 0;
            for(int j = 1; j <= N; j++){            //다른 모든 학생이랑 비교
                if(i == j) continue;                //자기 자신이랑 비교 ㄴㄴ
                if(arr[i][j] || arr[j][i]) check++; //둘 중 하나라도 참이면 키 서열 정리 가능하므로 check++
            }
            if(check == N - 1) ans++;               //자기를 뺀 모두(N - 1 명)과 서열 정리 완료하면 ans++
        }

        System.out.println(ans);
    }
}
