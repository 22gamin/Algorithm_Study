package xweek10;


import java.util.*;
import java.io.*;

public class b_20920 {
    static int N,M;
    static Map<String,dic> wordCount;

    public static class dic implements Comparable<dic>{
        String name;
        int len;
        int count =1;

        public dic(String name) {
            this.name = name;
            this.len = name.length();
        }

        //단어 나온 횟수 추가
        public void setCount() {
            this.count++;
        }

        @Override
        public int compareTo(dic o) {
            int c = Integer.compare(o.count, this.count);
            if(c!= 0) return c;
            c = Integer.compare(o.len, this.len);
            if(c!= 0) return c;
            return c = this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //자주 나오는 단어
        //길이가 길면 앞
        //알파벳 순서

        wordCount = new HashMap<>();
        List<dic> list = new ArrayList<>();

        for(int i = 0; i<N; i++) {
            String word = br.readLine();

            if(word.length() < M) continue;

            if (!wordCount.containsKey(word)) {
                wordCount.put(word, new dic(word));
                list.add(wordCount.get(word));
            } else {
                dic temp = wordCount.get(word);
                temp.setCount();
            }

        }
        Collections.sort(list);

        for(dic d : list) {
            sb.append(d.name).append("\n");
        }
        System.out.println(sb);
    }

}

