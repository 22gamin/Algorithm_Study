import java.io.*; 
import java.util.*;

public class Main {

static int N, S;
static int[] x;
static int[] h;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken()) - 1;

    x = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
        x[i] = Integer.parseInt(st.nextToken());
    }

    h = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
        h[i] = Integer.parseInt(st.nextToken());
    }

    int left = S;
    int right = S;
    
    long minRange = x[S] - h[S];
    long maxRange = x[S] + h[S];

    while (true) {
        boolean expanded = false;

        while (left > 0 && x[left - 1] >= minRange) {
            left--;
            minRange = Math.min(minRange, x[left] - h[left]);
            maxRange = Math.max(maxRange, x[left] + h[left]);
            expanded = true;
        }

        while (right < N - 1 && x[right + 1] <= maxRange) {
            right++;
            minRange = Math.min(minRange, x[right] - h[right]);
            maxRange = Math.max(maxRange, x[right] + h[right]);
            expanded = true;
        }

        if (!expanded) break;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = left; i <= right; i++) {
        sb.append(i + 1).append(" ");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
}
}
