import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
	static int N, M;
	static int[][] arr;
	static int[][] ans;
	static int[][] room;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		arr = new int[N][M];
		ans = new int[N][M];
		room = new int[N][M];
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < M; j++) {
				arr[i][j] = input.charAt(j) -'0';
				ans[i][j] = arr[i][j];
				if(arr[i][j] == 1) {
					arr[i][j] = -1;
				}
			}
		}
		
		int count = 0;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < M; j++ ) {
				if(!visited[i][j] && arr[i][j] == 0) {
					bfs(j,i, ++count);
				}
			}
		}
		
		
		List<Integer> marks = new ArrayList<>(4);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] != -1) {
					continue;
				}
				for(int d = 0; d < 4; d++) {
					int curX = j + dx[d];
					int curY = i + dy[d];
					if(!isBoundary(curX, curY)) {
						continue;
					}
					
					if(arr[curY][curX] == -1) {
						continue;
					}
					if(marks.contains(room[curY][curX])) {
						continue;
					}
					marks.add(room[curY][curX]);
					ans[i][j] += arr[curY][curX];
				}
				marks.clear();
				ans[i][j] %= 10;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] != -1) {
					sb.append(0);
				}else {
					sb.append(ans[i][j]);
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	
	static void bfs(int x, int y, int mark) {
		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> jobQ = new ArrayDeque<>();
		
		q.add(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			if(visited[curY][curX]) {
				continue;
			}
			visited[curY][curX] = true;
			jobQ.add(cur);
			for(int i = 0; i < 4; i++) {
				int cx = curX + dx[i];
				int cy = curY + dy[i];
				
				if(!isBoundary(cx, cy)) {
					continue;
				}
				
				if(!visited[cy][cx] && arr[cy][cx] == 0) {
					q.add(new int[] {cx, cy});
				}
				
			}
		}
		
		int val = jobQ.size() % 10;
		while(!jobQ.isEmpty()) {
			int[] cur = jobQ.poll();
			arr[cur[1]][cur[0]] = val;
			room[cur[1]][cur[0]] = mark;
		}
	}
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}
}
