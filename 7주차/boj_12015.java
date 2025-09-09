import java.util.*;
import java.io.*;

class boj_12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> A = new ArrayList<>(); // 리스트로 배열 입력 받음

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (A.isEmpty()) { // 리스트가 비어있으면(첫 숫자 입력 받기) 값 추가
                A.add(num);
            } else if (num > A.get(A.size() - 1)) { // 입력받는 값이 리스트 마지막 숫자보다 크면 리스트에 바로 추가
                A.add(num);
            } else { // 입력받는 값이 리스트 마지막 숫자보다 작을 경우
                int idx = Collections.binarySearch(A, num); // 이진 탐색으로 n의 위치 찾기

                if (idx < 0) { // idx가 음수일 경우 입력값이 리스트 내에 존재하지 않는다는 뜻
                    idx = -(idx + 1); // -(idx + 1)해서 삽입해야 할 위치로 변환
                }

                A.set(idx, num); // 값 추가
            }
        }

        System.out.println(A.size());
    }
}
