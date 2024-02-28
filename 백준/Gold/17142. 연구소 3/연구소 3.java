import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int N, M;
	static int[][] arr;
	static List<int[]> virus;
	static Integer MIN = Integer.MAX_VALUE;
	static int total = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		virus = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 2) {
					virus.add(new int[] {j,i});
				}
				
				if(arr[i][j] == 0) {
					total++;
				}
				
			}
		}
		backtracking(0,0, new ArrayList<>());
		System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
	}
	
	
	static void backtracking(int cnt, int depth, List<int[]> target) {
		if(cnt == M) {
			//탐색
			MIN = Math.min(bfs(target), MIN);
			return;
		}
		
		for(int i = depth; i < virus.size(); i++) {
			target.add(virus.get(i));
			backtracking(cnt + 1, i + 1, target);
			target.remove(target.size() - 1);
		}
	}
	
	
	static int bfs(List<int[]> target) {
		Queue<int[]> q = new ArrayDeque<>(target);
		boolean[][] visited = new boolean[N][N];
		for(int[] cur : target) {
			visited[cur[1]][cur[0]] = true;
		}

		int count = 0;
		int virusCount = 0;
		if(isFull(visited)) {
			return count;
		}

		Queue<int[]> nextQ = new ArrayDeque<>();
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for(int i = 0; i < 4; i++) {
				int curX = x + dx[i];
				int curY = y + dy[i];
				
				if(!isBoundary(curX, curY)) {
					continue;
				}
				
				if(!visited[curY][curX] && (arr[curY][curX] != 1)) {
					visited[curY][curX] = true;
					nextQ.add(new int[] {curX, curY});
				}
				
			}
			
			if(q.isEmpty()) {
				
				if(isFull(visited)) {
					return count + 1;
				}
				
				if(!nextQ.isEmpty()) {
					count++;
					Queue temp = q;
					q = nextQ;
					nextQ = temp;
				}


			}
		}

		return Integer.MAX_VALUE;
	}
	
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	static boolean isFull(boolean[][] visited) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] &&arr[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
}