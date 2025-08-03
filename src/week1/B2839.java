package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 3키로 5키로
        int answer = n;
        int min = 5000;

        for(int i=0; i<n; i++){
            // 3키로
            int tmp=5000;
            for(int j=0; j<n; j++){

                int total = 5*i + 3*j;
                if(total > answer) break;
                else if(total == answer){
                    tmp = i+j;
                    //break;
                }
                if(min>tmp){
                    min = tmp;
                }
            }
            // 5키로
            tmp=5000;
            for(int j=0; j<n; j++){
                int total = 3*i + 5*j;
                if(total > answer) break;
                if(total == answer){
                    tmp = i+j;
                    //break;
                }
                if(min>tmp){
                    min = tmp;
                }
            }

        }
        if(min == 5000)System.out.print(-1);
        else System.out.print(min);
    }
}
