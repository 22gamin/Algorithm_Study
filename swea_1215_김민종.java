import java.util.Scanner;

public class swea_1215_김민종 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++){
            int N = sc.nextInt();               //회문 길이
            char[][] arr = new char[8][8];
            for(int i = 0; i < 8; i++){
                String row = sc.next();
                for(int j = 0; j < 8; j++){
                    arr[i][j] = row.charAt(j);
                }
            }

            int ans = 0;

            for(int i = 0; i < 8; i++){                     //가로 방향 검사
                for(int j = 0; j <= 8 - N; j++){
                    boolean is_palindrome = true;
                    for(int k = 0; k < N/2; k++){
                        if(arr[i][j + k] != arr[i][j + N - 1 - k]){
                            is_palindrome = false;
                            break;
                        }
                    }
                    if(is_palindrome == true) ans++;
                }
            }

            for(int i = 0; i < 8; i++){                     //세로 방향 검사
                for(int j = 0; j <= 8 - N; j++){
                    boolean is_palindrome = true;
                    for(int k = 0; k < N/2; k++){
                        if(arr[j + k][i] != arr[j + N - 1 -k][i]){
                            is_palindrome = false;
                            break;
                        }
                    }
                    if(is_palindrome == true) ans++;
                }
            }


            System.out.println("#" + test_case + " " + ans);
        }
    }
}
