package xweek10;


import java.util.*;

public class b_9663 {
    static int N, col[],cnt;

    public static void queen(int row) {

        if(row ==N+1) {
            cnt++;
            return;
        }

        for(int i =1; i<N+1; i++) {
            col[row] = i;

            if (check(row)) {
                queen(row+1);
            }
        }
    }

    public static boolean check(int row) {
        for(int i =1; i<=row-1; i++) {
            if(col[row] == col[i] || Math.abs(row-i) == Math.abs(col[row]-col[i])){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //대각선, 행, 열 모두 못 놓음
        col = new int[N+1];
        queen(1);

        System.out.println(cnt);
    }

}
