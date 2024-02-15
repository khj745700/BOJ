import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
	static int N, M;
	static int[] val;
	static Integer[] dp;
	static List<Integer>[] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());		
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new Integer[N + 1];
			map = new ArrayList[N+1];
			val = new int[N+1];
			for(int i = 1; i <= N; i++) {
				map[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i<=N; i++ ) {
				val[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				map[end].add(start); //역순으로 저장. 그래야 탐색이 편함.
			}
			
			int target = Integer.parseInt(br.readLine());
			sb.append(dfs(target));
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	
	
	static int dfs(int v) {
		if(dp[v] != null) {
			return dp[v];
		}
		
		if(dp[v] == null) {
			dp[v] = val[v];
		}
		
		int max = 0;
		for(Integer child : map[v]) {
			max = Math.max(dfs(child), max);
		}

		return dp[v] = dp[v] + max;
	}
}
