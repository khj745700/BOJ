import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int[][] arr;
	static List<int[]> chickens;
	static List<int[]> house;
	static int MIN = Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		chickens = new ArrayList<>();
		house = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					chickens.add(new int[] {j, i});
					arr[i][j] = 0;
				}
				if(arr[i][j] == 1) {
					house.add(new int[] {j, i});
				}
			}
		}
		
		visited = new boolean[chickens.size()];
		backtracking(0, 0);
		System.out.println(MIN);
	}
	
	
	static void backtracking(int depth, int cnt) {
		if(cnt == M) {
			int val = 0;
			for(int[] home : house) {
				val += bfs(home[0], home[1]);
			}
			MIN = Math.min(val, MIN);
			return;
		}
		
		for(int i = depth; i < chickens.size(); i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			backtracking(i+1, cnt+1);
			visited[i] = false;
		}
	}
	
	
	static int bfs(int x, int y) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < chickens.size(); i++) {
			if(!visited[i]) {
				continue;
			}
			int[] cur = chickens.get(i);
			int val = Math.abs(x - cur[0]) + Math.abs(y - cur[1]);
			min = Math.min(val, min);
		}
		
		return min;
	}

}