package week14;

import java.io.*;
import java.util.*;

public class B2002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        String[] in = new String[N];
        for (int i = 0; i < N; i++) in[i] = br.readLine().trim();

        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < N; i++) idxMap.put(in[i], i);

        boolean[] exited = new boolean[N]; 
        int idx = 0;                     
        int overtake = 0;

        for (int i = 0; i < N; i++) {
            String outCar = br.readLine().trim();
            int outIdx = idxMap.get(outCar);

            while (idx < N && exited[idx]) idx++;

            if (idx < N && outIdx != idx) overtake++;

            exited[outIdx] = true;
        }

        System.out.println(overtake);
    }
}
