import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] arr;
	static List<int[]> lazers;
	static int[] dx = {0,1,-1,0};
	static int[] dy = {-1,0,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new char[N][];
		
		lazers = new ArrayList<>(2);
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			arr[i] = input.toCharArray();
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 'C') {
					lazers.add(new int[] {j,i});
				}
			}
		}
		
		System.out.println(bfs());

	}
	
	static int bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] start = lazers.get(0);
		pq.add(new Node(start[0], start[1], 0, 0));
		pq.add(new Node(start[0], start[1], 0, 1));
		pq.add(new Node(start[0], start[1], 0, 2));
		pq.add(new Node(start[0], start[1], 0, 3));
		
		int[][][] visited = new int[4][N][M];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < N; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		visited[0][start[1]][start[0]] = 0;
		visited[1][start[1]][start[0]] = 0;
		visited[2][start[1]][start[0]] = 0;
		visited[3][start[1]][start[0]] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.y == lazers.get(1)[1] && cur.x == lazers.get(1)[0]) {
				return cur.count;
			}
			
			for(int i = 0; i < 4; i++) {
				int curX = cur.x + dx[i];
				int curY = cur.y + dy[i];
				
				if(!isBoundary(curX, curY)) {
					continue;
				}
				
				if(arr[curY][curX] == '*') {
					continue;
				}
				//맞은편은 안됨.
				if(cur.d + i == 3) {
					continue;
				}
			
				if(cur.d == i && visited[cur.d][curY][curX] > cur.count) {
					pq.add(new Node(curX, curY, cur.count, cur.d));
					visited[i][curY][curX] = cur.count;
					continue;
				}
				
				if(cur.d != i && visited[i][curY][curX] > cur.count+1) {
					pq.add(new Node(curX, curY, cur.count + 1, i));
					visited[i][curY][curX] = cur.count+1;
				}
			}
		}
		
		return -1;
	}
	
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int count;
		int d;
		
		Node(int x, int y, int c, int d) {
			this.x = x; this.y = y; count = c; this.d = d;
		}
		
		
		public int compareTo(Node e) {
			return count - e.count;
		}
	}
	
	
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < M  && 0 <= y && y < N;
	}
}
