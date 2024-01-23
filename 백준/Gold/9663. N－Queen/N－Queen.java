
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] cango;
	static boolean[][] isQ;
	static int N;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cango = new int[N][N];
		
		isQ = new boolean[N][N];
		backtracking(0, 0, 0);
		System.out.println(count);
	}
	
	
	
	static void backtracking(int x, int y, int qCount) {
		if(y == N) {
			if(qCount == N)
				count++;
			return;
		}
		
		for(int i = 0; i < N; i++) {

			if(cango[y][i] > 0) {
				continue;
			}
			isQ[y][i] = true;
			setCantGo(i,y,1);
			backtracking(0, y+1, qCount+1);
			setCantGo(i,y,-1);
			isQ[y][i] = false;
		}
	}
	
	
	static void setCantGo(int x, int y, int isGo) {
		for(int i = 0; i < N; i++) {
			cango[y][i] += isGo;
			cango[i][x] += isGo;
		}
		
		for(int i = 0; i < N; i++) {
			int curX = x + i;
			int curY = y + i;
			if(isBoundary(curX) && isBoundary(curY)) {
				cango[curY][curX] += isGo;
			}
			
			curX = x - i;
			curY = y - i;
			if(isBoundary(curX) && isBoundary(curY)) {
				cango[curY][curX] += isGo;
			}
			
			curX = x + i;
			curY = y - i;
			if(isBoundary(curX) && isBoundary(curY)) {
				cango[curY][curX] += isGo;
			}
			
			curX = x - i;
			curY = y + i;
			if(isBoundary(curX) && isBoundary(curY)) {
				cango[curY][curX] += isGo;
			}
			
		}
		cango[y][x] -= isGo * 5;
	}
	
	static boolean isBoundary(int x) {
		return 0 <= x && x < N;
	}
}