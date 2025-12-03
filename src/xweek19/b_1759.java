package xweek19;

import java.util.*;
import java.io.*;

public class b_1759 {
    static int L, C;
    static List<Character> word = new ArrayList<>();
    static List<List<Character>> answer = new ArrayList<>();
    static boolean[] visited;

    static void find(List<Character> list,int depth){

        // 조건
        if(depth == L){
            int ga = 0;
            int mo = 0;

            for(char ch : list){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
                    mo++;
                } else ga++;
            }


            if ( ga>=2 && mo>=1){
                answer.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i = 0; i<word.size(); i++){
            if (!visited[i] && (list.isEmpty() || (word.get(i)> list.get(list.size()-1)))){
                visited[i] = true;
                List<Character> temp = list;
                temp.add(word.get(i));
                find(temp, depth+1);

                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int c = 0; c<C; c++){
            String str = st.nextToken();
            char ch = str.charAt(0);

            word.add(ch);
        } // 입력 끝

        visited = new boolean[word.size()];
        Collections.sort(word);

        //백트래킹
        find(new ArrayList<>(), 0);

        for(List<Character> chars : answer){
            for(char c : chars){
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
