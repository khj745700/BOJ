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
	static int N;
	static int[][] map;
	static boolean[][] color;
	static int[] ans = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		color = new boolean[N][N];
		boolean white = true;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				color[i][j] = white;
				white = !white;
			}
			if(N % 2 == 0) {
				white = !white;
			}
		}
		backtracking(0,0, white);
		backtracking(0,0, !white);
		System.out.println(ans[0] + ans[1]);
	} 
	
	static void backtracking(int cnt, int depth, boolean white) {
		ans[white ? 0 : 1] = Math.max(cnt, ans[white ? 0 : 1]);

		for(int i = depth; i < N*N; i++) {
			int y = i/N;
			int x = i%N;
			if(color[y][x] != white) {
				continue;
			}
			if(map[y][x] == 0) {
				continue;
			}
			if(exist(x, y)) {
				continue;
			}
			map[y][x] = 2;
			backtracking(cnt+1, i+1, white);
			map[y][x] = 1;
		}

	}
	
	static boolean exist(int x, int y) {
		int curX = x;
		int curY = y;
		
		//좌상
		for(int i = 1 ; i < N; i++) {
			curX = x - i;
			curY = y - i;
			if(!isBoundary(curX, curY)) {
				break;
			}
			if(map[curY][curX] == 2) {
				return true;
			}
		}
		
		//우상
		for(int i = 1 ; i < N; i++) {
			curX = x + i;
			curY = y - i;
			if(!isBoundary(curX, curY)) {
				break;
			}
			if(map[curY][curX] == 2) {
				return true;
			}
		}
		
		return false;
 	}

	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
