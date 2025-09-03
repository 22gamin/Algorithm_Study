import java.util.*;
import java.io.*;

public class boj_4195 {
    static HashMap<String, String> parent; // 사람의 부모 노드 저장
    static HashMap<String, Integer> size; // 사람의 친구 수 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int F = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            size = new HashMap<>();

            for (int f = 0; f < F; f++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!parent.containsKey(a)) { // 이름 처음 나오면
                    parent.put(a, a);
                    size.put(a, 1);
                }

                if (!parent.containsKey(b)) { // 이름 처음 나오면
                    parent.put(b, b);
                    size.put(b, 1);
                }

                sb.append(union(a, b)).append('\n');
            }
        }
        System.out.print(sb);
    }

    public static String find(String s) { // s의 부모 노드 찾기
        if (s.equals(parent.get(s)))
            return s;

        parent.put(s, find(parent.get(s)));
        return parent.get(s);
    }

    public static int union(String a, String b) { // a, b 집합 합치기
        String ar = find(a);
        String br = find(b);

        if (ar.equals(br)) // a, b가 같은 집합이면
            return size.get(ar); // 바로 크기 반환

        int as = size.get(ar);
        int bs = size.get(br);

        if (as >= bs) { // a가 속한 집합이 더 크거나 같으면 a 집합에 b가 들어가기
            parent.put(br, ar); // b의 부모 노드 --> a
            size.put(ar, as + bs); // a 집합의 크기는 b 집합까지 더해진 크기로 갱신
            return size.get(ar); // a 집합의 크기 반환
        } else { // b가 속한 집합이 더 크면 위에꺼 반대로 해주기
            parent.put(ar, br);
            size.put(br, as + bs);
            return size.get(br);
        }
    }

}
