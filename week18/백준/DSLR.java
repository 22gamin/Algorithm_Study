import java.io.*;
import java.util.*;

public class Main {
    static int D(int n){ return (n*2)%10000; }
    static int S(int n){ return n==0?9999:n-1; }
    static int L(int n){ return (n%1000)*10 + n/1000; }
    static int R(int n){ return (n/10) + (n%10)*1000; }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
   
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10000];
            int[] parent = new int[10000];
            char[] how = new char[10000];
            
            
            Arrays.fill(parent, -1);

            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(A);
            visited[A] = true;

            while (!q.isEmpty()) {
                int cur = q.poll();
                if (cur == B) break;

                int nx;

                nx = D(cur);
                if (!visited[nx]) {
                    visited[nx] = true;
                    parent[nx] = cur;
                    how[nx] = 'D';
                    q.add(nx);
                }

                nx = S(cur);
                if (!visited[nx]) {
                    visited[nx] = true;
                    parent[nx] = cur;
                    how[nx] = 'S';
                    q.add(nx);
                }

                nx = L(cur);
                if (!visited[nx]) {
                    visited[nx] = true;
                    parent[nx] = cur;
                    how[nx] = 'L';
                    q.add(nx);
                }

                nx = R(cur);
                if (!visited[nx]) {
                    visited[nx] = true;
                    parent[nx] = cur;
                    how[nx] = 'R';
                    q.add(nx);
                }
            }

            StringBuilder path = new StringBuilder();
            int cur = B;
            while (cur != A) {
                path.append(how[cur]);
                cur = parent[cur];
            }
            out.append(path.reverse().toString()).append('\n');
        }
        
        
        
        System.out.print(out.toString());
    }
	}
