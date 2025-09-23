package week5;

import java.util.Scanner;

public class b_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;

        while (true){
            if (N>5){
                if (N%5 == 0){
                    N -= 5;
                    cnt++;
                }
                else if(N%3==0){
                    N-=3;
                    cnt++;
                }
                else {
                    N -= 5;
                    cnt++;
                }
            }
            else if (N==5){
                N-=5;
                cnt++;
                break;
            }
            else if (N == 3){
                N-=3;
                cnt++;
                break;
            }
            else {
                cnt = -1;
                break;
            }
        }

        System.out.println(cnt);

    }
}
