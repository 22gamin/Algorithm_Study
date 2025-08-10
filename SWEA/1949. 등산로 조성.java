import java.util.*;
import java.io.*;
 
public class Solution{
    static int n, k;
    static int [][] arr;
    static int max ;
    static int [][] visit;
    static ArrayList<int []> start;
    static int[] dx = new int[] {0,0,-1,1};
    static int[] dy = new int[] {1,-1,0,0};
    public static void main(String[] arg)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            start = new ArrayList<>();
            visit = new int[n][n];
            arr = new int [n][n];
            int maxHeight =0;
            for(int i =0; i<n; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for(int j= 0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st2.nextToken());
                    if(maxHeight<=arr[i][j]) {
                        maxHeight = arr[i][j];
                    }
                }
            }
             
             
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][j] == maxHeight) {
                        start.add(new int [] {i,j});
                    }
                }
            }
             
            max = Integer.MIN_VALUE;
             
            for(int[] h : start) {
                int x = h[0];
                int y = h[1];
                back(x,y,true,1);
            }
             
            System.out.println("#"+tc+" "+max);
             
        }
    }
     
    static void back(int x, int y, boolean isK,int depth) {
        visit[x][y]=1;
        max = Math.max(max, depth);
         
        for(int i =0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
             
            if(nx>=0 && nx<n && ny >=0 && ny<n) { //
                if(visit[nx][ny]==0) {
                    //나보다 값이 작을때
                    //나보다 값이 작지 않을때
                        //값이 나보다 작지만 k값 보다 갭이 작을때
                        //안작을때(호출몬함)
                     
                    if(arr[nx][ny]<arr[x][y]) {
                        back(nx,ny,isK,depth+1);
                    }else {
                        int gap = arr[nx][ny] - arr[x][y];
                        if(gap<k&&isK) {
                             
                            int temp = arr[nx][ny];
                            arr[nx][ny] = arr[x][y]-1; //1차이 나는게 최적이니깐
                            back(nx,ny,false,depth+1);
                            arr[nx][ny] = temp;
                        }
                    }
                }
            } //
            
             
        }
        visit[x][y]=0;
         
    }
     
     
     
}
