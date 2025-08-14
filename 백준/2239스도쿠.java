import java.io.*;

public class Main {

    static int[][] arr;
    static boolean isSolved;
    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String a = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(a.charAt(j)));
            }
        }
        isSolved= false;
        back(0,0);


      

    }

    public static void back(int x, int y){
        if(isSolved){
            return;
        }
        if(y ==9){ // 열이 초과햇으니 행을 한칸이동
            back(x+1,0);
            return;
        }
        if(x ==9){ // 행이 초과했으니 다 끝남 이제 출력
            isSolved = true;
            for(int i = 0 ; i < 9; i++){
                for(int j: arr[i]){
                    System.out.print(j);
                }
                System.out.println();
            }
            return;
            
        }
        
        if(arr[x][y]!=0){
            back(x,y+1);
        }else{
            //1부터 9까지 넘버를 도는데
            //열 행 9칸박스 에 넘버가 있는지 체크
            //체크 햇는데 없으면 
            //그 넘버를 대입하고 다음으로 넘어감
            for(int i =1; i<=9; i++){
                if(isV(x,y,i)){
                    arr[x][y] = i;
                    back(x,y+1);
                   
                }
                 arr[x][y]=0; 
            }            
        }





    }

    public static boolean isV(int x, int y, int num){
        for(int i =0; i<9; i++){
            if(arr[x][i] ==num || arr[i][y]  == num){
                return false;
            }
        }

        x = (x/3) * 3;
        y = (y/3) * 3;

        for(int i =x; i<x+3; i++){
            for(int j = y ; j<y+3; j++){
                if(arr[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
