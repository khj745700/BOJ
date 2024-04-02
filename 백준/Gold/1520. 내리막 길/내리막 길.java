import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static Integer[][] dp;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new Integer[N][M];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(M-1,N-1));
	}
	
	static int dfs(int x, int y) {
		if(y == 0 && x == 0) {
			return 1;
		}
		if(dp[y][x] != null) {
			return dp[y][x];
		}
		
		dp[y][x] = 0;
		for(int i = 0; i < 4; i++) {
			int curX = x + dx[i];
			int curY = y + dy[i];
			
			if(isNotBoundary(curX, curY)) {
				continue;
			}
			if(arr[curY][curX] > arr[y][x]) {
				dp[y][x] += dfs(curX, curY);
			}
				
		}
		
		return dp[y][x];
	}
	
	
	static boolean isNotBoundary(int x, int y) {
		return x == -1 || x == M || y == -1 || y == N;
	}
}