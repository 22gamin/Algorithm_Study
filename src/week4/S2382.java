package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S2382 {

	static class Group {
		int r, c, cnt, dir;

		Group(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
	}

	static int[] dr = { 0, -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dy = { 0, 0, 0, -1, 1 };
	static int[] rev = { 0, 2, 1, 4, 3 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 한 변 길
			int M = Integer.parseInt(st.nextToken()); // 격리 시간
			int K = Integer.parseInt(st.nextToken()); // 군집 수

			List<Group> groups = new ArrayList<>(K);
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				groups.add(new Group(r, c, cnt, dir));
			}
			
			for(int t=0;t<M;t++) {
				HashMap<Integer, int[]> map = new HashMap<>(groups.size());
				for(Group g : groups) {
					if(g.cnt==0) continue;
					
					int nr=g.r+dr[g.dir];
					int nc=g.c+dr[g.dir];
					int ncnt=g.cnt;
					int ndir=g.dir;
					
					if(nr==0 || nc==N-1 || nc==0 || nr==N-1) {
						ncnt/=2;
						if(ncnt==0) continue; // 사라짐
						ndir=rev[ndir];
					}
					
					int key=nr*1000+nc;
					int[] acc=map.get(key);
					if(acc==null) {
						acc = new int[] {ncnt,ncnt,ndir};
						map.put(key, acc);
					}else {
						acc[0] +=ncnt;
						if(ncnt>acc[1]) {
							acc[1]=ncnt;
							acc[2]=ndir;
						}
					}	
				}
				groups = new ArrayList<>(map.size());
                for (Map.Entry<Integer, int[]> e : map.entrySet()) {
                    int key = e.getKey();
                    int r = key / 1000, c = key % 1000;
                    int sum = e.getValue()[0];
                    int dir = e.getValue()[2];
                    groups.add(new Group(r, c, sum, dir));
                }
			}
		}
	}
}
