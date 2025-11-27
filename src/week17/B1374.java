package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B1374 {

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            // 시작 시간 기준 오름차순
            if (this.start == o.start) {
                return this.end - o.end; // 시작 시간이 같으면 끝나는 시간 빠른 순
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken()); // 번호는 필요 없음
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s, e);
        }

        // 1. 강의들을 시작 시간 기준으로 정렬
        Arrays.sort(lectures);

        // 2. 현재 사용 중인 강의실들의 "끝나는 시간"을 관리하는 최소 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 첫 강의는 무조건 하나의 강의실에 배정
        pq.add(lectures[0].end);

        // 3. 나머지 강의들 처리
        for (int i = 1; i < N; i++) {
            Lecture cur = lectures[i];

            // 가장 빨리 끝나는 강의의 종료 시간
            int earliestEnd = pq.peek();

            if (cur.start >= earliestEnd) {
                pq.poll();
            }
            pq.add(cur.end);
        }

        System.out.println(pq.size());
    }
}
