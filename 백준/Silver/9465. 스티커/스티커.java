
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[][] arr;
	static int size;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			size = Integer.parseInt(br.readLine());
			dp = new int[2][size + 2];
			arr = new int[2][size];
			
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(size == 1) {
				bw.append(String.valueOf(Math.max(arr[0][0], arr[1][0])));
				bw.newLine();
				continue;
			}
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[0][1] = dp[1][0] + arr[0][1];
			dp[1][1] = dp[0][0] + arr[1][1];
			
			for(int i = 2 ; i < size; i++) {
				dp[0][i] = arr[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
				dp[1][i] = arr[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
			}
			
			bw.append(String.valueOf(Math.max(dp[0][size - 1], dp[1][size-1])));
			bw.newLine();
		}
		bw.flush();
	}
	
	
}