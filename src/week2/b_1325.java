package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b_1325 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] answer;
    static int cnt = 0;

    static int dfs(int start) {

        for (int num: graph.get(start)) {
            if (!visited[num]) {
                visited[num] = true;
                cnt ++;
                dfs(num);

            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        answer = new int[N+1];

        for(int i = 0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        //노드 저장(해킹할 수 있는 컴퓨터만 저장 -> 양방향 x)
        for (int i = 0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            graph.get(b).add(a);
        }

        for(int k=1; k<N+1; k++) {
            cnt = 0;
            visited = new boolean[N+1];
            visited[k] = true;
            answer[k] = dfs(k);
        }

        //최대값 찾기
        int max_value = 0;
        for (int i : answer) {
            if (i >= max_value)
                max_value = i;
        }

        // 최대값인 값들 오름차순으로 출력
        for(int i = 0; i< answer.length; i++){
            if (answer[i] == max_value){
                System.out.print(i + " ");
            }
        }
    }
}

