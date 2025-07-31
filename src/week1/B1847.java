package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class B1847 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		
		int cnt = 1;
		boolean chk=false;
		List<String> result = new ArrayList<>();
		while(n-->0) {
			int a = Integer.parseInt(br.readLine());
			while(cnt<=a) {
				st.push(cnt++);
				result.add("+");
			}
			if( st.peek() != a) {
				bw.write("NO\n");
				chk=true;
				break;
			}
			st.pop();
			result.add("-");
		}
		if (chk == false){
			for(String c : result) {
				bw.write(c+"\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
