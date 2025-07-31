package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class b_1874{
    public static void main(String[] args) throws IOException {
        //입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //배열 숫자 입력 받기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Stack<Integer> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        for (int i =1; i<n+1; i++) {

            stack.push(i);  //스택 넣기
            answer.add("+");

            //비교하기 + 밑에도 내가 필요한 원소일 수 있으니 무한으로
            for (; ; ) {
                if (!stack.isEmpty() && stack.peek().equals(list.get(0))) {
                    stack.pop();
                    list.remove(0);
                    answer.add("-");
                } else break;
            }

        }
        //출력
        if (list.isEmpty()){
            for (String str : answer){
                System.out.println(str);
            }
        }
        else
            System.out.println("NO");
    }
}
