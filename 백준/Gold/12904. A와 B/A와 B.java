import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder end = new StringBuilder();
		
		String s = br.readLine();
		
		
		String e = br.readLine();
		for(int i = 0; i < e.length(); i++) {
			end.append(e.charAt(i));
		}

		for(int i = e.length()-1 ; i >= s.length(); i--) {
			if(end.charAt(i) == 'A') {
				end = end.replace(i, i+1, "");
			}else {
				end = end.replace(i, i+1, "");
				end = end.reverse();
			}
		}
		
		if(end.toString().equals(s)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
}
