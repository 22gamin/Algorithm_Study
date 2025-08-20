import java.util.*;
import java.io.*;

public class swea_1238_김민종 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());           //간선 길이
            int S = Integer.parseInt(st.nextToken());           //시작

            List<Integer>[] graph = new ArrayList[101];         //1~100
            for(int i = 1; i <= 100; i++){
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < L / 2; i++){                     //(from -to) 구조로 입력받으므로 L/2 
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);                                //a -> b
            }

            //BFS
            int[] dist = new int[101];
            Arrays.fill(dist, -1);                              //방문하지 않음 : -1 
            Queue<Integer> q = new ArrayDeque<>();
            dist[S] = 0;
            q.offer(S);

            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : graph[cur]){                     //cur에서 갈 수 있는 모든 정점
                    if(dist[next] == -1){                       //아직 방문한거 아니라면
                        dist[next] = dist[cur] + 1;             //거리 갱신
                        q.offer(next);                  
                    }
                }
            }

            //제일 멀리 있는거 거리 찾기
            int max = 0;
            for(int i = 1; i <= 100; i++){
                max = Math.max(dist[i], max);
            }

            //max 거리 중 번호가 가장 큰 정점 찾기
            int ans = 0;
            for(int i = 1; i <= 100; i++){          
                if(dist[i] == max){
                    ans = Math.max(ans, i);
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
