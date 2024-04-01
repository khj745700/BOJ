import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dp = new int[10001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		
		for(int i = 4; i < 10001; i++) {
			dp[i] = 1 + i / 2 + dp[i-3];
		}
		
		while(T --> 0) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
		}
		
		System.out.println(sb);
	}
}