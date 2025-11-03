package week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1063 {
    static final int SIZE = 8;

    static class Pos {
        int x, y; // x: 0..7 (A..H), y: 0..7 (1..8)
        Pos(int x, int y){ this.x = x; this.y = y; }
        boolean in() { return 0 <= x && x < SIZE && 0 <= y && y < SIZE; }
    }

    static Pos parse(String s) {
        int x = s.charAt(0) - 'A';
        int y = s.charAt(1) - '1';
        return new Pos(x, y);
    }

    static String toStr(Pos p) {
        return "" + (char)('A' + p.x) + (char)('1' + p.y);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Pos king = parse(st.nextToken());
        Pos rock = parse(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<String, int[]> mv = new HashMap<>();
        mv.put("R",  new int[]{+1,  0});
        mv.put("L",  new int[]{-1,  0});
        mv.put("B",  new int[]{ 0, -1});
        mv.put("T",  new int[]{ 0, +1});
        mv.put("RT", new int[]{+1, +1});
        mv.put("LT", new int[]{-1, +1});
        mv.put("RB", new int[]{+1, -1});
        mv.put("LB", new int[]{-1, -1});

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine().trim();
            int[] d = mv.get(cmd);
            int nkx = king.x + d[0], nky = king.y + d[1];

            // 왕 이동이 보드 밖이면 스킵
            if (nkx < 0 || nkx >= SIZE || nky < 0 || nky >= SIZE) continue;

            // 왕이 가려는 칸이 돌 자리인지 체크
            if (nkx == rock.x && nky == rock.y) {
                int nrx = rock.x + d[0], nry = rock.y + d[1];
                // 돌이 밖으로 나가면 스킵
                if (nrx < 0 || nrx >= SIZE || nry < 0 || nry >= SIZE) continue;
                // 돌과 왕 모두 이동
                rock.x = nrx; rock.y = nry;
            }
            king.x = nkx; king.y = nky;
        }

        System.out.println(toStr(king));
        System.out.println(toStr(rock));
    }
}
