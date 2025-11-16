import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static class Station{
		int prev ;
		int next ; 
		Station(int prev , int next){
			this.prev = prev;
			this.next = next;
		}
	}
	static Station[] sMap;

	static StringBuilder sb;
	
 	public static void main(String[] args)throws IOException {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		sMap = new Station[1000001];
		int [] temp = new int[n];
		
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(st2.nextToken());
			temp[i] = num;
		}
		
		for(int i = 0 ; i <n; i++) {
			if(n==1) {
				sMap[temp[i]]= new Station(temp[i],temp[i]);
				break;
			}
			if(i==0) {
				sMap[temp[i]]=  new Station(temp[n-1],temp[i+1]);
			}else if(i==n-1) {
				sMap[temp[i]]=  new Station(temp[i-1],temp[0]);
			
			}else {
				sMap[temp[i]] = new Station(temp[i-1],temp[i+1]);
			
			}
		}
		
		
		for(int i = 0; i<m; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			String q = st3.nextToken();
			if(q.equals("BN")) {
				int j = Integer.parseInt(st3.nextToken());
				int k = Integer.parseInt(st3.nextToken());
				
				Station a = sMap[j];

				
				bw.write(Integer.toString(a.next));
				bw.write("\n");
				int t  =a.next;
				a.next = k;

				if(sMap[k]!=null) {
					Station b = sMap[k];
					b.prev = j;
					b.next = t;
					sMap[t].prev = k;
				}else {			
					sMap[k] = new Station(j,t);
					sMap[t].prev = k;
					
				}
				
				
				
			}else if(q.equals("BP")) {
				int j = Integer.parseInt(st3.nextToken());
				int k = Integer.parseInt(st3.nextToken());
				
				Station a = sMap[j];
			
				bw.write(Integer.toString(a.prev));
				bw.write("\n");
				int t  =a.prev;
				a.prev = k;

				if(sMap[k]!=null) {
					Station b = sMap[k];
					b.next = j;
					b.prev = t;
					sMap[t].next = k;
				}else {			
					sMap[k] = new Station(t,j);
					sMap[t].next = k;
				}
				
			}else if(q.equals("CN")) {
				int j = Integer.parseInt(st3.nextToken());
				
				Station a = sMap[j];
				bw.write(Integer.toString(a.next));
				bw.write("\n");
				int tt =  a.next;
				a.next =sMap[a.next].next;
				sMap[a.next].prev = j;
				
				sMap[tt] = null;
				
			}else {
				int j = Integer.parseInt(st3.nextToken());
				
				Station a = sMap[j]; 
				
				bw.write(Integer.toString(a.prev));
				bw.write("\n");
				int tt = a.prev;
				a.prev = sMap[a.prev].prev;
				sMap[a.prev].next = j;
				sMap[tt]= null;
			}
			
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();
 	}
		
}
