package week14;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class B16928 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        
        // 사다리 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;  // 사다리: start -> end로 이동
        }

        // 뱀 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;  // 뱀: start -> end로 이동
        }


        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        int[] dist = new int[101]; 

        queue.add(1); 
        visited[1] = true;
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = current + i;

                if (next <= 100) {
                    if (board[next] != 0) {
                        next = board[next];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        dist[next] = dist[current] + 1;
                        queue.add(next);

                        if (next == 100) {
                            System.out.println(dist[next]);
                            return;
                        }
                    }
                }
            }
        }
    }
}
