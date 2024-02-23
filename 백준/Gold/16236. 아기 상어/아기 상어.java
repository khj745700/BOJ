import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int curX;
	static int curY;
	static int size = 2;
	static int count = 0;
	static int fCount = 0;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if(arr[i][j] > 0) {
					fCount++;
				}
				
				if(arr[i][j] == 9) { 
					curX = j;
					curY = i;
					fCount -= 1;
					arr[i][j] = 0;
				}
			}
		}

		bfs();
		System.out.println(answer);
	}
	

	static void bfs() {
		//print();
		while(fCount != 0) {
			Fish find = findFish();
			if(find == null) {
				return;
			}
			answer += find.d;
			count++;
			fCount--;
			curY = find.y;
			curX = find.x;
			//print();
			//System.out.println(curY + " " +curX + " " + find.d + " " + find.size + " " + size);
			arr[curY][curX] = 0;
			if(size == count) {
				count=0;
				size+=1;
			}
		}
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	
	static Fish findFish() {
		Queue<int[]> q = new ArrayDeque<>();
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new int[] {curX, curY});
		visited[curY][curX] = true;
		
		int qSize = q.size();
		int depth = 1;
		while(qSize --> 0) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int x = cx + dx[i];
				int y = cy + dy[i];
				
				if(!(0 <= x && x < N && 0 <= y && y < N)) {
					continue;
				}
				
				if(visited[y][x]) {
					continue;
				}
				visited[y][x] = true;
				
				if(arr[y][x] <= size) {
					q.add(new int[] {x,y});
				}
				
				if(arr[y][x] > 0) {
					Fish find = new Fish(x,y,arr[y][x]);
					find.d = depth;
					pq.add(find);
				}
			}
			
			if(qSize == 0) {
				qSize = q.size();
				depth++;
			}
		}
		
		while(!pq.isEmpty()) {
			Fish cur = pq.poll();
			if(cur.size >= size) {
				continue;
			}
			return cur;
		}
		
		return null;
	}
	
	static int getTime(Fish f, int x, int y) {
		return Math.abs(x - f.x) + Math.abs(y - f.y); 
	}

	static class Fish implements Comparable<Fish> {
		int x;
		int y;
		int size;
		int d;
		Fish(int a, int b, int c) {
			x = a; y = b; size = c;
		}
		
		public int compareTo(Fish f) {
			if(d != f.d) {
				return d - f.d;
			}
			
			if(y != f.y) {
				return y - f.y;
			}
			return x - f.x;
		}
	}
	
	static void print() {
		for(int i = 0 ; i< N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == curY && j == curX) {
					System.out.print(" X ");
				}else {
					if(arr[i][j] == 0) {
						System.out.print(" . ");
					}else {
						System.out.print(" " +arr[i][j]+" ");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}