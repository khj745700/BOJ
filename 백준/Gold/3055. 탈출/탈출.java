import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] arr;
	static int endX;
	static int endY;
	static int startX;
	static int startY;
	static Queue<int[]> waterQ;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		waterQ = new ArrayDeque<>();
		arr = new char[R][C];
		for(int i = 0 ; i < R; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				arr[i][j] = input.charAt(j);
				if(arr[i][j] == 'D') {
					endX = j;
					endY = i;
				}
				
				if(arr[i][j] == 'S') {
					startX = j;
					startY = i;
				}
				if(arr[i][j] == '*') {
					waterQ.add(new int[] {j,i});
				}
				
			}
		}
		int val = simulation();
		System.out.println(val == -1 ? "KAKTUS" : val);
	}
	
	
	
	static int simulation() {
		Queue<int[]> gosumdochi = new ArrayDeque<>();
		gosumdochi.add(new int[] {startX, startY});
		boolean[][] visited = new boolean[R][C];
		visited[startY][startX] = true;
		
		for(int[] water : waterQ) {
			visited[water[1]][water[0]] = true;
		}
		
		fillWater(visited);
		int goSize = gosumdochi.size();
		int count = 1;
		while(goSize --> 0) {
			int[] cur = gosumdochi.poll();
			
			for(int i =0 ;i < 4; i++) {
				int curX = cur[0] + dx[i];
				int curY = cur[1] + dy[i];
				
				if(isNotBoundary(curX, curY)) {
					continue;
				}
				
				if(visited[curY][curX]) {
					continue;
				}
				
				if(curX == endX && curY == endY) {
					return count;
				}
				
				if(arr[curY][curX] =='X') {
					continue;
				}
				
				gosumdochi.add(new int[] {curX, curY});
				visited[curY][curX] = true;
			}
			
			if(goSize == 0 && gosumdochi.size() != 0) {
				fillWater(visited);
				goSize = gosumdochi.size();
				count++;
			}
		}
		
		return -1;
	}
	
	static void fillWater(boolean[][] visited) {
		int size = waterQ.size();
		
		while(size --> 0) {
			int[] cur = waterQ.poll();
			
			for(int i = 0 ; i <4; i++) {
				int curX = cur[0] + dx[i];
				int curY = cur[1] + dy[i];
				
				if(isNotBoundary(curX, curY)) {
					continue;
				}
				
				if(visited[curY][curX]) {
					continue;
				}
				
				if(curY == endY && curX == endX) {
					continue;
				}
				
				if(arr[curY][curX] =='X') {
					continue;
				}
				
				
				waterQ.add(new int[] {curX, curY});
				visited[curY][curX] = true;
			}
		}
	}
	
	
	static boolean isNotBoundary(int x, int y) {
		return x == -1 || x == C || y == -1 || y == R;
	}
}