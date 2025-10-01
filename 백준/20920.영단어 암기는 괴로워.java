import java.util.*;
import java.io.*;

public class Main {
	static class Word implements Comparable<Word>{
		String w ;
		int count;
		
		Word(String w, int count){
			this.w = w;
			this.count = count;
		}
		
		@Override
		public int compareTo(Word o) {
			
			if(this.count!=o.count) {
				return  o.count-this.count;
			}  //첫번째 우선순위 차례 , 단어가 나오는 횟수
			
			if(this.w.length()!=o.w.length()){
				return  o.w.length()-this.w.length();
			}//두번째 우선순위 차례 , 단어의 길이
			
			return this.w.compareTo(o.w);
			//이전 조건들이 비교가 안되면 그냥 사전순으로ㄱㄱ (String도 comparable을 구현하기에 자체 compareTo가능
		};
	}
	
	
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String,Word> map = new HashMap<>(); //문자열을 인덱스로 쓰고 싶으니 키를 String으로ㄱㄱ
        
        for(int i = 0 ; i<n; i++) {
        	String a = br.readLine();
        	if(a.length()>=m) {
        		
        		if(map.get(a)==null) { //null 즉 단어가 등장한적이 없어서 클래스가 생성된 적 없다면
        			map.put(a,new Word(a,1)); //클래스 만들어주고
        		}else {
        			map.get(a).count++; // 이전에 등장한적 있으면 카운트 늘려주고
        		}
        		
        		
        	}
        }
        
        
       Queue<Word> pq  =new PriorityQueue<>(map.values());
       
       StringBuilder sb = new StringBuilder();
       
       while(!pq.isEmpty()) {
    	   sb.append(pq.poll().w).append("\n");
       }
       
       bw.write(sb.toString());
       bw.flush();
     
    }
}
