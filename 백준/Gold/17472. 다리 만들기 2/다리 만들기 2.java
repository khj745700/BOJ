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

public class Main{
	static int N, M;
	static int[] set;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static List<List<int[]>> island;
	static int[][] distance;
	static PriorityQueue<Node> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		island = new ArrayList<>();
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isLandCount();
		set = new int[island.size()+1];
		for(int i = 1; i <= island.size(); i++) {
			set[i] = i;
		}
		
		distance = new int[island.size() + 1][island.size() + 1];
		for(int i = 0; i < distance.length; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		//먼저 맵에서 섬들을 찾는다.
		//섬 넘버링 작업.
		//섬에서 4방 탐색으로 섬들을 찾는다.
		//섬 끼리의 간선의 길이를 크루스칼로 푼다.
		//그리고 합을 구한당..!
		
		setDistance();
		pq = new PriorityQueue<>();
		for(int i = 1;i < island.size()+1; i++) {
			for(int j = 0; j < island.size()+1; j++) {
				if(distance[i][j] == Integer.MAX_VALUE) {
					continue;
				}
				pq.add(new Node(i,j,distance[i][j]-1));
			}
		}
		
		int count = 0;
		int sum = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(union(cur.u, cur.v)) {
				sum+= cur.d;
				count++;
			}
			
			if(count == island.size() - 1) {
				break;
			}
		}

		if(count != island.size() - 1){
			System.out.println(-1);
		}else {
			System.out.println(sum);
		}
	}
	
	static int unionFind(int v) {
		if(set[v] == v) {
			return v;
		}
		
		return set[v] = unionFind(set[v]);
	}
	
	static boolean union(int a, int b) {
		a = unionFind(a);
		b = unionFind(b);
		
		if(a == b) {
			return false;
		}
		
		set[a] = b;
		return true;
	}
	
	static void setDistance() {
		for(List<int[]> land : island) {
			for(int[] cur : land) {
				int x = cur[0];
				int y = cur[1];
				int count = 0;
				for(int i = 0; i < N; i++) {
					int curY = y+i;
					if(curY == N) {
						break;
					}
					if(map[y][x] == map[curY][x]) {
						count = 0;
					}
					if(map[y][x] != map[curY][x]) {
						count++;
						if(map[curY][x] != 0 ) {
							if( count > 2 && count < distance[map[y][x]][map[curY][x]]) {
								distance[map[y][x]][map[curY][x]] = count;
								distance[map[curY][x]][map[y][x]] = count;
							}
							break;
						}
					}
				}
				
				count = 0;
				for(int i = 0; i < N; i++) {
					int curY = y-i;
					if(curY == -1) {
						break;
					}
					if(map[y][x] == map[curY][x]) {
						count = 0;
					}
					if(map[y][x] != map[curY][x]) {
						count++;
						if(map[curY][x] != 0) {
							if( count > 2 && count < distance[map[y][x]][map[curY][x]]) {
								distance[map[y][x]][map[curY][x]] = count;
								distance[map[curY][x]][map[y][x]] = count;
							}
							break;
						}
					}
				}
				count = 0;
				for(int i = 0; i < M; i++) {
					int curX = x-i;
					if(curX == -1) {
						break;
					}
					if(map[y][x] == map[y][curX]) {
						count = 0;
					}
					if(map[y][x] != map[y][curX]) {
						count++;
						if(map[y][curX] != 0) {
							if(count > 2 && count < distance[map[y][x]][map[y][curX]]) {
								distance[map[y][x]][map[y][curX]] = count;
								distance[map[y][curX]][map[y][x]] = count;
							}
							break;
						}
					}
				}
				count = 0;
				for(int i = 0; i < M; i++) {
					int curX = x+i;
					if(curX == M) {
						break;
					}
					if(map[y][x] == map[y][curX]) {
						count = 0;
					}
					if(map[y][x] != map[y][curX]) {
						count++;
						if(map[y][curX] != 0 ) {
							if(count > 2 && count < distance[map[y][x]][map[y][curX]]) {
								distance[map[y][x]][map[y][curX]] = count;
								distance[map[y][curX]][map[y][x]] = count;
							}
							break;
						}
					}
				}
			}
		}
	}
	
	static void isLandCount() {
		boolean[][] visited = new boolean[N][M];
		int count = 1;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					islandNumbering(visited, j, i, count);
					count++;
				}
			}
		}
	}
	
	static void islandNumbering(boolean[][] visited, int startX, int startY, int val) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {startX, startY});
		
		island.add(new ArrayList<>());
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			if(visited[y][x]) {
				continue;
			}
			
			island.get(val-1).add(new int[] {x,y});
			visited[y][x] = true;
			
			for(int i = 0; i < 4; i++) {
				int curX = x+dx[i];
				int curY = y+dy[i];
				if(!isBoundary(curX, curY)) {
					continue;
				}
				
				if(!visited[curY][curX] && map[curY][curX] != 0) {
					q.add(new int[] {curX, curY});
				}
			}
		}
		for(int[] cur : island.get(val - 1)) {
			int x = cur[0];
			int y = cur[1];
			map[y][x] = val;
		}
	}
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}
	
	static class Node implements Comparable<Node> {
		int u;
		int v;
		int d;
		
		Node(int a, int b, int  c) {
			u = a; v = b; d = c;
		}
		
		public int compareTo(Node e) {
			return d - e.d;
		}
	}
}