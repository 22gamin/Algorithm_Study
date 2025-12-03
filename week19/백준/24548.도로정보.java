import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        

        long[][][][] count = new long[3][3][3][3];
        
        int t = 0, g = 0, f = 0, p = 0;
        
          for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            
            if (c == 'T') t = (t + 1) % 3;
            else if (c == 'G') g = (g + 1) % 3;
            else if (c == 'F') f = (f + 1) % 3;
            else if (c == 'P') p = (p + 1) % 3;
            
            count[t][g][f][p]++;
        }
        
   
        count[0][0][0][0]++; 
        
        long ans = 0;
 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        long n = count[i][j][k][l];
                        if (n >= 2) {
                            ans += (n * (n - 1)) / 2;
                        }
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
}
