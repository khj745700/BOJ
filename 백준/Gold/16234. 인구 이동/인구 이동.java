import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,L,R;
	static int[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(simulation());
	}
	
	static boolean[][] visited;
	static int simulation() {
		
		int count = 0;
		while(true) {
			visited = new boolean[N][N];
			boolean flag = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						flag |= bfs(j,i);
					}
				}
			}
			if(!flag) {
				break;
			}
			count++;
		}
		return count;
	}
	
	static boolean bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> jobQ = new ArrayList<>();
		q.add(new int[] {x,y});
		visited[y][x] = true;
		
		int sum = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			jobQ.add(cur);
			sum += arr[cur[1]][cur[0]];
			for(int i = 0 ; i < 4; i++) {
				int curX = cur[0] + dx[i];
				int curY = cur[1] + dy[i];
				
				if(!isBoundary(curX, curY)) {
					continue;
				}
				
				if(visited[curY][curX]) {
					continue;
				}
				
				int gap = Math.abs(arr[cur[1]][cur[0]] - arr[curY][curX]);
				
				if(!visited[curY][curX] && L <= gap && gap <= R) {
					visited[curY][curX] = true;
					q.add(new int[] {curX, curY});
				}
			}
		}
		int avg = sum / jobQ.size();
		
		if(jobQ.size() == 1) {
			return false;
		}
		
		for(int[] cur : jobQ) {
			arr[cur[1]][cur[0]] = avg;
		}
		
		return true;
	}
	
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
