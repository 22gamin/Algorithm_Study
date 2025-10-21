package xweek13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14891 {
	static int[] chain1, chain2, chain3, chain4;
	static int r1, r2, l2, r3, l3, l4;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		chain1 = new int[8];
		chain2 = new int[8];
		chain3 = new int[8];
		chain4 = new int[8];
		
		// 톱니바퀴 상태 입력 
		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();
		String s4 = br.readLine();
		
		for(int j=0; j<8; j++) {
			chain1[j] = s1.charAt(j) - '0';
			chain2[j] = s2.charAt(j) - '0';
			chain3[j] = s3.charAt(j) - '0';
			chain4[j] = s4.charAt(j) - '0';
		}
				
		r1 = 2;
		r2 = 2;
		l2 = 6;
		r3 = 2;
		l3 = 6;
		l4 = 6;
		int r = Integer.parseInt(br.readLine());
		for(int i=0; i<r; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 톱니바퀴 번호 
			int num = Integer.parseInt(st.nextToken());
			// 1 : 시계, 2 : 반시계
			int d = Integer.parseInt(st.nextToken());
			
			// 회전시키기
			// funcRotate(d);
			
			// index 2, 6
			
			int[] directions = new int[5]; // 1~4번 톱니의 회전 방향 저장 (0:안돔, 1:시계, 2:반시계)
			directions[num] = d;
			
			for (int k = num; k > 1; k--) {
				if (k == 2) { // 2번이 1번에게 전파
					if (chain1[r1] != chain2[l2]) {
						directions[1] = (directions[2] == 1) ? 2 : 1;
					} else {
						break; // 극이 같으면 전파 중단
					}
				} else if (k == 3) { // 3번이 2번에게 전파
					if (chain2[r2] != chain3[l3]) {
						directions[2] = (directions[3] == 1) ? 2 : 1;
					} else {
						break;
					}
				} else if (k == 4) { // 4번이 3번에게 전파
					if (chain3[r3] != chain4[l4]) {
						directions[3] = (directions[4] == 1) ? 2 : 1;
					} else {
						break;
					}
				}
			}
			
			for (int k = num; k < 4; k++) {
				if (k == 1) { // 1번이 2번에게 전파
					if (chain1[r1] != chain2[l2]) {
						directions[2] = (directions[1] == 1) ? 2 : 1;
					} else {
						break;
					}
				} else if (k == 2) { // 2번이 3번에게 전파
					if (chain2[r2] != chain3[l3]) {
						directions[3] = (directions[2] == 1) ? 2 : 1;
					} else {
						break;
					}
				} else if (k == 3) { // 3번이 4번에게 전파
					if (chain3[r3] != chain4[l4]) {
						directions[4] = (directions[3] == 1) ? 2 : 1;
					} else {
						break;
					}
				}
			}
			
			if (directions[1] != 0) {
				r1 = funcRotate(directions[1], r1);
			}
			if (directions[2] != 0) {
				r2 = funcRotate(directions[2], r2);
				l2 = funcRotate(directions[2], l2);
			}
			if (directions[3] != 0) {
				r3 = funcRotate(directions[3], r3);
				l3 = funcRotate(directions[3], l3);
			}
			if (directions[4] != 0) {
				l4 = funcRotate(directions[4], l4);
			}
			
			
//			if(num == 1) {
//				// 회전 톱니 세팅
//				r1 = funcRotate(d, r1);
//				
//				// chain2
//				compareRotate1bet2(d, 2);
//				// chain3
//				compareRotate2bet3(d, 3);
//				// chain4
//				compareRotate3bet4(d, 4);
//			}else if(num == 2) {
//				r2 = funcRotate(d, r2);
//				l2 = funcRotate(d, l2);
//				// chain1
//				compareRotate1bet2(d, 1);
//				// chain3
//				compareRotate2bet3(d, 3);
//				// chain4
//				compareRotate3bet4(d, 4);
//			}
//			else if(num == 3) {
//				r3 = funcRotate(d, r3);
//				l3 = funcRotate(d, l3);				
//				
//				// chain2
//				compareRotate2bet3(d, 2);
//				// chain1
//				compareRotate1bet2(d, 1);
//				// chain4
//				compareRotate3bet4(d, 4);
//			}else if(num == 4) {
//				l4 = funcRotate(d, l4);
//				
//				// chain3
//				compareRotate3bet4(d, 3);
//				// chain2
//				compareRotate2bet3(d, 2);				
//				// chain1
//				compareRotate1bet2(d, 1);
//				
//			}
		}
		int total = 0;
		r1-=2;
		if(r1<0) r1 = 8+r1;
		if(chain1[r1] == 1) total+=1;
		
		r2-=2;
		if(r2<0) r2 = 8+r2;
		if(chain2[r2] == 1) total+=2;
		
		r3-=2;
		if(r3<0) r3 = 8+r3;
		if(chain3[r3] == 1) total+=4;
		
		l4+=2;
		if(l4>7) l4 -= 8;		
		if(chain4[l4] == 1) total+=8;
		
//		System.out.println(chain1[r1]);
//		System.out.println(chain2[r2]);
//		System.out.println(chain3[r3]);
//		System.out.println(chain4[l4]);
		
		System.out.println(total);
	}
//	// 1 2
//	public static void compareRotate1bet2(int d, int k) {
//		// 두개가 다를 경우
//		if(chain1[r1] != chain2[l2]) {
//			// 1에서 2
//			if(k == 2) {
//				r2 = funcRotate(-d, r2);
//				l2 = funcRotate(-d, l2);
//			}
//			// 2에서 1
//			else {
//				r1 = funcRotate(-d, r2);
//			}
//		}else return;
//	}
//	//2 3
//	public static void compareRotate2bet3(int d, int k) {
//		// 두개가 다를 경우
//		if(chain2[r2] != chain3[l3]) {
//			// 2에서 3
//			if(k == 3) {
//				r3 = funcRotate(-d, r3);
//				l3 = funcRotate(-d, l3);
//			}
//			// 3에서 2
//			else {
//				r2 = funcRotate(-d, r2);
//				l2 = funcRotate(-d, l2);
//			}
//		}else return;
//	}
//	//3 4
//	public static void compareRotate3bet4(int d, int k) {
//		// 두개가 다를 경우
//		if(chain3[r3] != chain4[l4]) {
//			// 4에서 3
//			if(k == 3) {
//				r3 = funcRotate(-d, r3);
//				l3 = funcRotate(-d, l3);
//			}
//			// 3에서 4
//			else {
//				l4 = funcRotate(-d, l4);
//			}
//		}else return;
//	}
	
	// 회전 
	public static int funcRotate(int d, int t) {
		// 시계일때 
		if(d == 1) {
			t--;
			if(t == -1) t = 7;
					
		}else {
			t++;
			if(t == 8) t = 0;	
		}	
		return t;
	}	
}
