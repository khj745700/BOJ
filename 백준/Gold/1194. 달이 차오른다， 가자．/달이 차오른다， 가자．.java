import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int N,M;
	static int startX;
	static int startY;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0 ; i < N; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < M; j++) {
				map[i][j] = input.charAt(j);
				
				if(map[i][j] == '0') {
					startX = j;
					startY = i;
					map[i][j] = '.';
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Edge> q = new ArrayDeque<>();
		q.add(new Edge(startX, startY, 0, 1));
		boolean[][][] visited = new boolean[64][N][M];
		visited[0][startY][startX] = true;
		
		while(!q.isEmpty()) {
			Edge cur = q.poll();
			
			for(int i = 0 ; i < 4; i++) {
				int curX = cur.x + dx[i];
				int curY = cur.y + dy[i];
				
				if(isNotBoundary(curX, curY)) {
					continue;
				}
				
				if(visited[cur.key][curY][curX]) {
					continue;
				}
				
				if(map[curY][curX] == '#') {
					continue;
				}
				
				if(map[curY][curX] == '.') {
					q.add(new Edge(curX, curY, cur.key, cur.val + 1));
					visited[cur.key][curY][curX] = true;
				}
				
				if(map[curY][curX] == '1') {
					return cur.val;
				}
				
				if(Character.isLetter(map[curY][curX])) {
					if(Character.isLowerCase(map[curY][curX])) {
						int keyVisited = cur.key;
						if((cur.key & ( 1<< (map[curY][curX] - 'a'))) == 0) {
							keyVisited = cur.key | ( 1<< (map[curY][curX] - 'a'));
						}
						q.add(new Edge(curX, curY, keyVisited, cur.val + 1 ));
						visited[keyVisited][curY][curX] = true;
					}
					
					if(Character.isUpperCase(map[curY][curX])) {
						if((cur.key & ( 1<< (map[curY][curX] - 'a'))) != 0) {
							q.add(new Edge(curX, curY, cur.key, cur.val + 1 ));
							visited[cur.key][curY][curX] = true;
						}
					}
				}
			}
		}
		return -1;
	}
	
	static boolean isNotBoundary(int x, int y) {
		return -1 == x || x == M || y == -1 || y == N;
	}
	
	static class Edge {
		int x;
		int y;
		int key;
		int val;
		
		Edge(int a, int b, int c, int val) {
			x = a;
			y = b;
			key = c;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Edge [x=" + x + ", y=" + y + ", key=" + key + ", val=" + val + "]";
		}
		
		
	}
}