package xweek16;

import java.util.*;
import java.io.*;

public class b_1043 {
	static int N, M;
	static boolean trueNums[],knowParty[]; //진실을 아는 사람
	static List<List<Integer>> parties = new ArrayList<>(); // 각 사람이 어떤 파티에 참여하는지
	static List<List<Integer>> only = new ArrayList<>();    //각 파티에 누가 참여하는지
	
	static void dfs(int person) {
		
		for(int igo : parties.get(person)) {
			if(!knowParty[igo]) knowParty[igo] = true;
			
			for(int dlie : only.get(igo)) {
				if(!trueNums[dlie]) {
					trueNums[dlie] = true;
					dfs(dlie);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//N과 M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//진실을 아는 사람
		st = new StringTokenizer(br.readLine());
		
		int trueNum = Integer.parseInt(st.nextToken());
		trueNums = new boolean[N+1];
		knowParty = new boolean[M];
		
		//그게 여러명 일 때
		if (trueNum != 0) {
			for(int i = 0; i<trueNum; i++) {
				int num = Integer.parseInt(st.nextToken());
				trueNums[num] = true;
			}
		}
		
		
		//파티 참석 
		for(int i = 0; i<N+1; i++) {
			parties.add(new ArrayList<>());
		}
		
		for(int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); //참여하는 사람 수
			List<Integer> p = new ArrayList<>();
			
			for(int i =0; i<num; i++) {
				int realPerson = Integer.parseInt(st.nextToken());
				
				if(trueNums[realPerson]) {
					knowParty[m] = true;
				}
				p.add(realPerson);
				parties.get(realPerson).add(m);
			}
			only.add(p);
		} //입력 끝
		
		
		for(int i = 1; i<trueNums.length; i++) {
			if(trueNums[i]) {
				dfs(i);
			}
		}
		
		int cnt = 0;
		for(int i=0 ; i<knowParty.length; i++) {
			if(!knowParty[i]) cnt++;
		}
		
		System.out.println(cnt);
	}

}
