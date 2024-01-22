import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
	static int N;
	static int M;
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedHashSet<String> lhs = new LinkedHashSet<>();
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		backtracking(0, new ArrayList<>());
		for(Object s : lhs.toArray()) {
			System.out.println(s.toString());
		}
	}
	
	
	static void backtracking(int depth, List<Integer> list) throws IOException {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(Integer i : list) {
				sb.append(i).append(" ");
			}
			lhs.add(sb.toString());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			list.add(arr[i]);
			backtracking(depth+1, list);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
}