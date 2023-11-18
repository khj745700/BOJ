import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int row;
	static int[][] dp;
	static int[][] data;
	static Integer stoi(String str) {return Integer.parseInt(str);}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		row = stoi(br.readLine());
		StringTokenizer st;
		data = new int[row][];
		dp = new int[row][3];
		for(int i = 0 ; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			data[i] = new int[] {
					stoi(st.nextToken()), 
					stoi(st.nextToken()),
					stoi(st.nextToken())
					};
		}
		dp[0][0] = data[0][0];
		dp[0][1] = data[0][1];
		dp[0][2] = data[0][2];
		for(int i = 1; i < row; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + data[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + data[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + data[i][2];
		}
		
		int answer = Math.min(dp[row-1][0], Math.min(dp[row-1][1],dp[row-1][2]));
		System.out.print(answer);
	}
}
