import java.util.Scanner;
import java.io.FileInputStream;

public class swea_1208_김민종 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++){
            int[] field = new int[100];
            int dump = sc.nextInt();

            for(int i = 0; i < 100; i++){
                field[i] = sc.nextInt();
            }

            for(int i = 0; i < dump; i++){
                int max = 0;
                int min = 0;

                for(int j = 1; j < 100; j++){
                    if(field[j] > field[max]) max = j;
                    if(field[j] < field[min]) min = j;
                }

                if(field[max] - field[min] <= 1) break;     //높이차 안나면 종료

                field[max]--;
                field[min]++;
            }

            int maxheight = field[0];
            int minheight = field[0];
            for(int i = 0; i < 100; i++){
                if(field[i] > maxheight) maxheight = field[i];
                if(field[i] < minheight) minheight = field[i];
            }

            System.out.println("#" + test_case + " " + (maxheight - minheight));
        }
    }
}
