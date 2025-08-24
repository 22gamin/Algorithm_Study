import java.util.*;
import java.io.*;

public class swea_1267_김민종 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i = 0; i <= V; i++){
                graph.add(new ArrayList<>());
            }

            int[] arr = new int[V + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E; i++){
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                arr[v]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= V; i++){
                if(arr[i] == 0){
                    q.add(i);
                }
            }

            System.out.print("#" + tc + " ");

            while (!q.isEmpty()) {
                int node = q.poll();            // 현재 노드
                System.out.print(node + " ");   // 위상 정렬 순서대로 노드 출력

                for (int neighbor : graph.get(node)) {      //현재 노드와 연결된 모든 인접 노드 탐색
                    arr[neighbor]--;                        //인접 노드의 진입 차수 -1
                    if (arr[neighbor] == 0) {
                        q.add(neighbor);                    //진입 차수가 0이 된 노드는 시작점이 됨
                    }
                }
            }
            System.out.println();
        }
    }
}
