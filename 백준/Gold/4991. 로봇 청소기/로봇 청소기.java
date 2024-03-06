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
	static int W, H;
	static char[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int sum = 0;
	static int dirtyCount =0;
	static List<int[]> dirty;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		while(W != 0 || H != 0) {
			arr = new char[H][W];
			sum = Integer.MAX_VALUE;
			dirtyCount = 0;

			dirty = new ArrayList<>();
			for(int i = 0; i < H; i++) {
				String input = br.readLine();
				for(int j = 0; j < W; j++) {
					arr[i][j] = input.charAt(j);
					if(arr[i][j] == 'o') {
						dirty.add(0, new int[] {j,i});
						arr[i][j] = 0;
					}
					if(arr[i][j] == '*') {
						dirtyCount++;
						dirty.add(new int[] {j,i});
						arr[i][j] = (char)dirtyCount;
					}
				}
			}
			dirtyCount++;
			dist = new int[dirty.size()][dirty.size()];
			for(int i = 0 ; i < dirty.size(); i++) {
				Arrays.fill(dist[i], -1);
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < dirty.size(); i++) {
				setDirtyLength(dirty.get(i)[0], dirty.get(i)[1]);
			}
			

			
			for(int i = 0; i < dirty.size(); i++) {
				for(int j = i+1 ; j < dirty.size(); j++) {
					if(dist[i][j] == -1) {
						sum = -1;
						break;
					}
				}
			}
			if(sum != -1) {
				backtracking(1,0,0,1);
			}
			
			sb.append(sum);
			sb.append('\n');
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);

	}
	
	static void backtracking(int depth, int sum, int before, int visited) {		
		if(depth == dirtyCount) { 
			Main.sum = Math.min(sum, Main.sum);
			return;
		}
		
		for(int i = 0; i < dirtyCount; i++) {
			if((visited & (1 << i)) != 0) {
				continue;
			}
			if(i == before) {
				continue;
			}
			visited += 1 << i;
			backtracking(depth+1, sum+dist[before][i], i, visited);
			visited -= 1 << i;
		}
		
	}
	
	static void setDirtyLength(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y,0});
		boolean[][] visited = new boolean[H][W];
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(arr[cur[1]][cur[0]] >= 0 && arr[cur[1]][cur[0]] <= 10) {
				dist[arr[y][x]][arr[cur[1]][cur[0]]] = cur[2];
				dist[arr[cur[1]][cur[0]]][arr[y][x]] = cur[2];
			}
			
			for(int i = 0; i < 4; i++) {
				int curX = cur[0] + dx[i];
				int curY = cur[1] + dy[i];
				
				if(!isBoundary(curX, curY)) {
					continue;
				}
				
				if(visited[curY][curX]) {
					continue;
				}
				
				if(arr[curY][curX] == 'x') {
					continue;
				}
				
				visited[curY][curX] = true;
				q.add(new int[] {curX, curY, cur[2]+1});
			}
		}
	}
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < W && 0 <= y && y < H;
	}
}
