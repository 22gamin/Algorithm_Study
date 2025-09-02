import java.util.*;
import java.io.*;

public class boj_18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = arr.clone(); // 정렬용 배열 하나 추가
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>(); // 좌표 압축용 맵
        int x = 0;
        for (int i : sorted) { // 정렬된 배열의 값을 키, 압축된 좌표를 값으로
            if (!map.containsKey(i)) { // 이미 있으면 스킵
                map.put(i, x);
                x++;
            }
        }
        StringBuilder sb = new StringBuilder(); // 이거 안쓰면 시간초과남;;
        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
