import java.io.*;
import java.util.*;

public class Solution {

    static int n, maxD;
    static ArrayList<HashSet<Integer>> al;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            al = new ArrayList<>();
            for (int i = 0; i <= 100; i++) {
                al.add(new HashSet<>());
            }

            StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
            visit = new int[101];
            maxD = 0;

            int size = st2.countTokens() / 2;
            for (int i = 0; i < size; i++) {
                int from = Integer.parseInt(st2.nextToken());
                int to = Integer.parseInt(st2.nextToken());
                al.get(from).add(to);
            }
            int result = 0;
            dfs(start, 1);

        
            for (int i = 1; i <= 100; i++) {
                if (visit[i] >= maxD) {
                    maxD = visit[i];
                    result = i;
                }
            }
           
            System.out.println("#" + tc + " " + result);

        }
    }

    public static void dfs(int x, int d) {
        visit[x] = d;
        
        for (int to : al.get(x)) {
            if (visit[to] == 0 ) {
                dfs(to, d + 1);
            }else if(visit[to]>d+1){
            	dfs(to, d + 1);
            }
        }
    }

}
