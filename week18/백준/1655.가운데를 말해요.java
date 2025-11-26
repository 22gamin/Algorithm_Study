import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue <Integer> left  =new PriorityQueue<>((a,b)->{return b-a;});
        PriorityQueue <Integer> right  =new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<=n; i++) {
        	int x = Integer.parseInt(br.readLine());
        	
        	if(i%2==0) { //무조건 left가 하나 더 많은 상태임 그래서 무조건 r과 l 크기가 같게 맞춰야함
        		
        		if(x<left.peek()) {
        			int needMove = left.poll();
        			left.offer(x);
        			right.offer(needMove);
        			
        			sb.append(left.peek()).append("\n");
        			
        		}else {
        			right.offer(x);
        			sb.append(left.peek()).append("\n");
        		}
        		
        		
        	}else { //무조건 left 랑 right가 같은 상태임 left가 하나더 크도록 만들어야함
        		if(i==1) {
        			left.offer(x);
        			sb.append(left.peek()).append("\n");
        			continue;
        		}
        		if(x>right.peek()) {
        			int needMove = right.poll();
        			right.offer(x);
        			left.offer(needMove);
        			sb.append(left.peek()).append("\n");
        		}else {
        			left.offer(x);
        			sb.append(left.peek()).append("\n");
        		}
        		
        	
        	}
        }
        System.out.println(sb.toString());
        
    }
}
