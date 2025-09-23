package week5;

import java.io.*;
import java.util.*;

public class b_17471 {

    static int N;
    static int[] populations; // 각 구역의 인구수
    static List<Integer>[] adjList; // 인접 리스트 그래프
    static boolean[] isSelected; // A 선거구에 선택되었는지 여부
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        populations = new int[N + 1];
        adjList = new ArrayList[N + 1];
        isSelected = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 1번 구역부터 A 선거구에 포함시킬지 여부를 결정하는 부분집합 생성 시작
        generateSubsets(1);

        if (minDifference == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDifference);
        }
    }

    // 1. A 선거구에 포함될 구역을 뽑는 모든 부분집합을 재귀로 생성
    static void generateSubsets(int index) {
        // 모든 구역에 대한 선택이 완료되었을 때
        if (index == N + 1) {
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();
            int popA = 0, popB = 0;

            for (int i = 1; i <= N; i++) {
                if (isSelected[i]) {
                    groupA.add(i);
                    popA += populations[i];
                } else {
                    groupB.add(i);
                    popB += populations[i];
                }
            }

            // 규칙 1: 두 선거구 모두 최소 1개 이상의 구역을 포함해야 함
            if (groupA.isEmpty() || groupB.isEmpty()) {
                return;
            }

            // 규칙 2: 각 선거구의 구역들이 모두 연결되어 있는지 확인
            if (isConnected(groupA) && isConnected(groupB)) {
                minDifference = Math.min(minDifference, Math.abs(popA - popB));
            }
            return;
        }

        // 현재 index의 구역을 A 선거구에 포함시키는 경우
        isSelected[index] = true;
        generateSubsets(index + 1);

        // 현재 index의 구역을 A 선거구에 포함시키지 않는 경우 (B 선거구가 됨)
        isSelected[index] = false;
        generateSubsets(index + 1);
    }

    // 2. 한 선거구 내의 구역들이 모두 연결되어 있는지 BFS로 확인
    static boolean isConnected(List<Integer> group) {
        if (group.isEmpty()) {
            return false; // 이 경우는 위에서 처리되지만 안전장치
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int startNode = group.get(0);

        queue.offer(startNode);
        visited[startNode] = true;
        int visitedCount = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjList[current]) {
                // 인접한 노드가 같은 그룹에 속해 있고, 아직 방문하지 않았다면
                if (group.contains(neighbor) && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    visitedCount++;
                }
            }
        }

        // 탐색 후 방문한 노드의 수가 그룹의 전체 노드 수와 같으면 모두 연결된 것
        return visitedCount == group.size();
    }
}
