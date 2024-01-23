import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int A;
	static int B;
	static int count = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		backtracking(A, 0);
		if(count != Integer.MAX_VALUE)
			System.out.println(count + 1);
		else {
			System.out.println(-1);
		}
	}

	static void backtracking(long val, int c) {
		if(val == B) {
			count = Math.min(count, c);
			return;
		}
		
		if(val > B) {
			return;
		}
		
		backtracking(val * 2, c + 1);
		backtracking(val * 10 + 1, c + 1);
	}
}