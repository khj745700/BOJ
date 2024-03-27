import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
	static int[][] arr;
	static List<Integer>[][] possible;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		possible = new List[9][9];
		arr = new int[9][9];
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				possible[i][j] = new ArrayList<>(9);
			}
		}
		for(int i = 0 ; i < 9; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < 9; j++) {
				arr[i][j] = input.charAt(j)-'0';
			}
		}
		
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				for(int k = 1; k < 10; k++) {
					if(isRowPossible(j, i, k) && isColumnPossible(j, i, k) && isSquarePossible(j, i, k)) {
						possible[i][j].add(k);
					}
				}
			}
		}
		
		bt(0);
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static boolean bt(int depth) {
		if(depth == 81) {
			return true;
		}
		
		int x = depth % 9;
		int y = depth / 9;
		
		if(arr[y][x] != 0) {
			return bt(depth+1);
		}
		
		for(int i : possible[y][x]) {
			if(isRowPossible(x, y, i) && isColumnPossible(x, y, i) && isSquarePossible(x, y, i)) {
				arr[y][x] = i;
				if(bt(depth+1)) {
					return true;
				}
				arr[y][x] = 0;
			}
		}
		
		return false;
	}
	
	static boolean isRowPossible(int x, int y, int v) {
		for(int i = 0; i < 9; i++) {
			if(arr[y][i] == v) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isColumnPossible(int x, int y, int v) {
		for(int i = 0; i < 9; i++) {
			if(arr[i][x] == v) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isSquarePossible(int x, int y, int v) {
		for(int i = y/3 * 3 ; i < (y/3 * 3) +3; i++) {
			for(int j = x/3 * 3 ; j < (x/3 * 3) + 3; j++) {
				if(arr[i][j] == v) {
					return false;
				}
			}
		}
		return true;
	}
}