import java.util.Scanner;

public class swea_1954_김민종 {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int arr[][] = new int[N][N];

            int[] dx = {0, 1, 0, -1};       //우 -> 하 -> 좌 -> 상 순서
            int[] dy = {1, 0, -1, 0};

            int x = 0, y = 0, dir = 0;
            for(int i = 1; i <= N * N; i++){
                arr[x][y] = i;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0){ //2차원 배열 범위 밖으로 나가면 회전
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }
            System.out.println("#" + test_case);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
