import java.io.*; 
import java.util.*;

public class Main {

static int n;

static ArrayList<Integer>[] list;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    
    n = Integer.parseInt(br.readLine());
    

    list = new ArrayList[1001];
    for(int i=0; i<=1000; i++) {
        list[i] = new ArrayList<>();
    }
    
    int maxDay = 0;
    
    for(int i=0; i<n; i++) {
        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        list[d].add(w);
        maxDay = Math.max(maxDay, d);
    }
    

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int totalScore = 0;
    

    for(int i=maxDay; i>=1; i--) {
        for(int score : list[i]) {
            pq.offer(score);
        }

        if(!pq.isEmpty()) {
            totalScore += pq.poll();
        }
    }
    
    bw.write(String.valueOf(totalScore));
    bw.flush();
    bw.close();
    br.close();
}
}
