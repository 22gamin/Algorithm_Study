package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2885 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		// 가장 작은 초콜릿 크기
		int size = 1;

		while (k > size) {
			size *= 2;
		}

		int cut = 0;
		int remain = k;
		int piece = size;

		while (remain > 0) {
			if (remain >= piece) {
				remain -= piece;
			} else {
				piece /= 2;
				cut++;
			}
		}

		System.out.println(size + " " + cut);
	}
}
