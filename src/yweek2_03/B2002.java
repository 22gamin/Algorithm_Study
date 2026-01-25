package yweek2_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class B2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            li.add(br.readLine());
        }

        int count = 0;
        for (int i=0; i < n; i++) {
            String exitedCar = br.readLine();
            if (!li.get(0).equals(exitedCar)) {
                count++;
                li.remove(exitedCar);
            } else {
                li.remove(0);
            }
        }
        System.out.println(count);
    }
}
