import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visit;
    static int[] which;
    static boolean isP;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        
        int t = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            visit = new int[v + 1];
            which = new int[v + 1];
            graph = new ArrayList[v + 1];

            for(int i = 0; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < e; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                
                graph[x].add(y);
                graph[y].add(x);
            }

            isP = true;

         
            for(int i = 1; i <= v; i++) {
                if(visit[i] == 0) { 
                    bfs(i);
                    if(!isP) break; 
                }
            }

            if(isP) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
   public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = 1;
        which[start] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            int curColor = which[cur];

            for(int next : graph[cur]) {
                if(visit[next] == 1) {
                   
                    if(which[next] == curColor) {
                        isP = false;
                        return;
                    }
                } else {
              
                    visit[next] = 1;
                    which[next] = (curColor == 1) ? 2 : 1;
                    q.offer(next);
                }
            }
        }
    }
}
