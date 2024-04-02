import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < N; j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		
		int red_green_count = 0;
		int blue_count = 0;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(visited[i][j]) {
					continue;
				}
				if(arr[i][j] == 'R' || arr[i][j] == 'G') {
					red_greenDFS(j,i);
					red_green_count++;
				}else {
					blueDFS(j,i);
					blue_count++;
				}
				
			}
		}
		
		visited = new boolean[N][N];
		
		int red_count = 0;
		int green_count = 0;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(visited[i][j]) {
					continue;
				}
				if(arr[i][j] == 'R') {
					redDFS(j,i);
					red_count++;
				}

				if(arr[i][j] == 'G') {
					greenDFS(j,i);
					green_count++;
				}
			}
		}
		
		int red_loss = red_green_count + blue_count;
		int ordinary = red_count + blue_count + green_count;
		System.out.println(ordinary + " " + red_loss);
	}
	
	static void print() {
		for(int i = 0 ; i < N; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		System.out.println();
	}
	
	static void red_greenDFS(int x, int y) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int curX = x + dx[i];
			int curY = y + dy[i];
			
			if(isNotBoundary(curX, curY)) {
				continue;
			}
			
			if(visited[curY][curX]) {
				continue;
			}
			
			if(arr[curY][curX] == 'R' || arr[curY][curX] == 'G') {
				red_greenDFS(curX, curY);
			}
		}
		
		return;
	}
	
	static void redDFS(int x, int y) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int curX = x + dx[i];
			int curY = y + dy[i];
			
			if(isNotBoundary(curX, curY)) {
				continue;
			}
			
			if(visited[curY][curX]) {
				continue;
			}
			
			if(arr[curY][curX] == 'R') {
				redDFS(curX, curY);
			}
		}
		
		return;
	}
	
	static void greenDFS(int x, int y) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int curX = x + dx[i];
			int curY = y + dy[i];
			
			if(isNotBoundary(curX, curY)) {
				continue;
			}
			
			if(visited[curY][curX]) {
				continue;
			}
			
			if(arr[curY][curX] == 'G') {
				greenDFS(curX, curY);
			}
		}
		
		return;
	}
	
	
	static void blueDFS(int x, int y) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int curX = x + dx[i];
			int curY = y + dy[i];
			
			if(isNotBoundary(curX, curY)) {
				continue;
			}
			
			if(visited[curY][curX]) {
				continue;
			}
			
			if(arr[curY][curX] == 'B') {
				blueDFS(curX, curY);
			}
		}
		
		return;
	}
	
	static boolean isNotBoundary(int x, int y) {
		return x == -1 || x == N || y == -1 || y == N;
	}
}