import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Student[][] arr;
	static Map<Integer, Student> studentList;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		studentList = new LinkedHashMap<>();

		arr = new Student[N][N];

		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Student cur = new Student();
			cur.num = Integer.parseInt(st.nextToken());
			cur.favorite = new int[4];
			for (int j = 0; j < 4; j++) {
				cur.favorite[j] = Integer.parseInt(st.nextToken());
			}
			studentList.put(cur.num, cur);
		}

		for (Map.Entry<Integer, Student> entry : studentList.entrySet()) {
			Student cur = entry.getValue();

			PriorityQueue<int[]> sitPq = new PriorityQueue<>((i1, i2) -> {
				if (i1[1] != i2[1]) {
					return i1[1] - i2[1];
				}
				return i1[0] - i2[0];
			});

			int[][] count = new int[N][N];
			int maxCount = 0;
			for (int i : cur.favorite) {
				if (studentList.get(i).sit) {
					Student favoriteMember = studentList.get(i);
					for (int j = 0; j < 4; j++) {
						int curX = favoriteMember.x + dx[j];
						int curY = favoriteMember.y + dy[j];
						if (!isBoundary(curX, curY)) {
							continue;
						}

						if (arr[curY][curX] != null) {
							continue;
						}

						count[curY][curX]++;
						
						if(maxCount < count[curY][curX]) {
							sitPq.clear();
							sitPq.add(new int[] {curX, curY});
							maxCount = count[curY][curX];
						}
						if(maxCount == count[curY][curX]) {
							sitPq.add(new int[] {curX, curY});
						}
					}
				}
			}
			
			boolean flag = true;
			if (sitPq.isEmpty()) {
				PriorityQueue<int[]> sitPq2 = new PriorityQueue<>((i1, i2) -> {
					if (i1[2] != i2[2]) {
						return i2[2] - i1[2];
					}
					if (i1[1] != i2[1]) {
						return i1[1] - i2[1];
					}
					return i1[0] - i2[0];
				});

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int c = 0;
						if (arr[i][j] != null) {
							continue;
						}
						for (int k = 0; k < 4; k++) {
							int curY = i + dy[k];
							int curX = j + dx[k];
							if (!isBoundary(curX, curY)) {
								continue;
							}
							if (arr[curY][curX] != null) {
								continue;
							}

							c++;
						}
						sitPq2.add(new int[] { j, i, c });
					}
				}

				sitPq = sitPq2;
				flag = false;
			}
			
			// 절친이 안앉았다면
			// 1을 만족하는 게 여러개라면.
			if (sitPq.size() > 1 && flag) {
				PriorityQueue<int[]> sitPq2 = new PriorityQueue<>((i1, i2) -> {
					if (i1[2] != i2[2]) {
						return i2[2] - i1[2];
					}
					if (i1[1] != i2[1]) {
						return i1[1] - i2[1];
					}
					return i1[0] - i2[0];
				});
				for(int[] sit : sitPq) {
					int x = sit[0];
					int y = sit[1];
					int c = 0;
					
					for (int k = 0; k < 4; k++) {
						int curY = y + dy[k];
						int curX = x + dx[k];
						if (!isBoundary(curX, curY)) {
							continue;
						}
						if (arr[curY][curX] != null) {
							continue;
						}

						c++;
					}
					sitPq2.add(new int[] { x, y, c });
				}

				sitPq = sitPq2;
			}

			int[] sit = sitPq.poll();

			cur.x = sit[0];
			cur.y = sit[1];
			cur.sit = true;
			arr[cur.y][cur.x] = cur;
		}


		int sum  =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Student cur = arr[i][j];
				int count = 0;
				for (int k = 0; k < 4; k++) {
					int curX = cur.x + dx[k];
					int curY = cur.y + dy[k];

					if (!isBoundary(curX, curY)) {
						continue;
					}

					for (int z = 0; z < 4; z++) {
						if (arr[curY][curX].num == cur.favorite[z]) {
							count++;
							break;
						}
					}
				}
				if(count == 0) {
					continue;
				}
				sum += Math.pow(10, count - 1);
			}
		}

		System.out.println(sum);
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	// 학생수는 n^2명.
	// 각 학생이 좋아하는 학생 4명을 정했음.
	// 상하좌우는 인접.

	// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정함.
	// 2. 1을 만족하는 칸이 여러개면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정함.
	// 3. 2를 만족하는 칸도 여러개인 경우에는 행의 번호가 가장 작은 칸, 그런 칸도 여러개면 열의 번호가 가장 작은 칸.

	static class Student {

		int x;
		int y;
		int num;
		boolean sit;
		int[] favorite;

		Student(int a, int b, int c) {
			x = a;
			y = b;
			num = c;
		}

		Student() {
		};

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return num + "";
		}

	}
}
