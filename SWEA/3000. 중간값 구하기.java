import java.util.*;
import java.io.*;

class Solution{
	static int n;
	public static void main(String[] args)throws IOException {
		//System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			Queue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
			Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
			int module = 20171109;
			long result = 0;
			maxHeap.offer(Integer.parseInt(st.nextToken()));
			for(int i =0; i<n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				
				int maxSize = maxHeap.size();
				int minSize = minHeap.size();
				
				if(maxSize>=minSize+1) {
					if(maxHeap.peek()>a) {
						int temp = maxHeap.poll();
						minHeap.offer(temp);
						maxHeap.offer(a);
					}else {
						minHeap.offer(a);
					}
				}else if(minSize == maxSize) {
					if(maxHeap.peek()<a) {
						minHeap.offer(a);
						int temp = minHeap.poll();
						maxHeap.offer(temp);
					}else {
						maxHeap.offer(a);
					}
				}
				maxSize = maxHeap.size();
				minSize = minHeap.size();
				
				if(maxSize>=minSize+1) {
					if(maxHeap.peek()>b) {
						int temp = maxHeap.poll();
						minHeap.offer(temp);
						maxHeap.offer(b);
					}else {
						minHeap.offer(b);
					}
				}else if(minSize == maxSize) {
					if(maxHeap.peek()<b) {
						minHeap.offer(b);
						int temp = minHeap.poll();
						maxHeap.offer(temp);
					}else {
						maxHeap.offer(b);
					}
				}
				
				result = (result+maxHeap.peek())%module;
				
				
				
			}
			
			System.out.println("#"+tc+" "+result);
			
		}
	}
}
