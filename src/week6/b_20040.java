package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_20040 {

    static int[] parent; // 각 노드의 부모(대표)를 저장하는 배열

    // x가 속한 집합의 대표를 찾는 연산 (경로 압축 포함)
    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // a와 b가 속한 두 집합을 합치는 연산
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        // 두 노드의 대표가 다를 경우, 번호가 작은 쪽을 대표로 합침
        if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 점의 개수
        int m = Integer.parseInt(st.nextToken()); // 차례의 수

        // 1. Union-Find 초기화: 모든 점이 자기 자신을 대표로 가짐
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 2. M번의 턴을 진행
        for (int turn = 1; turn <= m; turn++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 두 점의 대표가 같은지 확인
            if (find(u) == find(v)) {
                // 대표가 같다면 이미 연결된 상태 -> 사이클 발생
                System.out.println(turn);
                return; // 프로그램을 종료
            } else {
                // 대표가 다르다면 두 그룹을 합침
                union(u, v);
            }
        }

        // 3. M번의 턴이 모두 끝나도 사이클이 없으면 0 출력
        System.out.println(0);
    }
}