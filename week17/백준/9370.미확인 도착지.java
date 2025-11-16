import java.io.*;
import java.util.*;

public class Main {
    static int n, m, t, s, g, h;
    static List<int[]>[] graph;
    static int[] ends;
    static int[][] dist; // dist[x][0]: 최단거리, dist[x][1]: g-h 포함 여부

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph[a].add(new int[]{b, d});
                graph[b].add(new int[]{a, d});
            }

            ends = new int[t];
            for (int i = 0; i < t; i++) ends[i] = Integer.parseInt(br.readLine());
            Arrays.sort(ends);

           
            dist = new int[n + 1][2];
            for (int i = 0; i <= n; i++) dist[i][0] = Integer.MAX_VALUE;
            dist[s][0] = 0;
            dist[s][1] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[]{s, 0, 0}); 

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int x = cur[0];
                int w = cur[1];
                int isP = cur[2];

                if (w > dist[x][0]) continue;

                for (int[] next : graph[x]) {
                    int nx = next[0];
                    int nw = w + next[1];
                    int pass = ((x == g && nx == h) || (x == h && nx == g)) ? 1 : 0;
                    int nextIsP = isP | pass;

                    if (nw < dist[nx][0]) {
                        dist[nx][0] = nw;
                        dist[nx][1] = nextIsP;
                        pq.offer(new int[]{nx, nw, nextIsP});
                    } else if (nw == dist[nx][0] && dist[nx][1] == 0 && nextIsP == 1) {
                        dist[nx][1] = 1;
                        pq.offer(new int[]{nx, nw, 1});
                    }
                }
            }

         
            StringBuilder sb = new StringBuilder();
            for (int x : ends) {
                if (dist[x][1] == 1) sb.append(x).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
