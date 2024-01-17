import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MAX = Integer.MIN_VALUE;
	static int[] arr;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		backtracking(0, new ArrayList<>());
		System.out.println(MAX);
	}
	
	
	
	static void backtracking(int depth, List<Integer> list) {
		if(depth == N) {
			int sum = 0;
			for(int i = 0 ; i < list.size() - 1; i++) {
				int l = list.get(i);
				int r = list.get(i + 1);
				sum += Math.abs(l - r);
			}
			MAX =Math.max(sum, MAX);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				list.add(arr[i]);
				visited[i] = true;
				backtracking(depth+1, list);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}
}
