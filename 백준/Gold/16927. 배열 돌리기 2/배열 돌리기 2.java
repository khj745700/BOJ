import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < Math.min(N, M) / 2; i++) {
			int[] startIdx = getStartIdx(i);
			int[] endIdx = getEndIdx(i);
			for(int j = 0 ; j < R % ((endIdx[0] - startIdx[0]) * 2 + (endIdx[1] - startIdx[1]) * 2 ); j++) {
				rotate(startIdx[0], startIdx[1], endIdx[0], endIdx[1]);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void rotate(int startX, int startY, int endX, int endY) {
		int d = 0;
		int x = startX;
		int y = startY;
		int next = arr[y][x];
		while(true) {
			int nextY = y + dy[d], nextX = x + dx[d];
			if(nextX < startX || nextX > endX || nextY < startY || nextY > endY) {
				d++;
				if(d > 3) {
					break;
				}
			}else {
				int temp = arr[nextY][nextX];
				arr[nextY][nextX] = next;
				next = temp;
				y = nextY;
				x = nextX;
			}
		}
	}
	
	
	
	static int[] getStartIdx(int depth) {
		return new int[] {depth, depth};
	}
	
	static int[] getEndIdx(int depth) {
		return new int[] {M-1-depth, N-1-depth};
	}
}
