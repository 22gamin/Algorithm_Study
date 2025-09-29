import java.util.Scanner;

public static void main(String args[]) throws Exception{
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int test_case = 1; test_case <= t; test_case++){
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        int x = arr[N - 1];
        int max = 0;
        for(int i = N - 1; i >= 0; i--){
            if(x < arr[i]){
                x = arr[i];
            }else{
                max += x - arr[i]; 
            }
        }
        System.out.println("#" + test_case +  max);
    }
}
