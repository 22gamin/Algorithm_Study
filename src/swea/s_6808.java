package swea;

import java.io.*;
import java.util.*;

public class s_6808 {

	static int[] gyu_cards = new int[10];
	static int[] in_cards = new int[10];
	static boolean[] visited = new boolean[19];
	static boolean[] card_visited = new boolean[10];

	static int win = 0;
	static int lose = 0;

	static void perm(int depths, int gyu_score, int in_score) {

		for (int k = 1; k<10; k++) {
			if(!card_visited[k]) {
				card_visited[k] = true;

				//9개까지 다 비교함
				if(depths == 9) {
					int G = gyu_cards[depths];
					int I = in_cards[k];
					if (G > I) gyu_score += G + I;
					else in_score += G + I;

					if (gyu_score > in_score) win++;
					else lose++;

					card_visited[k] = false;
					return;
				}

				//승부
				if (gyu_cards[depths] > in_cards[k]) {
					int G = gyu_cards[depths];
					int I = in_cards[k];
					perm(depths+1, gyu_score+G+I, in_score);
				}
				else {
					int G = gyu_cards[depths];
					int I = in_cards[k];
					perm(depths+1, gyu_score,in_score+G+I);
				}

				card_visited[k] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int i = 1; i < T+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean[] card_is = new boolean[19];

			//규영 카드 입력 받기
			for(int j = 1; j<10; j++) {
				gyu_cards[j] = Integer.parseInt(st.nextToken());
				card_is[gyu_cards[j]] = true;
			}

			//인영 카드 찾기
			int cnt = 1;
			for (int j =1; j<19; j++) {
				if(!card_is[j]) {
					in_cards[cnt] = j;
					cnt++;
				}
			}


			card_visited = new boolean[10];
			int depths = 1;
			int gyu_score = 0;
			int in_score = 0;
			win = 0;
			lose = 0;

			perm(depths,gyu_score,in_score);

			System.out.println("#" + i + " " + win + " "+ lose);

		}
		
	}

}
