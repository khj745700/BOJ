
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
	static int[] arr;
	static int N;
	static int depth;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		depth = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		backtracking(0, 0, new ArrayList<>());
		bw.flush();
	}
	
	
	static void backtracking(int start, int dep, List<Integer> list ) throws IOException {
		if(dep == depth) {
			for(int i = 0; i < depth; i++) {
				bw.append(list.get(i).toString()).append(" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = start; i < N; i++) {
			list.add(arr[i]);
			backtracking(i + 1, dep+1, list);
			list.remove(list.size() - 1);
		}
	}
}