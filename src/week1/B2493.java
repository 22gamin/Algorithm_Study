package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Stack;

//1 2 3 4 5
public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<Integer>();
        int[] top = new int[n];
        int[] total = new int [n];

        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            top[i] = Integer.parseInt(str[i]);
            // 들어올때마다 관리

            // 비어있지않고, 스택에 들어가있는 탑 인덱스의 높이 보다 클경우
            while(!st.isEmpty() && top[i]>top[st.peek()]){
                // 수신x
                st.pop();
            }
            if(!st.isEmpty()){
                // 인덱스 0부터니까 +1
                total[i] = st.peek()+1;
            }else{
                total[i] = 0;
            }
            st.push(i);
        }
        for(int s : total){
            System.out.print(s+" ");
        }
    }
}