package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B14226 {
	
	static boolean[][] visited = new boolean[2001][2001];

	static class Node {
		int screen;
		int clip;
		int time;

		Node(int s, int c, int t) {
			screen = s;
			clip = c;
			time = t;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 0, 0)); // 화면 1개, 클립보드 0개
		visited[1][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int screen = cur.screen;
			int clip = cur.clip;
			int time = cur.time;

			if (screen == S) {
				System.out.println(time);
				return;
			}

			// 1. 화면 전체 복사
			if (!visited[screen][screen]) {
				visited[screen][screen] = true;
				q.add(new Node(screen, screen, time + 1));
			}

			// 2. 붙여넣기
			if (clip > 0 && screen + clip <= 2000) {
				if (!visited[screen + clip][clip]) {
					visited[screen + clip][clip] = true;
					q.add(new Node(screen + clip, clip, time + 1));
				}
			}
			// 3. 화면에서 1개 삭제
			if (screen > 0) {
				if (!visited[screen - 1][clip]) {
					visited[screen - 1][clip] = true;
					q.add(new Node(screen - 1, clip, time + 1));
				}
			}
		}
	}
}
