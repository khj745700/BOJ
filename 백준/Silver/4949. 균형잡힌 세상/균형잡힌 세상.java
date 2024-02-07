import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
 
public class Main {
	static int N;
	static ArrayDeque<Character> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		while(!".".equals(input)) {
			stack = new ArrayDeque<>();
			boolean flag = true;
			for(int i = 0 ; i < input.length(); i++) {
				char cur = input.charAt(i);
				switch(cur) {
				case '(', '[' :
					stack.addLast(cur);
					break;
				case ')' :
					if(stack.isEmpty() || stack.peekLast() != '(') {
						flag = false;
					}
					stack.pollLast();
					break;
					
				case ']' :
					if(stack.isEmpty() || stack.peekLast() != '[') {
						flag = false;
					}
					stack.pollLast();
					break;
				}
				if(!flag) {
					break;
				}
			}
			
			if(!stack.isEmpty()) {
				flag = false;
			}
			
			sb.append(flag ? "yes" : "no");
			sb.append('\n');
			input = br.readLine();
		}
		System.out.println(sb);
	}
}
