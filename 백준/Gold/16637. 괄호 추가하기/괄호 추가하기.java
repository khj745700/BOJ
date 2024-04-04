import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int N;
	static List<Integer> list;
	static List<Character> opers;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		list = new LinkedList<>();
		opers = new LinkedList<>();
		String input = br.readLine();
		for (int i = 0; i < N; i++) {
			if(Character.isDigit(input.charAt(i))) {
				list.add(input.charAt(i) - '0');
			}else {
				opers.add(input.charAt(i));
			}
		}
		backtracking(0, new boolean[opers.size()]);
		System.out.println(max);
	}
	
	
	static void backtracking(int depth, boolean[] visited) {
		if(depth == opers.size()) {
			List<Integer> numCopy = new ArrayList<>(list);
			List<Character> operCopy = new ArrayList<>(opers);
			for(int i = operCopy.size() - 1; i >= 0; i-- ) {
				if(!visited[i]) {
					continue;
				}
				int l = numCopy.remove(i);
				int r = numCopy.remove(i);
				char op = operCopy.remove(i);
				
				int sum = cal(op, l, r);
				numCopy.add(i, sum);
			}
			
			for(int i = operCopy.size() - 1 ; i >= 0; i-- ) {
				int r = numCopy.remove(numCopy.size() - 1 - i);
				int l = numCopy.remove(numCopy.size() - 1 - i);
				char op = operCopy.remove(operCopy.size() - 1 - i);
				
				int sum = cal(op, l, r);
				numCopy.add(numCopy.size() - i, sum);
			}
			max = Math.max(numCopy.get(0), max);
			return;
		}
		
		if(depth > 0 && visited[depth-1] == true) {
			backtracking(depth+1, visited);
			return;
		}
		
		visited[depth] = true;
		backtracking(depth+1, visited);
		visited[depth] = false;
		backtracking(depth+1, visited);
	}

	static int cal(char o, int l, int r) {
		switch(o) {
		case '*':
			return l * r;
		case '+':
			return l + r;
		case '-':
			return l - r;
		}
		throw new IllegalArgumentException();
	}
}