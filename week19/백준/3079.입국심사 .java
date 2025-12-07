import java.io.*;
import java.util.*;

public class Main {

static int N;
static long M;
static long[] times;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Long.parseLong(st.nextToken());

    times = new long[N];
    
    long maxTime = 0;
    for (int i = 0; i < N; i++) {
        times[i] = Long.parseLong(br.readLine());
        maxTime = Math.max(maxTime, times[i]);
    }
    
   
    long low = 0;
    long high = maxTime * M;
    long answer = high;

    while (low <= high) {
        long mid = (low + high) / 2;
        long sum = 0;

 
        for (int i = 0; i < N; i++) {
            sum += mid / times[i];
            
            
            if (sum >= M) {
                break;
            }
        }

        if (sum >= M) {
        
            answer = mid;
            high = mid - 1;
        } else {
        
            low = mid + 1;
        }
    }

    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
    br.close();
}
}
