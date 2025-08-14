import java.io.*;
import java.util.*;
 
public class Solution {
 
    static int n;
    static int[] arr;
    static long count;
 
    public static void main(String[] args) throws IOException {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            arr = new int[n];
 
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
 
            int r = 1;
            int start = 0;
            int mI = 1;
            count = 0;
            while (r < n && start < n) {
                if (arr[start] < arr[r]) {
                    mI = r;
                    r++;
                    while (r < n) {
                        if (arr[r] > arr[r - 1]) {
                            mI = r;
                            r++;
                        } else {
                            break;
                        }
                    }
                    if (r >= n) {
                        break;
                    }
 
                    while (r < n - 1) {
                        if (arr[r] > arr[r + 1]) {
                            r++;
                        } else {
                            break;
                        }
                    }
                    int a = mI - start;
                    int b = r - mI;
                    count += a * b;
                    start = r;
                    r++;
 
                } else {
                    start = r;
                    r++;
                }
            }
            System.out.println("#" + tc + " " + count);
        }
 
        sc.close();
    }
}
