import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] dx = { 0, 0, -1, 1};
	static int[] dy = {1,-1,0,0};
	static int maxNum = 0;
	static int maxCount = 0;
	static Queue<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			q.add(new int[] {0, i});
			q.add(new int[] {M-1, i});
		}
		
		for(int i = 0; i < M; i++) {
			q.add(new int[] {i, 0});
			q.add(new int[] {i, N-1});
		}
		
		cheezeLeveling();
		System.out.println(maxNum);
		System.out.println(maxCount);
	}
	
	
	static void cheezeLeveling() {
		Queue<int[]> jobQ = new ArrayDeque<>();
		Queue<int[]> nextQ = new ArrayDeque<>();
		int count = 1;
		boolean[][] visited = new boolean[N][M];
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			if(arr[y][x] == 1) {
				jobQ.add(cur);
			}
			for(int i = 0; i < 4; i++) {
				int curX = x + dx[i];
				int curY = y + dy[i];
				
				if(!isBoundary(curX, curY)) {
					continue;
				}
				
				if(!visited[curY][curX] && arr[curY][curX] == 0) {
					visited[curY][curX] = true;
					q.add(new int[] {curX, curY});
				}
				
				if(!visited[curY][curX] && arr[curY][curX] == 1) {
					visited[curY][curX] = true;
					nextQ.add(new int[] {curX, curY});
				}
				
			}
			
			if(q.isEmpty()) {
				Queue temp = q;
				q = nextQ;
				nextQ = temp;
				
				if(!jobQ.isEmpty()) {
					maxCount = jobQ.size();
					while(!jobQ.isEmpty()) {
						int[] cursor = jobQ.poll();
						int cx = cursor[0];
						int cy = cursor[1];
						arr[cy][cx] = count;
					}
					
					maxNum = count;
					count++;
				}
			}
			

		}
	}
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}
}