package week4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class s_3952 {

    static List<List<Integer>> graph;
    static int[] indegree;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc < T+1; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            for (int nc = 0; nc <N+1; nc++){
                graph.add(new ArrayList<>());
            }

            indegree = new int[N+1];

            for(int s = 1; s<M+1; s++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b); //from -> to 간선 추가
                indegree[b]++;   //to의 진입 차수 1증가
            }

            //입력 끝 ---
            //위상 정렬 실행
            List<Integer> result = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();

            //진입 차수가 0인 노드를 큐에 추가
            for(int i = 1; i <= N; i++){
                if (indegree[i] == 0){
                    queue.add(i);
                }
            }
//            System.out.println(Arrays.toString(indegree));
            //큐가 빌 때까지 반복
            while(!queue.isEmpty()){
                int curr = queue.poll();
                result.add(curr);  //결과 리스트에 추가
//                System.out.println(Arrays.toString(indegree));
//                System.out.println(curr);
//                System.out.println(result);

                //현재 노드와 연결된 노드들의 진입 차수 감소
                for(int neighbor : graph.get(curr)){
                    indegree[neighbor]--;

                    //진입 차수가 0인 된 노드를 큐에 추가
                    if(indegree[neighbor] == 0){
                        queue.offer(neighbor);
                    }
                }
            }
            // 결과 출력
            System.out.print("#" + tc + " ");
            for(int node : result){
                System.out.print(node + " ");
            }
            System.out.println();



        }
    }
}
