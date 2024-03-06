import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] arr;
	static int[] visited;
	static boolean[][] check;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][];
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		visited = new int[26];
		int answer = 0;
		answer = dfs(0, 0, 1, new boolean[R][C]);

		System.out.println(answer);
	}

	static int dfs(int x, int y, int depth, boolean[][] check) {
		if (visited[arr[y][x] - 'A'] == 1) {
			
			return depth - 1;
		}

		visited[arr[y][x] - 'A'] = 1;
		int max = 0;
		check[y][x] = true;
		boolean cantGo = true;
		for (int i = 0; i < 4; i++) {
			int curX = x + dx[i];
			int curY = y + dy[i];
			if (!isBoundary(curX, curY)) {
				continue;
			}
			if (check[curY][curX]) {
				continue;
			}
			cantGo = false;
			max = Math.max(dfs(curX, curY, depth + 1, check), max);
		}
		visited[arr[y][x] - 'A'] = 0;
		check[y][x] = false; 
		return cantGo ? depth : max;
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < C && 0 <= y && y < R;
	}
}
