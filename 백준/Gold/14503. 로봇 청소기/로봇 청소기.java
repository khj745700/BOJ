import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int d;
	static int curX;
	static int curY;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[] reverseDx = {0,1,0,-1}; //남서북동
	static int[] reverseDy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		curY = Integer.parseInt(st.nextToken());
		curX = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		switch(d) {
		case 0:
			d = 2;
			break;
		case 1:
			d = 1;
			break;
		case 2:
			d = 0;
			break;
		case 3:
			d = 3;
			break;
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(simulation());
	}
	
	
	static int simulation() {
		
		int count = 0;
		while(true) {

			if(map[curY][curX] == 0) {
				map[curY][curX] = -1;
				count++;
			}
			
			boolean flag = false;
			for(int i = 1; i <= 4; i++) {
				int dir = (d + i) % 4;
				int cx = curX + reverseDx[dir];
				int cy = curY + reverseDy[dir];
				if(map[cy][cx] == 1 || map[cy][cx] == -1) {
					continue;
				}
				
				if(map[cy][cx] == 0) {
					curY = cy;
					curX = cx;
					d = dir;
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				int cx = curX - reverseDx[d];
				int cy = curY - reverseDy[d];
				
				if(map[cy][cx] == 1) {
					break;
				}
				curX = cx;
				curY = cy;
				continue;
			}
		}
		return count;
	}
	
	
	static boolean isNotBoundary(int x, int y) {
		return x == 0 || x == M-1 || y == 0 || y == N-1;
	}
}