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

		System.out.println(simulation());
	}

	static int simulation() {
		PriorityQueue<Tree> pq = new PriorityQueue<>(trees);
		Queue<Tree> deadQ = new ArrayDeque<>();
		Queue<Tree> imsinQ = new ArrayDeque<>();
		int year = 0;
		while (year != K) {
			PriorityQueue<Tree> nextQ = new PriorityQueue<>();

			while (!pq.isEmpty()) {
				Tree cur = pq.poll();
				if (cur.age > map[cur.y][cur.x]) {
					deadQ.add(cur);
					continue;
				} else {
					map[cur.y][cur.x] -= cur.age;
					cur.age++;
					nextQ.add(cur);
				}

				if (cur.age % 5 == 0) {
					imsinQ.add(cur);
				}
			}

			while (!deadQ.isEmpty()) {
				Tree cur = deadQ.poll();
				map[cur.y][cur.x] += cur.age / 2;
			}

			while (!imsinQ.isEmpty()) {
				Tree cur = imsinQ.poll();

				for (int i = 0; i < 8; i++) {
					int curX = cur.x + dx[i];
					int curY = cur.y + dy[i];

					if (isNotBoundary(curX, curY)) {
						continue;
					}

					nextQ.add(new Tree(curX, curY, 1));
				}
			}

			addYangboon();
			pq = nextQ;
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

	/*
	 * 가장 처음에 양분은 모든 칸에 5만큼 들어있음.
	 * 
	 * M개의 나무를 구매해 땅에 심음. 1 x 1 크기의 칸에 여러 개의 나무가 심어져 있을 수 있음.
	 * 
	 * 봄 나무가 자신의 나이만큼 양분을 먹고, 나이 1 증가. 본인의 칸에 있는 양분만 먹을 수 있음. 하나의 칸에 여러 개의 나무가 있다면,
	 * 나이가 어린 나무부터 먹음. 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없다면, 즉시 죽음.
	 * 
	 * 
	 * 여름 봄에 죽은 나무가 양분으로 변함. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가됨. 소수점 아래는
	 * 버림.
	 * 
	 * 가을 나무가 번식함. 번식하는 나무는 나이가 5의 배수여야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생김. 땅을 벗어난다면, 그
	 * 칸에는 나무가 생기지 않음.
	 * 
	 * 겨울 땅에 양분을 추가함. 각 칸에 추가되는 양분의 양은 A[r][c] 이고, 입력으로 주어짐.
	 * 
	 * 
	 */
}