import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int divide = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long left = getVal(N, N - M + 1);
		long right = getVal(M, 1);

		sb.append(left * pow(right, divide - 2) % divide).append('\n');
		System.out.println(sb);
	}

	static long getVal(int n, int c) {
		long val = 1;
		for (int i = c; i <= n; i++) {
			val = (val * i) % divide;
		}

		return val;
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