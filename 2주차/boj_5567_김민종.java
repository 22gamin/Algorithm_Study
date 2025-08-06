import java.util.*;
import java.io.*;

public class boj_5567_김민종 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){            //N 포함 안해서 인덱스 범위 초과 에러 뜸!ㅇ!
            list.add(new ArrayList<>());        //인접 리스트 생성
        }

        for(int i = 0; i < M; i++){             //친구 관계 입력
            StringTokenizer st = new StringTokenizer(br.readLine());       
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        Queue<int[]> queue = new LinkedList<>();    //BFS 탐색을 위한 큐 초기화
        queue.offer(new int[]{1, 0});               //[사람 번호, 깊이] 정보를 담음 ex)[상근이, 0단계]

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        int ans = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int person = cur[0];
            int depth = cur[1];

            if(depth >= 1 && depth <= 2) ans++;
            if(depth == 2) continue;                //친구의 친구까지만 찾고 컷

            for(int j : list.get(person)) {         //현재 사람의 모든 친구 구경
                if(!visited[j]){
                    visited[j] = true;
                    queue.offer(new int[]{j, depth + 1});
                }
            }
        }
        
        System.out.println(ans);
    }
}