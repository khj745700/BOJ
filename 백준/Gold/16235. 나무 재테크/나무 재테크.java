import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] yangboon;
	static int[][] map;
	static List<Tree> trees;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		yangboon = new int[N][N];
		map = new int[N][N];
		trees = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				yangboon[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			Tree newTree = new Tree(x, y, age);
			trees.add(newTree);
		}
		trees.sort(null);
		System.out.println(simulation());
	}

	static int simulation() {
		ArrayDeque<Tree> pq = new ArrayDeque<>(trees);
		
		int year = 0;
		while (year != K) {
			int size = pq.size();
			Queue<Tree> deadQ = new ArrayDeque<>();
			Queue<Tree> imsinQ = new ArrayDeque<>();
			while (size --> 0) {
				Tree cur = pq.poll();
				if (cur.age > map[cur.y][cur.x]) {
					deadQ.add(cur);
					continue;
				} else {
					map[cur.y][cur.x] -= cur.age;
					cur.age++;
					pq.add(cur);
				}

				if (cur.age % 5 == 0) {
					imsinQ.add(cur);
				}
			}

			for (Tree cur : deadQ) {
				map[cur.y][cur.x] += cur.age / 2;
			}

			for (Tree cur : imsinQ) {
				for (int i = 0; i < 8; i++) {
					int curX = cur.x + dx[i];
					int curY = cur.y + dy[i];

					if (isNotBoundary(curX, curY)) {
						continue;
					}

					pq.addFirst(new Tree(curX, curY, 1));
				}
			}

			addYangboon();
			year++;
		}
		return pq.size();
	}

	static boolean isNotBoundary(int x, int y) {
		return x == -1 || x == N || y == -1 || y == N;
	}

	static void addYangboon() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += yangboon[i][j];
			}
		}
	}

	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;

		Tree(int a, int b, int c) {
			x = a;
			y = b;
			age = c;
		}

		public int compareTo(Tree t) {
			return age - t.age;
		}
	}
}