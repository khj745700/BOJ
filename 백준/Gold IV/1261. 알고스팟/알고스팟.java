import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
	static int N, M;
	static int[][] arr;
	static List<int[]> list;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		System.out.println(bfs(0, 0));
	}

	
	static int bfs(int x, int y) {
		PriorityQueue<int[]> q = new PriorityQueue<>((i1, i2) -> (i1[2] - i2[2]));
		q.add(new int[] {x, y, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			if(visited[curY][curX]) {
				continue;
			}
			if(curX == M - 1 && curY == N - 1) {
				return cur[2];
			}
			visited[curY][curX] = true;
			for(int i = 0; i < 4; i++) {
				int cx = curX + dx[i];
				int cy = curY + dy[i];
				if(!isBoundary(cx, cy)) {
					continue;
				}
				
				if(arr[cy][cx] == 1 && !visited[cy][cx]) {
					q.add(new int[] {cx, cy, cur[2]+1});
				}
				
				if(arr[cy][cx] == 0 && !visited[cy][cx]) {
					q.add(new int[] {cx, cy, cur[2]});
				}
			}
		}
		
		return 0;
	}
	
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}

	
}
