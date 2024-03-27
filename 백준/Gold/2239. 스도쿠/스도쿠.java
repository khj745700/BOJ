import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		arr = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}

		bt(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static boolean bt(int depth) {
		if (depth == 81) {
			return true;
		}

		int x = depth % 9;
		int y = depth / 9;

		if (arr[y][x] != 0) {
			return bt(depth + 1);
		}
		
		int possible = (isRowPossible(x, y) | isColumnPossible(x, y) | isSquarePossible(x, y));
		if(possible == 0) {
			return false;
		}
		for (int i = 1; i < 10; i++) {
			if ((possible & (1 << i)) != 0) {
				continue;
			}
			arr[y][x] = i;
			if (bt(depth + 1)) {
				return true;
			}
			arr[y][x] = 0;

		}
		return false;
	}

	static int isRowPossible(int x, int y) {
		int result = 0;
		for (int i = 0; i < 9; i++) {
			if (arr[y][i] != 0) {
				result |= (1 << arr[y][i]);
			}
		}
		return result;
	}

	static int isColumnPossible(int x, int y) {
		int result = 0;
		for (int i = 0; i < 9; i++) {
			if (arr[i][x] != 0) {
				result |= (1 << arr[i][x]);
			}
		}
		return result;
	}

	static int isSquarePossible(int x, int y) {
		int result = 0;
		for(int i = y/3 * 3 ; i < (y/3 * 3) +3; i++) {
			for(int j = x/3 * 3 ; j < (x/3 * 3) + 3; j++) {
				if(arr[i][j] != 0) {
					result |= (1 << arr[i][j]);
				}
			}
		}
		return result;
	}
}