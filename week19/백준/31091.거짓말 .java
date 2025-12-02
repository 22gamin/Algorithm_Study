import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] diff = new int[N + 2]; 
        
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            
            if (k > 0) {
             
                int end = Math.min(k - 1, N);
                if (end >= 0) {
                    diff[0]++;
                    diff[end + 1]--;
                }
            } else {
          
                int start = Math.abs(k) + 1;
                if (start <= N) {
                    diff[start]++;
                    diff[N + 1]--;
                }
            }
        }
        
        int[] count = new int[N + 1];
        int cur = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            cur += diff[i];
            count[i] = cur;
            
            if (count[i] == i) {
                result.add(i);
            }
        }
        
        
        
        
        
        
        System.out.println(result.size());
        StringBuilder sb = new StringBuilder();
        for (int x : result) {
            sb.append(x).append(" ");
        }
        
        
        
        
        System.out.println(sb);
    }
}
