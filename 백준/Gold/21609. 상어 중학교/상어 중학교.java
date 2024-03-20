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
	static int N, M;
	static int[][] arr;
	static List<Block> blocks;
	static int blackCount;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					blackCount++;
				}
			}
		}
		int ans = 0;
		while(true) {
			blocks = new ArrayList<>();
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(!visited[i][j] && arr[i][j] > 0) {
						bfs(j,i);
					}
				}
			}
			
			if(blocks.size() == 0) {
				break;
			}
			blocks.sort(null);
			int val = remove(blocks.get(0));
			ans += val * val;
			gravity();
			rotate();
			gravity();

		}
		System.out.println(ans);
	}
	
	//먼저 1칸마다 방문하면서 colors 채우기
	
	static void print() {
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
	
	static void bfs(int x, int y) {
		Block b = new Block();
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> rainbowJobQ = new ArrayList<>();
		
		q.add(new int[] {x,y});
		b.list.add(q.peek());
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0 ; i < 4; i++) {
				int curX = cur[0] + dx[i];
				int curY = cur[1] + dy[i];
				
				if(isNotBoundary(curX, curY)) {
					continue;
				}
				
				if(visited[curY][curX]) {
					continue;
				}
				
				if(arr[curY][curX] == arr[y][x]) {
					int[] target = new int[] {curX, curY};
					visited[curY][curX] = true;
					q.add(target);
					b.list.add(target);
				}
				
				if(arr[curY][curX] == 0) {
					int[] target = new int[] {curX, curY};
					visited[curY][curX] = true;
					q.add(target);
					b.list.add(target);
					b.rainbow++;
					rainbowJobQ.add(target);
				}
			}
		}
		if(b.list.size() != 1) {
			blocks.add(b);
		}
		rainbowNotVisited(rainbowJobQ);
	}
	
	static void rainbowNotVisited(List<int[]> list) {
		for(int[] cur : list) {
			visited[cur[1]][cur[0]] = false;
		}
	}
	

	static int remove(Block block) {
		for(int[] cur : block.list) {
			arr[cur[1]][cur[0]] = -2;
		}
		return block.list.size();
	}
	
	static void rotate() {
		for(int i = 0; i < N; i++) {
			for(int j = i+1 ; j < N; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		
		for(int i = 0 ; i < N / 2; i++) {
			int[] temp = arr[i];
			arr[i] = arr[N-1-i];
			arr[N-1-i] = temp;
		}
	}
	
	static void gravity() {
		for(int i = 0; i < N; i++) {
			for(int j = N-1 ; j >= 0; j--) {
				int cur = arr[j][i];
				if(cur != -2) {
					continue;
				}
				for(int k = j - 1; k >= 0; k--) {
					int target = arr[k][i];
					if(target == -1) {
						j = k;
						break;
					}
					if(target == -2) {
						continue;
					}
					arr[j][i] = target;
					arr[k][i] = cur;
					break;
				}
			}
		}
	}
	
	static boolean isNotBoundary(int x, int y) {
		return x < 0 || N == x || y < 0 || N == y;
	}
	
	static class Block implements Comparable<Block>{
		List<int[]> list;
		int rainbow;
		
		Block() {
			list = new ArrayList<>();
			rainbow=0;
		}

		@Override
		public int compareTo(Main.Block o) {
			if(list.size() != o.list.size()) {
				return -list.size() + o.list.size();
			}
			
			if(rainbow != o.rainbow) {
				return -rainbow + o.rainbow;
			}
			
			int[] cur1 = list.get(0);
			int[] cur2 = o.list.get(0);
			
			if(cur1[1] != cur2[1]) {
				return -cur1[1] + cur2[1];
			}
			
			return -cur1[0] + cur2[0];
		}
	}
}
