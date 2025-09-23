package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_5650 {
    public static void main(String[] args) throws Exception{

        //파일 읽을 때 -> 디버깅 할 때 편함!! 제발 쓰기
        //제출할 때는 주석처리 하고 제출
//        System.setIn(new FileInputStream("res/input_d9_5650.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        //상0하1좌2우3         0_        1|\        2|/       3\|        4/|         5| |
        int[] di={-1,1,0,0};//0:상하좌우 0:상하좌우 0:상하좌우 0:상하좌우 0:상하좌우 0:상하좌우
        int[] dj={0,0,-1,1};//0:상하좌우 1:하우상좌 2:우상하좌 3:좌상우하 4:하좌우상 5:하상우좌
        int[][] dd=new int[][]{{0,1,2,3}, {1,3,0,2}, {3,0,1,2}, {2,0,3,1}, {1,2,3,0}, {1,0,3,2}};

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());

            //가장자리에 5추가 -> 어차피 벽에 부딪혔을 때 반대방향으로 튕겨져 나옴
            int[][] a = new int[1+N+1][1+N+1];
            for(int i = 0; i<1+N+1; i++){  // ㅁ 5로 초기화
                a[0][i] = 5; a[N+1][i] = 5;
                a[i][0] = 5; a[i][N+1] = 5;
            }

            // 웜홀 이동 표현
            // 웜홀은 6~10번까지이지만 인덱스의 편의성을 위해 그냥 11개까지 모두 생성
            // 4는 웜홀은 두 쌍이 하나 이기 때문에 연결된 좌표를 x,y,x,y 이런식으로 저장한 것
            int[][] hole = new int [1+10][4];

            // graph 입력 받으면서 hole의 짝궁 찾아두기
            for(int i =1; i<= N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 1; j<= N; j++){
                    int n = Integer.parseInt(st.nextToken());

                    //웜홀
                    if (n >= 6) {
                        if(hole[n][0] == 0) { //처음
                            hole[n][0+0] = i; hole[n][0+1] = j;
                        } else { //하나는 받음!
                            hole[n][2+0] = i; hole[n][2+1] = j;
                        }

                    }
                    //웜홀 말고 다른 블록들
                    a[i][j] = n;
                }
            }
            //for(int[] b : a) System.out.println(Arrays.toString(b)); System.out.println();

            // max 값 찾기
            int max = 0;

            //모든 칸 순회
            for(int i = 1; i<= N; i++){
                for(int j =1; j<= N; j++){

                    if(a[i][j] != 0) continue; //0이 아니면 출발 불가 -> 다음 칸으로

                    // 4가지 방향(상하좌우)으로 출발 시도
                    for(int d=0; d<4; d++){
                        //ni,nj는 현재 핀볼의 위치로 출발점(i,j)로 초기화, nd는 현재 핀볼의 방향
                        int cnt = 0, ni = i, nj = j, nd= d; //시작 전 초기화

                        // 핀볼 게임 시작!
                        while(true){
                            // 핀볼 이동
                            ni = ni+di[nd]; nj = nj+dj[nd];

                            // 게임 종료 조건(출발선 다시 컴백 || 블랙홀 )
                            if((ni == i && nj == j) || a[ni][nj] == -1) break;

                            int n = a[ni][nj]; //현재 위치(웜홀 확인을 위해)

                            if(n>=6){ //웜홀 만났을 때
                                ni = (ni == hole[n][0])? hole[n][2] : hole[n][0];
                                nj = (nj == hole[n][1])? hole[n][3] : hole[n][1];
                            }
                            else {
                                if(n!= 0) cnt++;  //블록이나 벽
                                nd = dd[n][nd];   //방향 전환
                                // 미리 만들어둔 2차원 배열 dd를 이용
                                // n번 블록에 nd 방향으로 부딪혔을 때 다음 방향을 알려줌
                            }

                        }
                        max = Math.max(max,cnt); //게임 종료 후 최고 점수 갱신
                    }
                }

            }
            sb.append('#').append(tc).append(" ").append(max).append('\n');
        }
        System.out.print(sb.toString());
        br.close();
    }
}
