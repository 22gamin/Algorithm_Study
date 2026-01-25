import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        
        long answer = 0;
        
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            
            int sum = a + b;
            answer += sum;
            pq.add(sum);
        }
        
        System.out.println(answer);
    }
}
