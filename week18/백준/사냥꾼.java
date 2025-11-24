import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        
        int n = Integer.parseInt(st.nextToken());
        long l = Long.parseLong(st.nextToken());

        long[] s = new long[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) 
        
        
            s[i] = Long.parseLong(st.nextToken());

        Arrays.sort(s);
        int cnt = 0;

        for(int i = 0; i < n; i++) {
        
            st = new StringTokenizer(br.readLine());
            
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(b > l) continue;

            int p = Arrays.binarySearch(s, a);
            if(p < 0) p = -p - 1;

            boolean ok = false;

            if(p < m && Math.abs(s[p] - a) + b <= l) ok = true;
            if(!ok && p - 1 >= 0 && Math.abs(s[p - 1] - a) + b <= l) ok = true;





            if(ok) cnt++;
        }





        System.out.println(cnt);
  }
}
