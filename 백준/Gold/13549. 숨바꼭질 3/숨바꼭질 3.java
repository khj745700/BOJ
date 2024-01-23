import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int count = Integer.MAX_VALUE;
	static int start;
	static int end;
	static boolean[] visited;
	static int MAX = 100000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		visited = new boolean[MAX + 1];
		bfs();
		System.out.println(count);
	}
	
	
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			visited[cur[0]] = true;
			if(cur[0] == end) count = Math.min(count, cur[1]);
			
			if(cur[0] * 2 <= MAX && visited[cur[0] * 2]== false) {
				q.add(new int[] {cur[0] * 2, cur[1]});
			}
			
			if(cur[0] + 1 <= MAX && visited[cur[0] + 1]== false) {
				q.add(new int[] {cur[0] + 1, cur[1] + 1});
			}
			
			if(cur[0] - 1 >= 0 && visited[cur[0] - 1]== false) {
				q.add(new int[] {cur[0] - 1, cur[1] + 1});
			}
		}
		
	}
}