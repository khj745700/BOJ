import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N;
	static List<String> strs;
	static Node[] roots;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(T --> 0) {
			N = Integer.parseInt(br.readLine());
			strs = new ArrayList<>();
			for(int i = 0 ;i < N; i++) {
				strs.add(br.readLine());
			}
			
			Collections.sort(strs);
			boolean flag = true;
			roots = new Node[10];
			for(String str : strs) {
				Node[] cur = roots;
				
				char c;
				for(int i = 0; i < str.length(); i++) {
					c = str.charAt(i);
					if(cur[c-'0'] == null && i != str.length() - 1) {
						cur[c-'0'] = new Node(false);
					}else if(cur[c-'0'] == null && i == str.length() - 1) {
						cur[c-'0'] = new Node(true);
					}else if(cur[c-'0'] != null && cur[c-'0'].isWordEnd) {
						flag = false;
						break;
					}
					
					
					
					cur = cur[c-'0'].childs;
				}
				if(!flag) {
					break;
				}
			}
			
			if(flag) {
				sb.append("YES");
			}else {
				sb.append("NO");
			}
			sb.append('\n');
			
		}
		
		System.out.println(sb.toString());
	}
	
	static class Node {
		Node[] childs;
		boolean isWordEnd;
		
		Node(boolean isWordEnd) {
			this.isWordEnd = isWordEnd;
			childs = new Node[10];
		}
	}
}
