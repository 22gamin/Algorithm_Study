import java.util.Scanner;

class swea_1204 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int[] arr = new int[101];

            for(int i = 0; i < 1000; i++){
                int score = sc.nextInt();
                arr[score]++;
            }

            int max_score = 0;
            for(int i = 0; i <= 100; i++){
                if(arr[max_score] <= arr[i]){
                    max_score = i;
                }
            }
            System.out.println("#" + test_case + " " + max_score);
        }
    }
}
