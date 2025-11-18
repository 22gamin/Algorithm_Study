package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 레이어 수
		int layers = Math.min(N, M) / 2;
		// 하나씩 회전
		for (int layer = 0; layer < layers; layer++) {
			int top = layer;
			int left = layer;
			int bottom = N - 1 - layer;
			int right = M - 1 - layer;

			int height = bottom - top + 1; // 레이어 테두리 따라 총 몇개의 값이 있는지
			int width = right - left + 1;

			int length = (height + width - 2) * 2; // 사각형 둘레
			int realR = R % length; // 돌릴 횟수

			int[] temp = new int[length]; // 테두리 값 -> 1차원 배열로 뽑음
			int idx = 0;

			// 위쪽 줄 (왼쪽 -> 오른쪽)
			for (int j = left; j <= right; j++) {
				temp[idx++] = arr[top][j];
			}
			// 오른쪽 줄 (위 -> 아래)
			for (int i = top + 1; i <= bottom; i++) {
				temp[idx++] = arr[i][right];
			}
			// 아래쪽 줄 (오른쪽 -> 왼쪽)
			for (int j = right - 1; j >= left; j--) {
				temp[idx++] = arr[bottom][j];
			}
			// 왼쪽 줄 (아래 -> 위)
			for (int i = bottom - 1; i > top; i--) {
				temp[idx++] = arr[i][left];
			}

			// 회전
			int[] rotated = new int[length];
			for (int i = 0; i < length; i++) {
				rotated[i] = temp[(i + realR) % length];
			}

			// 회전된 값 다시 채워넣기
			idx = 0;
			// 위쪽 줄 (왼쪽 → 오른쪽)
			for (int j = left; j <= right; j++) {
				arr[top][j] = rotated[idx++];
			}
			// 오른쪽 줄 ( 위 → 아래 )
			for (int i = top + 1; i <= bottom; i++) {
				arr[i][right] = rotated[idx++];
			}
			// 아래쪽 줄 (오른쪽 → 왼쪽)
			for (int j = right - 1; j >= left; j--) {
				arr[bottom][j] = rotated[idx++];
			}
			// 왼쪽 줄 (아래 → 위)
			for (int i = bottom - 1; i > top; i--) {
				arr[i][left] = rotated[idx++];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
