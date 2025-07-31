package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B2371_장가은 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> files = new ArrayList<>();
        int maxLen = 0;

        // 각 파일 입력 받기
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            List<Integer> file = new ArrayList<>();
            for (String token : tokens) {
                if (token.equals("-1")) break;
                file.add(Integer.parseInt(token));
            }
            files.add(file);
            maxLen = Math.max(maxLen, file.size());
        }

        // K를 1부터 maxLen까지 늘려가며 검사
        for (int k = 1; k <= maxLen; k++) {
            Set<String> seen = new HashSet<>();

            for (List<Integer> file : files) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < k; i++) {
                    if (i < file.size()) sb.append(file.get(i)).append(",");
                    else sb.append("0,"); // 부족하면 0으로 패딩
                }
                seen.add(sb.toString());
            }

            if (seen.size() == n) { // 모든 파일이 구분 가능할 때
                System.out.println(k);
                return;
            }
        }

        // 모든 구분이 되려면 maxLen까지 봐야 하는 경우
        System.out.println(maxLen);
    }

}
