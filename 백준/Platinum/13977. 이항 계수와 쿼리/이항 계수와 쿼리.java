import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int divide = 1000000007;
	static long[] factorial = new long[4000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		getFactorial(4000000);
		factorial[0] = 1;
		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			long left = getFactorial(N);
			long right = getFactorial(M);
			long right2 = getFactorial(N-M);
			long rightVal = (right * right2) % divide;
			sb.append(left * pow(rightVal, divide - 2) % divide).append('\n');
		}
		System.out.println(sb);
	}

	static long getFactorial(int n) {
		long val = 1;
		if(factorial[n] != 0) {
			return factorial[n];
		}
		for (int i = 1; i <= n; i++) {
			val = (val * i) % divide;
			factorial[i] = (int)val;
		}
		return factorial[n];
	}

	public static long pow(long base, long expo) {
		if (expo == 1) {
			return base % divide;
		}
		long temp = pow(base, expo / 2);
			
		if (expo % 2 == 1) {
			return (temp * temp % divide) * base % divide;
		}
		return temp * temp % divide;
	}
}