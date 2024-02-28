import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[] dx = { 0, 0, -1, 1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int test_case = 1;
		while(N != 0) {
			arr = new int[N][N];
			
			
			for(int i = 0 ; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("Problem ");
			sb.append(test_case++);
			sb.append(':');
			sb.append(' ');
			sb.append(BFS());
			sb.append('\n');
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
	}
	
	static int BFS() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0, arr[0][0]));
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.y == N-1 && cur.x == N-1) {
				return cur.d;
			}
			
			for(int i = 0; i < 4; i++) {
				int curX = cur.x + dx[i];
				int curY = cur.y + dy[i];
				if(!isBoundary(curX, curY)) {
					continue;
				}
				
				if(!visited[curY][curX]) {
					q.add(new Node(curX, curY, arr[curY][curX] + cur.d));
					visited[curY][curX] = true;
				}
			}
		}
		
		return -1;
	}
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int d;
		
		Node(int a, int b, int c) {
			x = a; y = b; d = c;
		}
		
		public int compareTo(Node e) {
			return d - e.d;
		}
	}
}