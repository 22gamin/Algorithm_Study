import java.util.Scanner;

public class swea_1206_김민종 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++){
            int N = sc.nextInt();
            int[] h = new int[N];

            for(int i = 0; i < N; i++){
                h[i] = sc.nextInt();
            }

            int ans = 0;

            for(int i = 2; i < N - 2; i++){
                int maxheight = Math.max(Math.max(h[i - 2], h[i - 1]), Math.max(h[i + 1], h[i + 2]));

                if(h[i] > maxheight){
                    ans += h[i] - maxheight;
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}
