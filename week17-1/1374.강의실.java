import java.io.*;
import java.util.*;

public class Main {
	static int n ;
	static class Class{
		int s;
		int e;
		int num;
		
		Class(int s, int e, int num){
			this.s = s;
			this.e = e;
			this.num = num;
		}
	}
	static TreeMap<Integer,Integer> classRoom;
	static PriorityQueue<Class> pq;
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		n = Integer.parseInt(br.readLine());
		
		classRoom = new TreeMap<>();
		
		pq = new PriorityQueue<>(
				(a,b)->{
					return b.e-a.e;
				}	
		);
		
		for(int i =0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			pq.offer(new Class(s,e,num));
			
		}
		
		
		while(!pq.isEmpty()) {
			Class temp = pq.poll();
			int s = temp.s;
			int e = temp.e;
			
			Integer x =classRoom.ceilingKey(e);
			
			if(x==null) { //현재 해당 시간의 클래스가 들어갈수있는 반이 없을때
				if(classRoom.get(s)!=null) {
					classRoom.put(s,classRoom.get(s)+1);
				}else {
					classRoom.put(s,1);
				} //반을 만들고 s시작 즉 이 강의시간이 시작된는 시간을 즉 제일 앞에잇는 강의시간의 시작시간의 클래스의 개수를 하나로둔다.
			}else {
				int count =classRoom.get(x);
				if(count==1) { //이 클래스가 들어갈수잇는 강의가
					classRoom.remove(x);
					if(classRoom.get(s)!=null) {
						classRoom.put(s,classRoom.get(s)+1);
					}else {
						classRoom.put(s,1);
					}
					
				}else {
					classRoom.put(x,  count-1);
					Integer p = classRoom.get(s);
                    
                    if(p ==null){
                        classRoom.put(s,1);
                    }else{
                        classRoom.put(s,p+1);
                    }
				}
			}
		}
		int result = 0;
		for (int count : classRoom.values()) {
			result += count;
		}
		System.out.println(result);
		
	}
}
