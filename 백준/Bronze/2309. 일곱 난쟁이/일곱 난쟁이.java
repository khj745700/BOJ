import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		
		for(int i = 0 ; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		backtracking(0, 0, new ArrayList<>());
		
	}
	
	public static boolean backtracking(int depth, int start, List<Integer> list) {
		if(depth == 7 ) {
			if(sum(list) == 100) {
				Collections.sort(list);
				for(Integer i : list) {
					System.out.println(i);
				}
				return true;
			}
			return false;
		}
		
		for(int i = start ; i < 9; i ++) {
			list.add(arr[i]);
			if(backtracking(depth + 1, i + 1, list)) {
				return true;
			}
			list.remove(list.size() - 1);
		}
		
		return false;
	}
	
	
	public static int sum(List<Integer> list) {
		int sum = 0;
		for(Integer i : list) {
			sum += i;
		}
		
		return sum;
	}
}