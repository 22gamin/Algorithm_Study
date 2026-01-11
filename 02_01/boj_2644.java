import java.io.*;
import java.util.*;

public class boj_2644 {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            
            graph[parent].add(child);
            graph[child].add(parent);
        }
        
        dist = new int[N + 1];
        Arrays.fill(dist, -1);
        
        bfs(person1, person2);
        
        System.out.println(dist[person2]);
    }

    static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            if (current == end) return;
            
            for (int next : graph[current]) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
