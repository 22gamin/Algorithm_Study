import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); 
        S = Integer.parseInt(st.nextToken()); 
        G = Integer.parseInt(st.nextToken()); 
        U = Integer.parseInt(st.nextToken()); 
        D = Integer.parseInt(st.nextToken()); 

        visited = new boolean[F + 1]; 

        bfs();
    }
    
    
     public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] { S, 0 });
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int floor = current[0];
            int cnt = current[1];

          
            if (floor == G) {
                System.out.println(cnt);
                return;
            }

      
            if (floor + U <= F && !visited[floor + U]) {
                visited[floor + U] = true;
                q.add(new int[] { floor + U, cnt + 1 });
            }

            if (floor - D >= 1 && !visited[floor - D]) {
                visited[floor - D] = true;
                q.add(new int[] { floor - D, cnt + 1 });
            }
        }

      
        System.out.println("use the stairs");
    }
    
    
    
    
    
}
