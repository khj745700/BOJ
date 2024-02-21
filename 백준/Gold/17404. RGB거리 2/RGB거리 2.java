import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][3];
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[3][N][3];

		//초록생을 칠한 경우
		for(int k = 0 ; k < 3; k++) {
			for(int j = 0 ; j < 3; j++) {
				if(j == k) {
					dp[k][0][j] = arr[0][j];
				}else {
					dp[k][0][j] = 10000000;
				}
			}
			for(int i = 1; i < N; i++) {
				dp[k][i][0] = Math.min(dp[k][i-1][1], dp[k][i-1][2]) + arr[i][0];
				dp[k][i][1] = Math.min(dp[k][i-1][0], dp[k][i-1][2]) + arr[i][1];
				dp[k][i][2] = Math.min(dp[k][i-1][1], dp[k][i-1][0]) + arr[i][2];
			}
			
			dp[k][N-1][k] = Integer.MAX_VALUE;
			
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			for(int j = 0 ; j < 3; j++) {
				min = Math.min(dp[i][N-1][j], min);
			}
		}
		
		System.out.println(min);
	}
}