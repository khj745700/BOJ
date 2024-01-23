import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;



public class Main {
	static int N;
	static int M;
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		Set<Integer> set = new HashSet<>();
		for(int i = 0 ; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(!set.contains(n)) {
				arr[i] = n;
				set.add(n);
			}
		}
		arr = Arrays.stream(arr).filter(i -> i != 0).toArray();
		Arrays.sort(arr);
		backtracking(0, 0, new ArrayList<>());

	}
	
	
	static void backtracking(int depth, int start, List<Integer> list) throws IOException {
		if(depth == M) {
			for(Integer i : list) {
				bw.append(i.toString()).append(" ");
			}
			bw.newLine();
			bw.flush();
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			list.add(arr[i]);
			backtracking(depth+1, i, list);
			list.remove(list.size() - 1);
		}
	}
}