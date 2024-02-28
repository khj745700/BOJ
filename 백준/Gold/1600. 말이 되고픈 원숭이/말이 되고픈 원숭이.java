import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[] horseDx = {-1, 1, 2, 2, 1, -1, -2, -2};
	static int[] horseDy = {2, 2, 1, -1, -2, -2, -1, 1};
	static int K, W, H;
	static int[][] arr;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][W];
		visited = new boolean[K+1][H][W];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W ;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}
	
	
	static int bfs() {
		PriorityQueue<Case> pq = new PriorityQueue<>();
		pq.add(new Case(0,0,K,0));

		while(!pq.isEmpty()) {
			Case cur = pq.poll();
			
			
			if(cur.x == W - 1 && cur.y == H - 1) {
				return cur.depth;
			}
			
			for(int i = 0; i< 4; i++) {
				int curX = cur.x + dx[i];
				int curY = cur.y + dy[i];
				
				if(!isBoundary(curX, curY)) {
					continue;
				}
				

				
				if(!visited[cur.k][curY][curX] && arr[curY][curX] == 0) {
					visited[cur.k][curY][curX] = true;
					pq.add(new Case(curX, curY, cur.k, cur.depth + 1));
				}
			}
			
			if(cur.k != 0) {
				for(int i = 0 ; i < 8; i++) {
					int curX = cur.x + horseDx[i];
					int curY = cur.y + horseDy[i];
					
					if(!isBoundary(curX, curY)) {
						continue;
					}

					
					if(!visited[cur.k-1][curY][curX] && arr[curY][curX] == 0) {
						visited[cur.k-1][curY][curX] = true;
						pq.add(new Case(curX, curY, cur.k - 1, cur.depth + 1));
					}
				}
			}
		}
		return -1;
	}
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < W && 0 <= y && y < H;
	}
	
	
	static class Case implements Comparable<Case> {
		int x;
		int y;
		int k;
		int depth;
		Case(int a, int b, int c, int d) {
			x = a; y = b; k = c; depth = d;
		}
		
		public int compareTo(Case e) {
			if(depth != e.depth) {
				return depth - e.depth;
			}
			return e.k - k;
		}
	}
}