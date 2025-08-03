package test;
import java.io.*;
import java.util.*;

public class Main {
	static int [][] arr;
	static ArrayList<int[]> one;
	static int[] how;
	static int min ;
    public static void main(String[] args)throws IOException{
    	arr = new int [10][10];
    	one = new ArrayList<>();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	for(int i = 0; i<10; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());

    		for(int j =0; j<10; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    			if(arr[i][j]==1) {
    				one.add(new int[] {i,j});
    			}
    		}
    		
    	}
    	how = new int[5];
    	for(int i =0;i<5; i++) {
    		how[i] = 5;
    	}
    	min = Integer.MAX_VALUE;
    	back(0,0);
    	
    	if(min == Integer.MAX_VALUE) {
    		System.out.println("-1");
    	}else {
    		System.out.println(min);
    	}
    	
    
    }
    
    
    static void back(int d,int count ) {
    	
		if (count >= min) return;
		
    	if (d==one.size()) {
    		min = Math.min(min,count);
    		return;
    	}
    	
    	int x = one.get(d)[0];
    	int y = one.get(d)[1];
    	
    	if(arr[x][y]!=1) back(d+1,count);
    	
    	for(int i =4; i>=0; i--) {
    		if(how[i]==0) continue; // 색종이가 없으면
    		if(!isP(x,y,i)) continue;
    		p(x,y,i,0);
    		how[i]--;
    		back(d+1,count+1);
    		p(x,y,i,1);
    		how[i]++;
    		
    	}
    	
    }
    
    static boolean isP(int x, int y, int w) {
    	
    	if(x+w<10 && y+w<10) {
    		for(int i =x; i<=x+w; i++) {
    			for(int j =y; j<=y+w; j++) {
    				if(arr[i][j]==0) return false;
    			}
    		}
    	}else {
    		return false;
    	}
    	
    	return true;
    } // 붙일수 있는지 여부 판단 함수
    
    static void p(int x, int y, int w, int v) {
    	for(int i =x; i<=x+w; i++) {
    		for(int j =y; j<=y+w; j++) {
    			arr[i][j]=v;
    		}
    	}
    	
    	
    }// 붙이거나 떼는 함수(붙일때는 0, 뗄때(복구)는 1)
    
    
    
    
}
