import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        String v;
        HashMap<String,Node> isE = new HashMap<>();
        TreeSet <Node> children = new TreeSet<>();
        int level;

        public Node(String v, int level){
            this.v = v;
            this.level = level;
        }

        @Override
        public int compareTo(Node o) {
            return this.v.compareTo(o.v);
        }
    }



    public static void main(String[] args)throws IOException {
        //System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node("",0);

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Node start = root;
            for(int j = 0; j < k; j++){
               String s = st.nextToken();

               if(start.isE.containsKey(s)){
                   start = start.isE.get(s);
               }else{
                   Node x = new Node(s,j);
                   start.isE.put(s,x);
                   start.children.add(x);

                   start =x;
               }

            }
        }

        StringBuilder sb = new StringBuilder();

        for(Node node : root.children){
            find(node,sb);
        }

        System.out.print(sb);
    }

    public static void find(Node s,StringBuilder sb){
        int level = s.level;
        String v = s.v;

        for(int i = 0; i < level; i++){
            sb.append("--");
        }

        sb.append(v).append("\n");

        if(!s.children.isEmpty()){
            for(Node a : s.children){
                find(a,sb);
            }
        }
    }


}
