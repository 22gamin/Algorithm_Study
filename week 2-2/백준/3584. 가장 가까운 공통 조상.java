import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            visited = new boolean[N + 1];
            
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
            }
            
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            sb.append(solve(u, v)).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static int solve(int u, int v) {
        int uDepth = getDepth(u);
        int vDepth = getDepth(v);
        
        while (uDepth > vDepth) {
            u = parent[u];
            uDepth--;
        }
        
        while (vDepth > uDepth) {
            v = parent[v];
            vDepth--;
        }
        
        while (u != v) {
            u = parent[u];
            v = parent[v];
        }
        
        return u;
    }
    
    static int getDepth(int node) {
        int depth = 0;
        int cur = node;
        while (cur != 0) {
            depth++;
            cur = parent[cur];
        }
        return depth;
    }
}
