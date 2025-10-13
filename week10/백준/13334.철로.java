import java.util.*;
import java.io.*;

public class Main {
	static class Line{
		int start;
		int end;
		int d;
		
		Line(int start, int end){
			this.start = start;
			this.end = end;	
			this.d = end - start;
		}
	}
	
	
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Line> list = new ArrayList<>();
        Queue<Line> startMin = new PriorityQueue<>( (a,b)->a.start-b.start );
        Queue<Line> endMin = new PriorityQueue<>( (a,b)->a.end-b.end );
        int max = 0; 
        
        for(int i =0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int h = Integer.parseInt(st.nextToken());
        	int o = Integer.parseInt(st.nextToken());
        	
        	int start = Math.min(h,o);
        	int end = Math.max(h,o);        	
        	list.add(new Line(start,end));
        }
        int d= Integer.parseInt(br.readLine());
        
        for(Line l : list) {
        	if(l.d<=d) {
        		endMin.offer(l);
        	}
        }
        
        while(!endMin.isEmpty()) {
        	Line l = endMin.poll();
        	int limitStart = l.end - d;
        	startMin.offer(l);
        	
        	while(!startMin.isEmpty()) {
        		Line temp = startMin.peek();
        		
        		if(temp.start>=limitStart) {
        			break;
        		}
        			
        		startMin.poll();
        	}
        	
        	max = Math.max(max,startMin.size());
        	
        	
        }
        
        System.out.println(max);
        
     
    }
}
