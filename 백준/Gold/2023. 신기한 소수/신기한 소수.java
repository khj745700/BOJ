import java.io.IOException;
import java.util.Scanner;	

public class Main {
	static int[] primeBase = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int N;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		N = new Scanner(System.in).nextInt();
		ans = new int[N];

		backtracking(1, 0);
		System.out.println(sb.toString());
		
	}
	
	static void backtracking(int start, int depth) {
		if(0 < depth && depth <= N) {
			int sum = 0;
			for(int i = 0; i < depth; i++) {
				sum += ans[i];
				if(!isPrime(sum)) {
					return;
				}
				sum *= 10;
			}
			if(depth == N) {
				sb.append(sum/10).append('\n');
				return;		
			}
		}
		
		for(int i = start; i < primeBase.length ; i++) {
			ans[depth] = primeBase[i];
			backtracking(0, depth+1);
		}
	}
	
	
	static boolean isPrime(int val) {
		if(val == 1) {
			return false;
		}
		
		if(val == 2) {
			return true;
		}
		for(int i = 2; i <= (int) Math.ceil(Math.sqrt(val)); i++) {
			if(val % i == 0) {
				return false;
			}
		}
		return true;
	}
}