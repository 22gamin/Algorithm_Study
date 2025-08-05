import java.util.Scanner;

public class swea_2806_김민종 {
    static int ans, N;
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            N = sc.nextInt();
            board = new int[N][N];
            ans = 0;
            dfs(0);
            System.out.println("#" + test_case + " " + ans);
        }
    }

    static void dfs(int row){
        if(row == N){
            ans++;
            return;
        }
        
        for(int col = 0; col < N; col++){
            if(can(row, col)){
                board[row][col] = 1;
                dfs(row + 1);
                board[row][col] = 0;
            }
        }
    }

    static boolean can(int row, int col){
        for(int i = 0; i < row; i++){         //row 검사
            if(board[i][col] == 1){
                return false;
            }
        }

        for(int i = 1; row - i >= 0 && col - i >= 0; i++){      //좌측대각 검사
            if(board[row - i][col - i] == 1){
                return false;
            }
        }

        for(int i = 1; row - i >= 0 && col + i < N; i++){       //우측대각 검사
            if(board[row - i][col + i] == 1){
                return false;
            }
        }

        return true;
    }
}
